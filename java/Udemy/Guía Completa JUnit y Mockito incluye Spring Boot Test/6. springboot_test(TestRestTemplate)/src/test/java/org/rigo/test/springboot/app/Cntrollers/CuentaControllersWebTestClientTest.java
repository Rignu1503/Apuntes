package org.rigo.test.springboot.app.Cntrollers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.internal.filter.ValueNodes;
import org.junit.jupiter.api.*;
import org.rigo.test.springboot.app.models.Cuenta;
import org.rigo.test.springboot.app.models.TransaccionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//De forma automatica levanta un puerto para los test
@SpringBootTest(webEnvironment = RANDOM_PORT)
class CuentaControllersWebTestClientTest {

    private ObjectMapper mapper;
    @Autowired
    private WebTestClient client;

    @BeforeEach
    void setUp() {
        mapper = new ObjectMapper(); // Inicializa correctamente el ObjectMapper
    }


    @Test
    @Order(1)
    void testTransferir() throws Exception {

        //given
        TransaccionDto dto = new TransaccionDto();
        dto.setCuentaOrigenId(1L);
        dto.setCuentaDestinoId(2L);
        dto.setBandoId(1L);
        dto.setMonto(new BigDecimal("100"));

        Map<String, Object> response = new HashMap<>();
        response.put("date", LocalDate.now().toString());
        response.put("status", HttpStatus.CREATED);
        response.put("message", "Transfer completo");
        response.put("data", dto);


        //when
        client.post().uri("/api/cuenta//transferir")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(dto)
                //Hace la peticion y despues tenemos la respuesta
                .exchange()
        //Then
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody()

                .consumeWith(r -> {
                    try {
                        JsonNode node = mapper.readTree(r.getResponseBody());
                        assertEquals("Transfer completo", node.path("message").asText());
                        assertEquals(1L, node.path("data").path("cuentaOrigenId").asLong());
                        assertEquals(LocalDate.now().toString(), node.path("date").asText());
                        assertEquals("100",node.path("data").path("monto").asText());

                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                })

                .jsonPath("$.message").isNotEmpty()
                .jsonPath("$.message").value(is("Transfer completo"))
                .jsonPath("$.message").value( valor -> assertEquals("Transfer completo", valor))
                .jsonPath("$.data.cuentaOrigenId").isEqualTo(dto.getCuentaOrigenId())
                .jsonPath("$.date").isEqualTo(LocalDate.now().toString())
                .json(mapper.writeValueAsString(response));


    }

    @Test
    @Order(2)
    void testTetalleCuenta() throws Exception {

        Cuenta cuenta = new Cuenta(1L, "Rigo", new BigDecimal("900.00"));
        client.get().uri("api/cuenta/1").exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody()
                .jsonPath("$.persona").isEqualTo("Rigo")
                .jsonPath("$.saldo").isEqualTo("900.0")
                .json(mapper.writeValueAsString(cuenta));
    }

    @Test
    @Order(3)
    void testTetalleCuenta2() {

        client.get().uri("api/cuenta/2").exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody(Cuenta.class)
                .consumeWith(response -> {
                    Cuenta cuenta = response.getResponseBody();
                    assertEquals("Jesus", cuenta.getPersona());
                    assertEquals("23100.00", cuenta.getSaldo().toPlainString());

                });
    }
    @Test
    @Order(4)
    void tesGetCuentas() {

        client.get().uri("api/cuenta").exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody()
                .jsonPath("$[0].persona").isEqualTo("Rigo")
                .jsonPath("$[0].saldo").isEqualTo(900)
                .jsonPath("$[0].id").isEqualTo("1")
                .jsonPath("$[1].persona").isEqualTo("Jesus")
                .jsonPath("$[1].saldo").isEqualTo(23100.00)
                .jsonPath("$[1].id").isEqualTo(2)
                .jsonPath("$").isArray()
                .jsonPath("$").value(hasSize(2));

    }  @Test
    @Order(5)
    void tesGetCuentas2() {

        client.get().uri("api/cuenta").exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBodyList(Cuenta.class)
                .consumeWith(response -> {
                    List<Cuenta> cuentas = response.getResponseBody();
                    assertNotNull(cuentas);
                    assertEquals(2, cuentas.size());
                    assertEquals(1L, cuentas.get(0).getId());
                    assertEquals("Rigo", cuentas.get(0).getPersona());
                    assertEquals(900, cuentas.get(0).getSaldo().intValue());
                    assertEquals(2L, cuentas.get(1).getId());
                    assertEquals("Jesus", cuentas.get(1).getPersona());
                    assertEquals(23100, cuentas.get(1).getSaldo().intValue());

                })
                .hasSize(2)
                .value(hasSize(2));

    }

    @Test
    @Order(6)
    void TestGuadar() {

        //given
        Cuenta cuenta = new Cuenta(null, "Pepi", new BigDecimal("900"));


        //when
        client.post().uri("api/cuenta")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(cuenta)//Envia al back-end con formato json
                .exchange()
        // then
                .expectStatus().isCreated()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody()
                .jsonPath("$.id").isEqualTo(3)
                .jsonPath("$.persona").value(is("Pepi"))
                .jsonPath("$.saldo").isEqualTo(900);

    }

    @Test
    @Order(7)
    void TestGuadar2() {

        //given
        Cuenta cuenta = new Cuenta(null, "Peppa", new BigDecimal("900"));


        //when
        client.post().uri("api/cuenta")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(cuenta)//Envia al back-end con formato json
                .exchange()
                // then
                .expectStatus().isCreated()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody(Cuenta.class)
                .consumeWith(response -> {
                    Cuenta c = response.getResponseBody();
                    assertNotNull(response.getResponseBody());

                    assertNotNull(cuenta);
                    assertEquals(4L, c.getId());
                    assertEquals(c.getPersona(), cuenta.getPersona());
                    assertEquals(c.getSaldo(), cuenta.getSaldo());

                });
    }

    @Test
    @Order(8)
    void testEliminar(){

        //Antes de eliminae se verifica que sean 4
        client.get().uri("api/cuenta").exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBodyList(Cuenta.class)
                .hasSize(4);

        //proceso de eliminacion
        client.delete().uri("api/cuenta/3")
                .exchange()
                .expectStatus().isNoContent()
                .expectBody().isEmpty();

        //despues de eliminar se verifica que sean 4
        client.get().uri("api/cuenta").exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBodyList(Cuenta.class)
                .hasSize(3);

        client.get().uri("api/cuenta/3").exchange()
                //.expectStatus().is5xxServerError();
                .expectStatus().isNotFound()
                .expectBody().isEmpty();
    }

}