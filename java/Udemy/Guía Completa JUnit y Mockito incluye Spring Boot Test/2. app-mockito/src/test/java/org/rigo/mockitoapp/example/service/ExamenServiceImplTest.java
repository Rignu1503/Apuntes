package org.rigo.mockitoapp.example.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;
import org.rigo.mockitoapp.example.Datos;
import org.rigo.mockitoapp.example.model.Examen;
import org.rigo.mockitoapp.example.repositories.ExamenRepository;
import org.rigo.mockitoapp.example.repositories.ExamenRepositoryImpl;
import org.rigo.mockitoapp.example.repositories.PreguntaRepository;
import org.rigo.mockitoapp.example.repositories.PreguntaRepositoryImpl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

//Forma de habilitar las anotaciones para inyeccion de dependencia
@ExtendWith(MockitoExtension.class)
class ExamenServiceImplTest {

    @Mock
    ExamenRepositoryImpl examenRepository; //Mock
    @Mock
    PreguntaRepositoryImpl preguntaRepository; //Mock

    @InjectMocks
    ExamenServiceImpl service; //Service

    @Captor
    ArgumentCaptor<Long> captor; //Anotacion para cacturar datos con el primitivo Long

    @BeforeEach
    void setUp() {
        //Forma de habilitar las anotaciones para inyeccion de dependencia
        //MockitoAnnotations.openMocks(this);

        /*
        //Mockito simula el examenRepository
        examenRepository = mock(ExamenRepositoryImpl.class);
        preguntaRepository = mock(PreguntaRepository.class);
        //Como el constructor recibe ambas dependencia se agregan
        service = new ExamenServiceImpl(examenRepository, preguntaRepository);

         */
    }

    @Test
    void ExamenServiceImpl() {

        //Cuando se invoque findAll retorna los datos
        when(examenRepository.findAll()).thenReturn(Datos.EXAMENES);

        Optional<Examen> examen = service.findExamenByNombre("Matematica");

        assertTrue(examen.isPresent());
        assertEquals("Matematica", examen.get().getNombre());
        assertEquals(5L, examen.orElseThrow().getId());
    }

    @Test
    void ExamenServiceImplLIstaVacia() {

        List<Examen> datos = Collections.emptyList();

        //Cuando se invoque findAll retorna los datos
        when(examenRepository.findAll()).thenReturn(datos);
        Optional<Examen> examen = service.findExamenByNombre("Matematica");

        assertFalse(examen.isPresent());
    }

    @Test
    void testPreguntaExamen(){

        when(examenRepository.findAll()).thenReturn(Datos.EXAMENES);
        //anyLong -> cualquier valor numerico tipo long
        when(preguntaRepository.findPreguntaPorExamenId(anyLong())).thenReturn(Datos.PREGUNTAS);
        Examen examen = service.findExamenPorNombreConPregunta("Matematica");

        assertEquals(4,examen.getPreguntas().size());
        //Si las preguntas contiene aritmetica
        assertTrue(examen.getPreguntas().contains("aritmetica"));

    }

    @Test
    void testPreguntaExamenVerifivar(){

        when(examenRepository.findAll()).thenReturn(Datos.EXAMENES);
        //anyLong -> cualquier valor numerico tipo long
        when(preguntaRepository.findPreguntaPorExamenId(anyLong())).thenReturn(Datos.PREGUNTAS);
        Examen examen = service.findExamenPorNombreConPregunta("Matematica");

        //verifica si del objeto mook esta llamando ese metodo
        verify(examenRepository).findAll();
        verify(preguntaRepository).findPreguntaPorExamenId(anyLong());

    }

    @Test
    void testNoExisteExamenVerifivar(){

        //LE pasa una lista vacia
        when(examenRepository.findAll()).thenReturn(Collections.emptyList());
        //anyLong -> cualquier valor numerico tipo long
        when(preguntaRepository.findPreguntaPorExamenId(anyLong())).thenReturn(Datos.PREGUNTAS);
        Examen examen = service.findExamenPorNombreConPregunta("Matematicasd");

        assertNull(examen);

        //verifica si del objeto mook esta llamando ese metodo
        verify(examenRepository).findAll();
        verify(preguntaRepository).findPreguntaPorExamenId(5L);
    }

