package org.rigo.test.springboot.app.Cntrollers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.rigo.test.springboot.app.models.Cuenta;
import org.rigo.test.springboot.app.models.TransaccionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de pruebas que utiliza TestRestTemplate para realizar peticiones HTTP
 * y verificar el comportamiento del controlador de cuentas.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class) // Permite ejecutar los tests en un orden específico
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // Levanta un servidor en un puerto aleatorio para las pruebas
class CuentaControllersTestRestTemplateTest {

    @Autowired
    private TestRestTemplate restTemplate; // Cliente HTTP de pruebas para interactuar con la API

    private ObjectMapper objectMapper; // Mapper para convertir objetos a JSON y viceversa

    @LocalServerPort
    private int puerto; // Puerto asignado aleatoriamente por Spring Boot para las pruebas

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper(); // Inicialización del ObjectMapper
    }

    private String crearUri(String uri) {
        return "http://localhost:" + puerto + uri;
    }

    /**
     * Prueba para verificar el endpoint de transferencia de dinero entre cuentas.
     */
    @Test
    @Order(1)
    void testTranferir() throws Exception {
        // given: Preparación de los datos necesarios para la prueba
        TransaccionDto transaccionDto = new TransaccionDto();
        transaccionDto.setMonto(new BigDecimal("100")); // Monto de la transferencia
        transaccionDto.setCuentaOrigenId(2L); // ID de la cuenta origen
        transaccionDto.setCuentaDestinoId(1L); // ID de la cuenta destino
        transaccionDto.setBandoId(1L); // ID del banco

        // when: Realización de la petición POST al endpoint de transferencia
        ResponseEntity<String> responseEntity = restTemplate
                .postForEntity(crearUri("/api/cuenta/transferir"), transaccionDto, String.class);

        // Debug: Imprime el puerto en consola para verificar el contexto
        System.out.println(puerto);

        // Obtiene el cuerpo de la respuesta como JSON
        String json = responseEntity.getBody();

        // then: Verificaciones
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode()); // La respuesta debe tener un estado HTTP 200 OK
        assertEquals(MediaType.APPLICATION_JSON, responseEntity.getHeaders().getContentType()); // El contenido debe ser JSON
        assertNotNull(json); // El cuerpo de la respuesta no debe ser nulo
        assertTrue(json.contains("Transfer completo")); // Verifica que el mensaje esperado esté presente
        assertTrue(json.contains("{\"cuentaOrigenId\":2,\"cuentaDestinoId\":1,\"monto\":100,\"bandoId\":1}")); // Verifica que los datos sean correctos

        JsonNode jsonNode = objectMapper.readTree(json);
        assertEquals("Transfer completo", jsonNode.path("message").asText());
        assertEquals(LocalDate.now().toString(), jsonNode.path("date").asText());
        assertEquals("100", jsonNode.path("data").path("monto").asText());
        assertEquals(2L, jsonNode.path("data").path("cuentaOrigenId").asLong());


        Map<String, Object> responseController = new HashMap<>();
        responseController.put("date", LocalDate.now().toString());
        responseController.put("status", HttpStatus.CREATED);
        responseController.put("message", "Transfer completo");
        responseController.put("data", transaccionDto);

        assertEquals(objectMapper.writeValueAsString(responseController), json);
    }

    @Test
    @Order(2)
    void testDetallePoprId() throws Exception {

        ResponseEntity<Cuenta> responseEntity = restTemplate.getForEntity(crearUri("/api/cuenta/1"), Cuenta.class);
        Cuenta cuenta = responseEntity.getBody();
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(MediaType.APPLICATION_JSON, responseEntity.getHeaders().getContentType());

        assertNotNull(cuenta);
        assertEquals(1L, cuenta.getId());
        assertEquals("Rigo", cuenta.getPersona());
        assertEquals("1100.00", cuenta.getSaldo().toPlainString());
        assertEquals(new Cuenta(1L, "Rigo", new BigDecimal("1100.00")), cuenta);

    }

    @Test
    @Order(3)
    void testListar() throws Exception {

        ResponseEntity<Cuenta[]> responseEntity = restTemplate.getForEntity(crearUri("/api/cuenta"), Cuenta[].class);

        List<Cuenta> cuentas = Arrays.asList(responseEntity.getBody());

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(MediaType.APPLICATION_JSON, responseEntity.getHeaders().getContentType());
        assertNotNull(cuentas);

        assertEquals(2, cuentas.size());
        assertEquals(1L, cuentas.get(0).getId());
        assertEquals("Rigo", cuentas.get(0).getPersona());
        assertEquals("1100.00", cuentas.get(0).getSaldo().toPlainString());
         assertEquals(2L, cuentas.get(1).getId());
        assertEquals("Jesus", cuentas.get(1).getPersona());
        assertEquals("22900.00", cuentas.get(1).getSaldo().toPlainString());

        JsonNode jsonNode = objectMapper.readTree(objectMapper.writeValueAsString(cuentas));
        assertEquals(1L, jsonNode.get(0).path("id").asLong());
        assertEquals("Rigo", jsonNode.get(0).path("persona").asText());
        assertEquals("1100.0", jsonNode.get(0).path("saldo").asText());
        assertEquals(2L, jsonNode.get(1).path("id").asLong());
        assertEquals("Jesus", jsonNode.get(1).path("persona").asText());
        assertEquals("22900.0", jsonNode.get(1).path("saldo").asText());

    }

    @Test
    @Order(4)
    void testCrear() throws Exception {

        Cuenta cuenta = new Cuenta(null, "Peppa", new BigDecimal("1100.00"));

        ResponseEntity<Cuenta> responseEntity = restTemplate.postForEntity(crearUri("/api/cuenta"), cuenta, Cuenta.class);
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(MediaType.APPLICATION_JSON, responseEntity.getHeaders().getContentType());

        Cuenta cuentaSave = responseEntity.getBody();

        assertNotNull(cuenta);
        assertEquals(3L, cuentaSave.getId());
        assertEquals("Peppa", cuentaSave.getPersona());
        assertEquals("1100.00", cuentaSave.getSaldo().toPlainString());

    }

    @Test
    @Order(5)
    void testEliminar() throws Exception {

        ResponseEntity<Cuenta[]> responseEntity = restTemplate.getForEntity(crearUri("/api/cuenta"), Cuenta[].class);
        List<Cuenta> cuentas = Arrays.asList(responseEntity.getBody());
        assertEquals(3, cuentas.size());

         //restTemplate.delete(crearUri("/api/cuenta/3"));
        Map<String,Long> pahtVariable = new HashMap<>();
        pahtVariable.put("id",3L);

        ResponseEntity<Void> exchange = restTemplate.exchange(crearUri("/api/cuenta/{id}"), HttpMethod.DELETE, null, Void.class, pahtVariable);
        assertEquals(HttpStatus.NO_CONTENT, exchange.getStatusCode());
        assertFalse(exchange.hasBody());

        responseEntity = restTemplate.getForEntity(crearUri("/api/cuenta"), Cuenta[].class);
        cuentas = Arrays.asList(responseEntity.getBody());
        assertEquals(2, cuentas.size());

        ResponseEntity<Cuenta> responseEntityForId = restTemplate.getForEntity(crearUri("/api/cuenta/3"), Cuenta.class);
        assertEquals(HttpStatus.NOT_FOUND, responseEntityForId.getStatusCode());
        assertFalse(responseEntityForId.hasBody());


    }
}
