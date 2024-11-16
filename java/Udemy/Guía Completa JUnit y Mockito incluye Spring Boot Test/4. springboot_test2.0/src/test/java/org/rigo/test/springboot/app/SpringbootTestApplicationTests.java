package org.rigo.test.springboot.app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.rigo.test.springboot.app.exceptions.DIneroInsuficienteException;
import org.rigo.test.springboot.app.models.Banco;
import org.rigo.test.springboot.app.models.Cuenta;
import org.rigo.test.springboot.app.repositories.BancoRepository;
import org.rigo.test.springboot.app.repositories.CuentaRepository;
import org.rigo.test.springboot.app.services.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.rigo.test.springboot.app.Datos.*;

@SpringBootTest
class SpringbootTestApplicationTests {


	@MockBean
	CuentaRepository cuentaRepository;
	@MockBean
	BancoRepository bancoRepository;

	@Autowired
	CuentaService service;

	@BeforeEach
	void setUp() {
		/*
		//Reinicar saldo despues de cada prueba
		Datos.CUENTA_001.setSaldo(new BigDecimal("1000"));
		Datos.CUENTA_002.setSaldo(new BigDecimal("23000"));
		Datos.BANCO.setTotalTranferencia(0);

		cuentaRepository = mock(CuentaRepository.class);
		bancoRepository = mock(BancoRepository.class);
		service = new CuentaServiceImpl(cuentaRepository, bancoRepository);
		*/

	}



	@Test
	void contextLoads(){
		//Asignan valores a las pruebas
		when(cuentaRepository.findById(1L)).thenReturn(createCuenta001()); //llamamos metodos estaticos para no modificar datos
		when(cuentaRepository.findById(2L)).thenReturn(createCuenta002());
		when(bancoRepository.findById(1L)).thenReturn(createBanco());

		//se obtienen los valores de los saldos
		BigDecimal saldoOrigen = service.revisarSaldo(1L);
		BigDecimal saldoDestino = service.revisarSaldo(2L);

		//se verifica los valores de los saldos
		assertEquals("1000", saldoOrigen.toPlainString());
		assertEquals("23000", saldoDestino.toPlainString());

		//se usa el mock de transferir
		service.tranferir(1L, 2L, new BigDecimal("100"),1L);

		//Se obtienen los saldos despues de cada transaccion
		 saldoOrigen = service.revisarSaldo(1L);
		 saldoDestino = service.revisarSaldo(2L);

		 int total = service.revisarTotalTranferencia(1L);
		 assertEquals(1, total);

		 //se verifica si el valor de las transaccion sean los correctos
		 assertEquals("900", saldoOrigen.toPlainString());
		 assertEquals("23100", saldoDestino.toPlainString());

		 //Se verfica cuantas veces se invocaron los metodos
		 verify(cuentaRepository, times(3)).findById(1L);
		 verify(cuentaRepository, times(3)).findById(2L);
		 verify(cuentaRepository, times(2)).save(any(Cuenta.class));
		 //por defecto time es uno y por eso no se coloca
		 verify(bancoRepository, times(2)).findById(1L);
		 verify(bancoRepository).save(any(Banco.class));

		 verify(cuentaRepository, times(6)).findById(anyLong());
		 verify(cuentaRepository, never()).findAll();
	}

	//Probando expeciones
	@Test
	void contextLoads2(){
		//Asignan valores a las pruebas
		when(cuentaRepository.findById(1L)).thenReturn(createCuenta001());
		when(cuentaRepository.findById(2L)).thenReturn(createCuenta002());
		when(bancoRepository.findById(1L)).thenReturn(createBanco());

		//se obtienen los valores de los saldos
		BigDecimal saldoOrigen = service.revisarSaldo(1L);
		BigDecimal saldoDestino = service.revisarSaldo(2L);

		//se verifica los valores de los saldos
		assertEquals("1000", saldoOrigen.toPlainString());
		assertEquals("23000", saldoDestino.toPlainString());

		assertThrows(DIneroInsuficienteException.class, ()-> {
			service.tranferir(1L, 2L, new BigDecimal("1200"),1L);

		});

		//se usa el mock de transferir

		//Se obtienen los saldos despues de cada transaccion
		saldoOrigen = service.revisarSaldo(1L);
		saldoDestino = service.revisarSaldo(2L);

		int total = service.revisarTotalTranferencia(1L);
		assertEquals(0, total);

		//se verifica si el valor de las transaccion sean los correctos
		assertEquals("1000", saldoOrigen.toPlainString());
		assertEquals("23000", saldoDestino.toPlainString());

		//Se verfica cuantas veces se invocaron los metodos
		verify(cuentaRepository, times(3)).findById(1L);
		verify(cuentaRepository, times(2)).findById(2L);
		verify(cuentaRepository, never()).save(any(Cuenta.class));

		verify(bancoRepository, times(1)).findById(1L);
		verify(bancoRepository, never()).save(any(Banco.class));

		verify(cuentaRepository, times(5)).findById(anyLong());
		verify(cuentaRepository, never()).findAll();

	}

	@Test
	//Verificar si las 2 cuentas son iguales
	void contextLoads3(){
		when(cuentaRepository.findById(1L)).thenReturn(createCuenta001());

		Cuenta cuenta1 = service.findById(1L);
		Cuenta cuenta2 = service.findById(1L);

		assertSame(cuenta1, cuenta2);
		assertTrue(cuenta1.equals(cuenta2));
		assertEquals(cuenta1, cuenta2);

		verify(cuentaRepository, times(2)).findById(1L);
	}

	@Test
	void testFindAll(){

		//given
		List<Cuenta> cuentas = Arrays.asList(createCuenta002().orElseThrow(), createCuenta002().orElseThrow());
		when(cuentaRepository.findAll()).thenReturn(cuentas);

		//when
		List<Cuenta> cuentasRetorno = service.findAll();

		//then
		assertFalse(cuentasRetorno.isEmpty());
		assertEquals(cuentas, cuentasRetorno);
		assertEquals(cuentas.size(), cuentasRetorno.size());
		assertTrue(cuentasRetorno.contains(createCuenta002().orElseThrow()));

		verify(cuentaRepository).findAll();
	}

	@Test
	void testSave(){

		Cuenta cuentaSave = new Cuenta(null, "Copito", new BigDecimal("121212"));

		when(cuentaRepository.save(any())).then(invocation -> {

			Cuenta cuentaRetorno = invocation.getArgument(0);
			cuentaSave.setId(3L);
			return cuentaRetorno;
		});

		//when
		Cuenta cuenta = service.save(cuentaSave);

		//then
		assertEquals(3, cuenta.getId());
		assertEquals("121212", cuenta.getSaldo().toPlainString());
		verify(cuentaRepository).save(any(Cuenta.class));
	}
}
