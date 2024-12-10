package org.rigo.test.springboot.app;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.rigo.test.springboot.app.models.Cuenta;
import org.rigo.test.springboot.app.repositories.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@DataJpaTest
public class IntegracionJpaTest {

    @Autowired
    CuentaRepository cuentaRepository;

    @Test
    void testFindById() {

        Optional<Cuenta> cuenta = cuentaRepository.findById(1L);

        assertTrue(cuenta.isPresent());
        assertEquals("Rigo", cuenta.orElseThrow().getPersona());
    }

    @Test
    void testFindByPersona() {

        Optional<Cuenta> cuenta = cuentaRepository.findByPersona("Rigo");

        assertTrue(cuenta.isPresent());
        assertEquals("Rigo", cuenta.orElseThrow().getPersona());
        assertEquals("1000.00", cuenta.orElseThrow().getSaldo().toPlainString());
    }

    @Test
    void testFindByPersonaThowException() {

        Optional<Cuenta> cuenta = cuentaRepository.findByPersona("Rigoberto");

        assertThrows(NoSuchElementException.class, cuenta::orElseThrow);
        assertFalse(cuenta.isPresent());
    }

    @Test
    void testFindAll() {
        List<Cuenta> cuentas = cuentaRepository.findAll();

        assertFalse(cuentas.isEmpty());
        assertEquals(2, cuentas.size());

    }

    @Test
    void testSave() {

        //given
        Cuenta cuentaPepe = new Cuenta(null, "pepe", new BigDecimal("1000.00"));


        //when
        Cuenta cuenta = cuentaRepository.save(cuentaPepe);
        //Cuenta cuenta = cuentaRepository.findByPersona("pepe").orElseThrow();
        //Cuenta cuenta = cuentaRepository.findById(save.getId()).orElseThrow();

        //then
        assertEquals("pepe", cuenta.getPersona());
        assertEquals("1000.00", cuenta.getSaldo().toPlainString());
        assertEquals("pepe", cuenta.getPersona());
    }


    @Test
    void testUpdate() {

        //given
        Cuenta cuentaPepe = new Cuenta(null, "pepe", new BigDecimal("1000.00"));

        //when
        Cuenta cuenta = cuentaRepository.save(cuentaPepe);
        cuenta.setSaldo(new BigDecimal("2000.00"));
        Cuenta cuentaActualizada = cuentaRepository.save(cuenta);

        //then
        assertEquals("pepe", cuentaActualizada.getPersona());
        assertEquals("2000.00", cuentaActualizada.getSaldo().toPlainString());
        assertEquals("pepe", cuentaActualizada.getPersona());
    }

    @Test
    void testDelete() {
        Cuenta cuenta = cuentaRepository.findById(2L).orElseThrow();
        assertEquals("Jesus", cuenta.getPersona());

        cuentaRepository.delete(cuenta);

        assertThrows(NoSuchElementException.class, () -> {
            cuentaRepository.findByPersona("Jesus").orElseThrow();
            cuentaRepository.findById(2L).orElseThrow();
        });
        assertEquals(1, cuentaRepository.count());
    }


}
