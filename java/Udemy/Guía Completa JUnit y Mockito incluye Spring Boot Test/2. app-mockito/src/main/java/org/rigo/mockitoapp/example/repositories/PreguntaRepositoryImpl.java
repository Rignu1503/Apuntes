package org.rigo.mockitoapp.example.repositories;

import org.rigo.mockitoapp.example.Datos;

import java.util.List;

public class PreguntaRepositoryImpl implements PreguntaRepository{

    @Override
    public void guardarPreguntas(List<String> preguntas) {
        System.out.println("PreguntaRepositoryImpl.PreguntaRepositoryImpl");
    }

    @Override
    public List<String> findPreguntaPorExamenId(Long id) {

        System.out.println("PreguntaRepositoryImpl.findPreguntaPorExamenId");
        return Datos.PREGUNTAS;
    }
}