    @Test
    void  testGuardarExamen(){
        //Given
        Examen newExamen = Datos.EXAMEN;
        newExamen.setPreguntas(Datos.PREGUNTAS);

        //Poner ID autoincrementable
        when(examenRepository.guardar(any(Examen.class))).then(new Answer<Examen>(){

            Long secuencia = 8L;
            @Override
            public Examen answer(InvocationOnMock invocationOnMock) throws Throwable {
                Examen examen = invocationOnMock.getArgument(0);
                examen.setId(secuencia++);

                return examen;
            }

        });

        //when
        Examen examen = service.guardarExamen(newExamen);

        //Them
        assertNotNull(examen.getId());
        assertEquals(8L, examen.getId());
        assertEquals("fisica", examen.getNombre());

        /*
        * any(Examen.class): Es un matcher de Mockito que indica que
        * guardar puede haber sido llamado con cualquier instancia de Examen, sin importar sus valores específicos.*/
        verify(examenRepository).guardar(any(Examen.class));
        verify(preguntaRepository).guardarPreguntas(anyList());
    }

    @Test
    void testManejoException(){

        when(examenRepository.findAll()).thenReturn(Datos.EXAMENES_ID_NULL);
        when(preguntaRepository.findPreguntaPorExamenId(isNull())).thenThrow(IllegalArgumentException.class);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            service.findExamenPorNombreConPregunta("Matematica");
        });

        //IIllegalArgumentException es diferente a TunTimeException
        assertEquals(IllegalArgumentException.class, exception.getClass());

        verify(examenRepository).findAll();
        verify(preguntaRepository).findPreguntaPorExamenId(isNull());
    }

    //Imprime mensaje de error por el toString de la clase heredada
    @Test
    void testArgumentMatchers(){

        when(examenRepository.findAll()).thenReturn(Datos.EXAMENES);
        when(preguntaRepository.findPreguntaPorExamenId(anyLong())).thenReturn(Datos.PREGUNTAS);
        service.findExamenPorNombreConPregunta("Matematica");

        verify(examenRepository).findAll();
        //Verificar si el argument que se pasa hace math con la expresion lambda
        verify(preguntaRepository).findPreguntaPorExamenId(argThat( arg -> arg != null && arg.equals(5L)));
        verify(preguntaRepository).findPreguntaPorExamenId(argThat( arg -> arg != null && arg > 4L));
        verify(preguntaRepository).findPreguntaPorExamenId(eq(5L));

    }

    @Test
    void testArgumentMatchers2(){

        when(examenRepository.findAll()).thenReturn(Datos.EXAMENES_ID_NEGATIVOS);
        when(preguntaRepository.findPreguntaPorExamenId(anyLong())).thenReturn(Datos.PREGUNTAS);
        service.findExamenPorNombreConPregunta("Matematica");

        verify(examenRepository).findAll();
        //Verificar si el argument que se pasa hace math con la expresion lambda
        verify(preguntaRepository).findPreguntaPorExamenId(argThat(new MiArgsMatchers()));


    }

    @Test
    void testArgumentMatchers3(){

        when(examenRepository.findAll()).thenReturn(Datos.EXAMENES_ID_NEGATIVOS);
        when(preguntaRepository.findPreguntaPorExamenId(anyLong())).thenReturn(Datos.PREGUNTAS);
        service.findExamenPorNombreConPregunta("Matematica");

        verify(examenRepository).findAll();
        //Verificar si el argument que se pasa hace math con la expresion lambda
        verify(preguntaRepository).findPreguntaPorExamenId(argThat((argument) -> argument != null && argument > 0));


    }


    public static class MiArgsMatchers implements ArgumentMatcher<Long>{

        private Long argument;

        @Override
        public boolean matches(Long argument) {
            this.argument = argument;
            return argument != null && argument > 0;
        }

        @Override
        public String toString() {
            return "Es para un mensaje personalizado cuando falla el test: " +
                    argument +
                    "debe ser un entero positivo";
        }
    }

    @Test
    void testArgumentCaptor(){

        when(examenRepository.findAll()).thenReturn(Datos.EXAMENES);
        service.findExamenPorNombreConPregunta("Matematica");

        //Captura el ID
        //ArgumentCaptor<Long> captor = ArgumentCaptor.forClass(Long.class); // No se necesito por la anotacion
        verify(preguntaRepository).findPreguntaPorExamenId(captor.capture());

        assertEquals(5L,captor.getValue());
    }

    //Se usa para los metodos void
    @Test
    void testDoThrow(){
        Examen examen = Datos.EXAMEN;

        examen.setPreguntas(Datos.PREGUNTAS);
        doThrow(IllegalArgumentException.class).when(preguntaRepository).guardarPreguntas(anyList());

        assertThrows(IllegalArgumentException.class, () -> {

            service.guardarExamen(examen);
        });
    }

    @Test
    void testDoanswer(){

        when(examenRepository.findAll()).thenReturn(Datos.EXAMENES);
        //when(preguntaRepository.findPreguntaPorExamenId(anyLong())).then(Datos.PREGUNTAS);

        doAnswer(invocation -> {
            Long id = invocation.getArgument(0);

            return id ==5L ? Datos.PREGUNTAS: Collections.emptyList();
        }).when(preguntaRepository).findPreguntaPorExamenId(anyLong());

        Examen examen = service.findExamenPorNombreConPregunta("Matematica");

        assertEquals(5L, examen.getId());
        assertEquals("Matematica", examen.getNombre());

        //preguntar si de repositorio indicado se una el metodo
        verify(preguntaRepository).findPreguntaPorExamenId(anyLong());
    }

    @Test
    void  testDoanswerGuardarExamen() {
        //Given
        Examen newExamen = Datos.EXAMEN;
        newExamen.setPreguntas(Datos.PREGUNTAS);

        doAnswer(new Answer<Examen>() {

            Long secuencia = 8L;

            @Override
            public Examen answer(InvocationOnMock invocationOnMock) throws Throwable {
                Examen examen = invocationOnMock.getArgument(0);
                examen.setId(secuencia++);

                return examen;
            }

        }).when(examenRepository).guardar(any(Examen.class));

        //when
        Examen examen = service.guardarExamen(newExamen);

        //Them
        assertNotNull(examen.getId());
        assertEquals(8L, examen.getId());
        assertEquals("fisica", examen.getNombre());

        /*
         * any(Examen.class): Es un matcher de Mockito que indica que
         * guardar puede haber sido llamado con cualquier instancia de Examen, sin importar sus valores específicos.*/
        verify(examenRepository).guardar(any(Examen.class));
        verify(preguntaRepository).guardarPreguntas(anyList());

    }


    //Invocar el metodo real
    @Test
    void testDocallRealMethod(){

        when(examenRepository.findAll()).thenReturn(Datos.EXAMENES);

        //Llamar metodo mock
        //when(preguntaRepository.findPreguntaPorExamenId(anyLong())).thenReturn(Datos.PREGUNTAS);

        //Llamar metodo real
        doCallRealMethod().when(preguntaRepository).findPreguntaPorExamenId(anyLong());

        Examen examen = service.findExamenPorNombreConPregunta("Matematica");
        assertEquals(5L, examen.getId());
        assertEquals("Matematica", examen.getNombre());
    }

    //Espia como un intermedio entre un metodo mock y un metodo real
    @Test
    void testSpy(){

        ExamenRepository examenRepository = spy(ExamenRepositoryImpl.class);
        PreguntaRepository preguntaRepository = spy(PreguntaRepositoryImpl.class);
        ExamenService examenService = new ExamenServiceImpl(examenRepository, preguntaRepository);

        List<String> pregunta = Arrays.asList("aritmetica");
        //when(preguntaRepository.findPreguntaPorExamenId(anyLong())).thenReturn(pregunta);
        //Es recomendable usar el doReturn para no tener compormatiendo extraños
        doReturn(pregunta).when(preguntaRepository).findPreguntaPorExamenId(anyLong());

        Examen examen = examenService.findExamenPorNombreConPregunta("Matematica");
        assertEquals(5, examen.getId());
        assertEquals("Matematica",examen.getNombre());
        assertEquals(1, examen.getPreguntas().size());

        verify(examenRepository).findAll();
        verify(preguntaRepository).findPreguntaPorExamenId(anyLong());

    }

    @Test
    void testOrdenInvocaciones(){

        when(examenRepository.findAll()).thenReturn(Datos.EXAMENES);

        service.findExamenPorNombreConPregunta("Matematica");
        service.findExamenPorNombreConPregunta("Fisica");
        InOrder inOrder = inOrder(preguntaRepository);

        //Lanza error porque el ID pertenece a "Fisica"
        inOrder.verify(preguntaRepository).findPreguntaPorExamenId(6L);
        inOrder.verify(preguntaRepository).findPreguntaPorExamenId(5L);
    }

    @Test
    void testOrdenInvocaciones2(){

        when(examenRepository.findAll()).thenReturn(Datos.EXAMENES);

        service.findExamenPorNombreConPregunta("Matematica");
        service.findExamenPorNombreConPregunta("Fisica");
        InOrder inOrder = inOrder(examenRepository, preguntaRepository);

        inOrder.verify(examenRepository).findAll();
        inOrder.verify(preguntaRepository).findPreguntaPorExamenId(5L);
        inOrder.verify(examenRepository).findAll();
        inOrder.verify(preguntaRepository).findPreguntaPorExamenId(6L);
    }

    @Test
    void testNumeroInvocion(){
        when(examenRepository.findAll()).thenReturn(Datos.EXAMENES);
        service.findExamenPorNombreConPregunta("Matematica");

        //Que se ejecute una vez
        verify(preguntaRepository, times(1)).findPreguntaPorExamenId(5L);
        //Que se ejcute al menos una vez
        verify(preguntaRepository, atLeast(1)).findPreguntaPorExamenId(5L);
        //Por defecto pasa en valor de 1
        verify(preguntaRepository, atLeastOnce()).findPreguntaPorExamenId(5L);
        //Como maximo
        verify(preguntaRepository, atMost(10)).findPreguntaPorExamenId(5L);
        //Como maximo una vez
        verify(preguntaRepository, atMostOnce()).findPreguntaPorExamenId(5L);

    }

    @Test
    void testNumeroInvocion2(){
        when(examenRepository.findAll()).thenReturn(Datos.EXAMENES);
        service.findExamenPorNombreConPregunta("Matematica");

        //verify(preguntaRepository).findPreguntaPorExamenId(5L); -> falla
        //Que se ejecute una vez
        verify(preguntaRepository, times(2)).findPreguntaPorExamenId(5L);
        //Que se ejcute al menos una vez
        verify(preguntaRepository, atLeast(1)).findPreguntaPorExamenId(5L);
        //Por defecto pasa en valor de 1
        verify(preguntaRepository, atLeastOnce()).findPreguntaPorExamenId(5L);
        //Como maximo
        verify(preguntaRepository, atMost(2)).findPreguntaPorExamenId(5L);
        //Como maximo una vez
        //verify(preguntaRepository, atMostOnce()).findPreguntaPorExamenId(5L);  -> falla

    }

    @Test
    void testNumeroInvocaciones3(){
        when(examenRepository.findAll()).thenReturn(Collections.emptyList());
        service.findExamenPorNombreConPregunta("Matematica");

        verify(preguntaRepository, never()).findPreguntaPorExamenId(5L);
        verifyNoInteractions(preguntaRepository);

        verify(examenRepository, times(1)).findAll();
    }


}