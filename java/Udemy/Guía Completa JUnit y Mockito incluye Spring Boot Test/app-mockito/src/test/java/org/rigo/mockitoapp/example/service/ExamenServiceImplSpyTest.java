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
class ExamenServiceImplSpyTest {

    @Spy
    ExamenRepositoryImpl examenRepository; //spy
    @Spy
    PreguntaRepositoryImpl preguntaRepository; //spy

    @InjectMocks
    ExamenServiceImpl service; //Service

    @Captor
    ArgumentCaptor<Long> captor; //Anotacion para cacturar datos con el primitivo Long

    /*SPY CON  ANOTACIONES*/

    @Test
    void testSpy(){

        List<String> pregunta = Arrays.asList("aritmetica");
        //when(preguntaRepository.findPreguntaPorExamenId(anyLong())).thenReturn(pregunta);
        //Es recomendable usar el doReturn para no tener compormatiendo extraños
        doReturn(pregunta).when(preguntaRepository).findPreguntaPorExamenId(anyLong());

        Examen examen = service.findExamenPorNombreConPregunta("Matematica");
        assertEquals(5, examen.getId());
        assertEquals("Matematica",examen.getNombre());
        assertEquals(1, examen.getPreguntas().size());

        verify(examenRepository).findAll();
        verify(preguntaRepository).findPreguntaPorExamenId(anyLong());


    }

}