package domain.facultad;

import java.util.List;

public class Inscripcion {
    private Alumno alumno;
    private List<Materia> materias;

    public Inscripcion(Alumno alumno, List<Materia> asignaturas) {
        this.alumno = alumno;
        this.materias = asignaturas;
    }

    public Boolean aprobada() {
        return materias.stream().allMatch(m -> alumno.puedeCursar(m));
    }
}
