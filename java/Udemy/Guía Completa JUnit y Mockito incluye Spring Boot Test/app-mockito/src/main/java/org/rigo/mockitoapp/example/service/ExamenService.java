package org.rigo.mockitoapp.example.service;

import org.rigo.mockitoapp.example.model.Examen;

import java.util.Optional;

public interface ExamenService {

    Optional<Examen> findExamenByNombre(String nombre);
    Examen findExamenPorNombreConPregunta(String nombre);
    Examen guardarExamen(Examen examen);
}
