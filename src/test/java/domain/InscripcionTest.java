package domain;

import domain.facultad.Alumno;
import domain.facultad.Inscripcion;
import domain.facultad.Materia;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class InscripcionTest {
    private Materia ayed = new Materia("Algoritmos y Estructuras de Datos");
    private Materia pdep = new Materia("Paradigmas de Programación");
    private Materia dds = new Materia("Diseño de Sistemas");

    private Alumno jennifer = new Alumno("Jennifer", 1940243);


    @Before
    public void inicializar() {
        pdep.agregarCorrelativas(ayed);
        dds.agregarCorrelativas(pdep);
        jennifer.agregarMateriasAprobadas(ayed);
    }

    @Test
    public void elAlumnoCumpleConTodasLasCorrelativas() {
        Inscripcion inscrip = new Inscripcion(jennifer, List.of(pdep));

        Assert.assertTrue(inscrip.aprobada());
    }

    @Test
    public void elAlumnoNoTieneLasCorrelativas() {
        Inscripcion inscrip = new Inscripcion(jennifer, List.of(dds));

        Assert.assertFalse(inscrip.aprobada());
    }

    @Test
    public void elAlumnoNoPuedeInscribirseAUnaMateriaQueYaAprobo() {
        Inscripcion inscrip = new Inscripcion(jennifer, List.of(ayed));

        Assert.assertFalse(inscrip.aprobada());
    }
}
