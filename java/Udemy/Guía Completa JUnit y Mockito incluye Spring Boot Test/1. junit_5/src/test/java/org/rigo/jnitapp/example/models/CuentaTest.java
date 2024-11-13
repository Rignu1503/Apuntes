package org.rigo.jnitapp.example.models;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.rigo.jnitapp.example.exceptions.DineroInsuficienteExeption;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

class CuentaTest {

    Cuenta cuenta;
    TestInfo testInfo;
    TestReporter testReporter;

    @BeforeEach
    void initMetodoTest(TestInfo testInfo, TestReporter testReporter){
        this.cuenta = new Cuenta("Rigo", new BigDecimal("1000.00"));
        this.testInfo = testInfo;
        this.testReporter = testReporter;

        System.out.println("Iniciando el metodo");

        //Imprimir en el log de Junit5
        testReporter.publishEntry("  ejecutando: " + testInfo.getDisplayName() + " " + testInfo.getTestMethod().get().getName()
                + " con la etiqueta " + testInfo.getTags());
    }

    @AfterEach
    void tearDownMetodoTest() {
        System.out.println("Fin del metodo");
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("Iniciando el test");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Finalizando el test");
    }

    @Tag("cuenta")
    @Nested
    @DisplayName("PRobando atributos de la cuenta corriente")
    class CuentaTestNombreSaldo{


        private Cuenta cuenta;

        @Test
        @DisplayName("probando nombre")
        void testNombreCuenta() {

            String esperado = "Rigo";
            String real = cuenta.getPersona();

            assertEquals(esperado, real, () -> "El nombre de la cuenta no es el que se esperaba");
            assertTrue(real.equals("Rigo"), () -> "El nombre esperado debe ser igual a la real");

        }


        @Test
        @DisplayName("Probando el saldo de la cuenta corriente, que no sea null, mayor que cero, valor esperado")
        void testSaldoCuenta(){
            this.cuenta = new Cuenta("Rigo", new BigDecimal("1000.00"));

            System.out.println(testInfo.getTags());
            if (testInfo.getTags().contains("cuenta")){
                System.out.println("Hacer algo con la etiqueta cuenta");
            }

            assertNotNull(cuenta.getSaldo());
            assertEquals(1000.00, cuenta.getSaldo().doubleValue());
            assertFalse(cuenta.getSaldo().compareTo(BigDecimal.ZERO) < 0);
            assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);

        }

