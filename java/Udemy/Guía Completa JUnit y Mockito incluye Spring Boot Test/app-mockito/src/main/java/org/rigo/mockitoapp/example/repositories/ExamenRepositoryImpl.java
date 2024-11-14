package org.rigo.mockitoapp.example.repositories;

import org.rigo.mockitoapp.example.Datos;
import org.rigo.mockitoapp.example.model.Examen;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ExamenRepositoryImpl implements ExamenRepository {
    @Override
    public Examen guardar(Examen examen) {
        System.out.println("ExamenRepositoryImpl.guardar");
        return Datos.EXAMEN;
    }

    @Override
    public List<Examen> findAll() {
        System.out.println("ExamenRepositoryImpl.findAll");

        try {
            System.out.println("ExamenRepositoryImpl");
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return Datos.EXAMENES;
    }
}
