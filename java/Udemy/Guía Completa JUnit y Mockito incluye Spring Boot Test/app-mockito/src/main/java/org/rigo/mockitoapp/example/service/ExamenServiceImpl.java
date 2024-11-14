package org.rigo.mockitoapp.example.service;

import org.rigo.mockitoapp.example.model.Examen;
import org.rigo.mockitoapp.example.repositories.ExamenRepository;
import org.rigo.mockitoapp.example.repositories.PreguntaRepository;

import java.util.List;
import java.util.Optional;

public class ExamenServiceImpl implements ExamenService{

    private final ExamenRepository examenRepository;
    private final PreguntaRepository preguntaRepository;

    public ExamenServiceImpl(ExamenRepository examenRepository, PreguntaRepository preguntaRepository) {
        this.examenRepository = examenRepository;
        this.preguntaRepository = preguntaRepository;
    }

    @Override
    public Optional<Examen> findExamenByNombre(String nombre) {

        return examenRepository.findAll()
                .stream().filter(e -> e.getNombre().contains(nombre))
                .findFirst();
    }

    @Override
    public Examen findExamenPorNombreConPregunta(String nombre) {

        Optional<Examen> examenOptional = findExamenByNombre(nombre);
        Examen examen = null;

        if (examenOptional.isPresent()) {
            examen = examenOptional.orElseThrow();
            List<String> preguntas = preguntaRepository.findPreguntaPorExamenId(examen.getId());
            preguntaRepository.findPreguntaPorExamenId(examen.getId());
            examen.setPreguntas(preguntas);
        }
        return examen;
    }

    @Override
    public Examen guardarExamen(Examen examen) {

        if (!examen.getPreguntas().isEmpty()){
            preguntaRepository.guardarPreguntas(examen.getPreguntas());
        }

        return examenRepository.guardar(examen);
    }
}
