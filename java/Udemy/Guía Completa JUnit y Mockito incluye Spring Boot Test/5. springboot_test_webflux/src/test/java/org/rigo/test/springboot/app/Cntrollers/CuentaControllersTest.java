package org.rigo.test.springboot.app.Cntrollers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.rigo.test.springboot.app.models.Cuenta;
import org.rigo.test.springboot.app.models.TransaccionDto;
import org.rigo.test.springboot.app.services.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

// Importaciones de utilidades para pruebas
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*; // Validaciones de respuestas HTTP
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*; // Métodos para construir solicitudes HTTP
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*; // Métodos de simulación con Mockito
import static org.rigo.test.springboot.app.Datos.*; // Datos de prueba (definidos en otro archivo)


@WebMvcTest(CuentaControllers.class) // Anotación que configura el entorno de prueba solo para los controladores indicados
class CuentaControllersTest {

    // Inyección del objeto MockMvc, que simula un entorno de servidor para realizar pruebas HTTP
    @Autowired
    private MockMvc mvc;

    // Simulación del servicio "CuentaService", que será inyectado en el controlador durante las pruebas
    @MockBean
    private CuentaService cuentaService;

    ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
    }

    @Test
    void TestDetalleCuenta() throws Exception {
        // Given: configuración inicial de la prueba
        when(cuentaService.findById(1L)).thenReturn(createCuenta001().orElseThrow());

        // When: realiza una solicitud GET al endpoint "/api/cuenta/1"
        mvc.perform(get("/api/cuenta/1") // Realiza una solicitud HTTP GET al endpoint
                        .contentType(MediaType.APPLICATION_JSON)) // Especifica el tipo de contenido de la solicitud
                // Then: validaciones sobre la respuesta
                .andExpect(status().isOk()) // Verifica que el estado HTTP sea 200 (OK)
                .andExpect(content().contentType(MediaType.APPLICATION_JSON)) // Verifica que el contenido sea JSON
                .andExpect(jsonPath("$.persona").value("Rigo")) // Verifica que el campo "persona" tenga el valor "Rigo"
                .andExpect(jsonPath("$.saldo").value("1000")); // Verifica que el campo "saldo" tenga el valor "1000"

        verify(cuentaService).findById(1L);
    }

    @Test
    void TestTransferirCuentas() throws Exception {

        //Given
        TransaccionDto dto = new TransaccionDto();
        dto.setCuentaOrigenId(1L);
        dto.setCuentaDestinoId(2L);
        dto.setMonto(new BigDecimal("100.00"));
        dto.setBandoId(1L);

        System.out.println(objectMapper.writeValueAsString(dto));

        Map<String, Object> response = new HashMap<>();
        response.put("date", LocalDate.now().toString());
        response.put("status", HttpStatus.CREATED);
        response.put("message", "Transfer completo");
        response.put("data", dto);

        System.out.println(objectMapper.writeValueAsString(response));

        //when
        mvc.perform(post("/api/cuenta/transferir")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)))

        //then
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.date").value(LocalDate.now().toString()))
                .andExpect(jsonPath("$.message").value("Transfer completo"))
                .andExpect(jsonPath("$.data.cuentaOrigenId").value(dto.getCuentaOrigenId()))
                .andExpect(content().json(objectMapper.writeValueAsString(response)));

    }

    @Test
    void testListarCuentas() throws Exception {

        //given
        List<Cuenta> cuentas = Arrays.asList(createCuenta001().orElseThrow(), createCuenta002().orElseThrow());
        when(cuentaService.findAll()).thenReturn(cuentas);

        mvc.perform(get("/api/cuenta").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].persona").value("Rigo"))
                .andExpect(jsonPath("$[1].persona").value("Jesus"))
                .andExpect(jsonPath("$[0].saldo").value("1000"))
                .andExpect(jsonPath("$[1].saldo").value("23000"))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(content().json(objectMapper.writeValueAsString(cuentas)));

        verify(cuentaService).findAll();

    }


    @Test
    void testGuardar() throws Exception {

        //Given
        Cuenta cuenta = new Cuenta(null, "Pepe", new BigDecimal("3000"));
        when(cuentaService.save(any())).then(invocation -> {
            Cuenta newCuenta = invocation.getArgument(0);
            newCuenta.setId(3L);
            return newCuenta;
        });

        //when
        //Con el siguiente metodo se los datos de "cuenta"
        mvc.perform(post("/api/cuenta").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(cuenta)))
                //then
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is(3)))
                .andExpect(jsonPath("$.persona", is("Pepe")))
                .andExpect(jsonPath("$.saldo", is(3000)));

        verify(cuentaService).save(any());

    }


}