        @Test
        @DisplayName("testeando referencia con el metodo equals")
        void testReferenciaDeCuenta() {
            Cuenta cuenta = new Cuenta("John Doe", new BigDecimal("8900.00"));
            Cuenta cuenta2 = new Cuenta("John Doe", new BigDecimal("8900.00"));

            //assertNotEquals(cuenta, cuenta2);
            //Validar si son el mismo objeto
            assertEquals(cuenta, cuenta2);
        }
    }

    @Nested
    class CuentaOperacionesTest{

        @Tag("cuenta")
        @Test
        void testDebitoCuenta() {
            Cuenta cuenta = new Cuenta("Rigo", new BigDecimal("8900.00"));
            cuenta.debito(new BigDecimal(100));

            assertNotNull(cuenta.getSaldo());
            assertEquals(8800, cuenta.getSaldo().intValue());
            assertEquals("8800.00", cuenta.getSaldo().toPlainString());
        }

        @Tag("cuenta")
        @Test
        void testCreditoCuenta() {
            Cuenta cuenta = new Cuenta("Rigo", new BigDecimal("8900.00"));
            cuenta.credito(new BigDecimal(100));

            assertNotNull(cuenta.getSaldo());
            assertEquals(9000, cuenta.getSaldo().intValue());
            assertEquals("9000.00", cuenta.getSaldo().toPlainString());
        }

        @Tag("banco")
        @Tag("cuenta")
        @Test
        void testTransferirDineroCuenta() {

            Cuenta cuenta1 = new Cuenta("Rigo", new BigDecimal("8900.00"));
            Cuenta cuenta2 = new Cuenta("John Doe", new BigDecimal("1500.10"));

            Banco banco = new Banco();
            banco.setNombre("bancolombia");
            banco.transferir(cuenta1,cuenta2,new BigDecimal(500));
            assertEquals("8400.00", cuenta1.getSaldo().toPlainString());
            assertEquals("2000.10", cuenta2.getSaldo().toPlainString());
        }

    }


    /*-- Manejo de excepciones --*/
    @Test
    void  testDineroInsuficienteExceptionCuenta(){
        Cuenta cuenta = new Cuenta("Rigo", new BigDecimal("8900.00"));

        Exception exception = assertThrows(DineroInsuficienteExeption.class,() -> {
            cuenta.debito(new BigDecimal(9900));
        });

        String actual = exception.getMessage();
        String esperado = "Dinero insuficiente";
        assertEquals(actual, esperado);
    }


    @Test
    @Disabled
    @DisplayName("PRobando relaciones entre las cuentas y el banco con assertAll")
    void testRelacionBancoCuentas() {
        fail();
        Cuenta cuenta1 = new Cuenta("Rigo", new BigDecimal("8900.00"));
        Cuenta cuenta2 = new Cuenta("John Doe", new BigDecimal("1500.10"));

        Banco banco = new Banco();
        banco.addCuenta(cuenta1);
        banco.addCuenta(cuenta2);
        banco.setNombre("bancolombia");
        banco.transferir(cuenta1,cuenta2,new BigDecimal(500));

        assertAll(() -> assertEquals("8400.00", cuenta1.getSaldo().toPlainString()),
                () -> assertEquals("2000.10", cuenta2.getSaldo().toPlainString()),
                () -> assertEquals(2, banco.getCuentas().size()),
                () -> assertEquals("bancolombia", cuenta1.getBanco().getNombre()),
                () -> assertEquals("Rigo", banco.getCuentas().stream()
                        .filter(c -> c.getPersona().equals("Rigo"))
                        .findFirst()
                        .get().getPersona()),
                () -> assertTrue(banco.getCuentas().stream()
                        .anyMatch(c -> c.getPersona().equals("Rigo")))

        );
    }

    @Nested
    class SistemaOperativoTest{

        @Test
        @EnabledOnOs(OS.WINDOWS)
        void testSoloWindows(){
        }


        @Test
        @EnabledOnOs({OS.LINUX, OS.MAC})
        void testSoloLinuxMac(){
        }

        @Test
        @DisabledOnOs(OS.WINDOWS)
        void testNoWindows(){
        }



    }

    @Nested
    class javaVersionTest{

        @Test
        @EnabledOnJre(JRE.JAVA_8)
        void soloJdk8(){
        }

        @Test
        @EnabledOnJre(JRE.JAVA_18)
        void soloJdk18(){
        }

    }

    @Nested
    class SistemPropertyTest{


        @Test
        void imprimirSitemProperty(){
            Properties properties = System.getProperties();
            properties.forEach((k, v) -> System.out.println(k + ":" + v));
        }

        @Test
        @EnabledIfSystemProperty(named = "java.version", matches = ".*18.*")
        void testJavaVersion() {
        }

        @Test
        @DisabledIfSystemProperty(named = "os.arch", matches = ".*64.*")
        void testSolo64() {
        }

        @Test
        @EnabledIfSystemProperty(named = "ENV",matches = "dev")
        void testEnv() {
        }

    }

    @Nested
    class VariableAmbienteTest{

        @Test
        void imprimirVariablesAmbiente(){
            Map<String, String> getnnv = System.getenv();

            getnnv.forEach((k, v) -> System.out.println(k + ":" + v));
        }

        @Test
        @EnabledIfEnvironmentVariable(named = "PROCESSOR_ARCHITECTURE",matches = "AMD64")
        void javaHome(){
        }

        @Test
        @EnabledIfEnvironmentVariable(named = "NUMBER_OF_PROCESSOR", matches = "8")
        void numberOfProcessors(){
        }

    }


    @Test
    void testSaldoCuentaDev(){

        boolean esDev = "dev".equals(System.getProperty("ENV"));
        assumeTrue(esDev);

        this.cuenta = new Cuenta("Rigo", new BigDecimal("1000.00"));

        assertNotNull(cuenta.getSaldo());
        assertEquals(1000.00, cuenta.getSaldo().doubleValue());
        assertFalse(cuenta.getSaldo().compareTo(BigDecimal.ZERO) < 0);
        assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);

    }

    @Test
    void testSaldoCuentaDev2(){

        boolean esDev = "dev".equals(System.getProperty("ENV"));
        this.cuenta = new Cuenta("Rigo", new BigDecimal("1000.00"));
        assumingThat(esDev, () ->{
            //SI es dev es false no se ejecuta
            assertNotNull(cuenta.getSaldo());
            assertEquals(1000.00, cuenta.getSaldo().doubleValue());
        });

        assertFalse(cuenta.getSaldo().compareTo(BigDecimal.ZERO) < 0);
        assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
    }

    @DisplayName("Probando debito Repetir")
    @RepeatedTest(value = 5, name = "{displayName} - Repeticion numero {currentRepetition} de {totalRepetitions}")
    void testDebitoCuentaRepetir(RepetitionInfo info) {

        if (info.getCurrentRepetition() == info.getTotalRepetitions()) {
            System.out.println("termino de repeticion");
        }

        Cuenta cuenta = new Cuenta("Rigo", new BigDecimal("8900.00"));
        cuenta.debito(new BigDecimal(100));

        assertNotNull(cuenta.getSaldo());
        assertEquals(8800, cuenta.getSaldo().intValue());
        assertEquals("8800.00", cuenta.getSaldo().toPlainString());
    }



    @Tag("Param")
    @Nested
    class PruebasParametrizadasTest{

        @ParameterizedTest(name = "numero {index} ejecutando con valor {0}")
        @ValueSource(strings = {"100", "200", "300", "10000"})
        void testDebitoCuentas(String monto) {

            Cuenta cuenta = new Cuenta("Rigo", new BigDecimal("8900.00"));
            cuenta.debito(new BigDecimal(monto));

            assertNotNull(cuenta.getSaldo());
            assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);

        }

        @ParameterizedTest(name = "numero {index} ejecutando con valor {0}")
        @CsvSource({"1,100", "2,200", "3,300", "4,10000"})
        void testDebitoCuentasCsvSource(String index, String monto) {
            System.out.println(index + " -> " + monto);
            Cuenta cuenta = new Cuenta("Rigo", new BigDecimal("8900.00"));
            cuenta.debito(new BigDecimal(monto));

            assertNotNull(cuenta.getSaldo());
            assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);

        }
        @ParameterizedTest(name = "numero {index} ejecutando con valor {0}")
        @CsvSource({"200,100", "250,200", "301,300", "75099,10000"})
        void testDebitoCuentasCsvSource2(String saldo, String monto) {
            System.out.println(saldo + " -> " + monto);

            cuenta.setSaldo(new BigDecimal(saldo));
            cuenta.debito(new BigDecimal(monto));

            assertNotNull(cuenta.getSaldo());
            assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);

        }

        @ParameterizedTest(name = "numero {index} ejecutando con valor {0}")
        @CsvFileSource(resources = "/data.csv")
        void testDebitoCuentasCsvFileSource(String monto) {
            Cuenta cuenta = new Cuenta("Rigo", new BigDecimal("8900.00"));
            cuenta.debito(new BigDecimal(monto));

            assertNotNull(cuenta.getSaldo());
            assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);

        }

        @ParameterizedTest(name = "numero {index} ejecutando con valor {0}")
        @MethodSource("montoList")
        void testDebitoCuentasMethodSource(String monto) {
            Cuenta cuenta = new Cuenta("Rigo", new BigDecimal("8900.00"));
            cuenta.debito(new BigDecimal(monto));

            assertNotNull(cuenta.getSaldo());
            assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);

        }

    }
    static List<String> montoList(){

        return Arrays.asList("100", "200", "300", "10000");
    }

    @Nested
    @Tag("timeout")
    class ejemploTimeoutTest{

        @Test
        @Timeout(5)
        void pruebaTimeout() throws InterruptedException {

            TimeUnit.SECONDS.sleep(6);
        }

        @Test
        @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
        void pruebaTimeout2() throws InterruptedException {

            TimeUnit.MILLISECONDS.sleep(600);
        }

        @Test
        void testTimeoutAssertions(){
            assertTimeout(Duration.ofSeconds(5), ()-> TimeUnit.SECONDS.sleep(6));
        }
    }



}