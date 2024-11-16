package org.rigo.mockitoapp.example;

import org.rigo.mockitoapp.example.model.Examen;

import java.util.Arrays;
import java.util.List;

public class Datos {

    public final static List<Examen> EXAMENES = Arrays.asList(new Examen(5L, "Matematica"),
            new Examen(6L, "Fisica"), new Examen(7L, "Alexandro"));

    public final static List<Examen> EXAMENES_ID_NEGATIVOS = Arrays.asList(new Examen(-5L, "Matematica"),
            new Examen(-6L, "Aluno"), new Examen(-7L, "Alexandro"));

    public final static List<Examen> EXAMENES_ID_NULL = Arrays.asList(new Examen(null, "Matematica"),
            new Examen(null, "Aluno"), new Examen(null, "Alexandro"));


    public final static List<String> PREGUNTAS = Arrays.asList("aritmetica", "integrales", "derivadas", "trigonometria");

    public final  static Examen EXAMEN = new Examen(8L, "fisica");
}
