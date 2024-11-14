package org.rigo.mockitoapp.example.repositories;

import java.util.List;

public interface PreguntaRepository {

    void guardarPreguntas(List<String> preguntas);
    List<String> findPreguntaPorExamenId(Long id);
}
