package org.rigo.mockitoapp.example.repositories;

import org.rigo.mockitoapp.example.model.Examen;

import java.util.List;

public interface ExamenRepository {

    Examen guardar(Examen examen);
    List<Examen> findAll();
}
