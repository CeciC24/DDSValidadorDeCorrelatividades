package domain.facultad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Alumno {
    private Integer legajo;
    private String nombre;
    private List<Materia> materiasAprobadas;

    public Alumno(String nombre, Integer legajo) {
        this.nombre = nombre;
        this.legajo = legajo;
        this.materiasAprobadas = new ArrayList<>();
    }

    public Integer getLegajo() {
        return legajo;
    }
    public String getNombre() {
        return nombre;
    }
    public List<Materia> getMateriasAprobadas() {
        return materiasAprobadas;
    }


    public Boolean aproboMateria(Materia materia) {
        return materiasAprobadas.contains(materia);
    }

    public Boolean correlativasAprobadas(Materia materia) {
        return materiasAprobadas.containsAll(materia.getCorrelativas());
    }

    public Boolean puedeCursar(Materia materia) {
        return !aproboMateria(materia) && correlativasAprobadas(materia);
    }

    public void agregarMateriasAprobadas(Materia ... materias) {
        Collections.addAll(this.materiasAprobadas, materias);
    }
}
