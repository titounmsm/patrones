package ayudadoc.services;

import java.util.List;
import java.util.Map;

import ayudadoc.models.alumno.AlumnoPregrado;
import ayudadoc.models.alumno.IAlumno;
import ayudadoc.models.curso.Curso;
import ayudadoc.models.docente.Docente;

import reactor.core.publisher.Flux;
public interface ConsultaService {
    public Flux<Docente> obtenerTodosLosDocentes();
    public Flux<Curso> obtenerTodosLosCursos();
    public Map<String,IAlumno> obtenerTodosLosAlumnos();
    // Otros métodos de consulta
}