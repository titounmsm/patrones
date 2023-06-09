package ayudadoc.services;

import java.util.HashMap;
import java.util.Map;

import ayudadoc.models.alumno.AlumnoPregrado;
import ayudadoc.models.alumno.IAlumno;
import ayudadoc.models.curso.Curso;
import ayudadoc.models.docente.Docente;

import reactor.core.publisher.Flux;

public class ConsultaServiceProxy implements ConsultaService {
    private static ConsultaServiceProxy instance;
    private ConsultaServiceImpl consultaService;
    private Flux<Docente> cacheDocentes;
    private Flux<Curso> cacheCurso;
    private  Map<String,IAlumno> cacheAlumnos;

    private ConsultaServiceProxy() {
        consultaService = new ConsultaServiceImpl();
    }
    
    public static synchronized ConsultaServiceProxy getInstance() {
        if (instance == null) {
            instance = new ConsultaServiceProxy();
        }
        return instance;
    }
    @Override
    public Flux<Docente> obtenerTodosLosDocentes() {
       
        return consultaService.obtenerTodosLosDocentes();
    }
    @Override
    public Flux<Curso> obtenerTodosLosCursos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerTodosLosCursos'");
    }
    @Override
    public Map<String,IAlumno> obtenerTodosLosAlumnos() {
        if(cacheAlumnos == null){
            cacheAlumnos =consultaService.obtenerTodosLosAlumnos();
        }
        return cacheAlumnos;
    }
   

    // Implementaciones de otros métodos de consulta con la misma lógica de caché
}
