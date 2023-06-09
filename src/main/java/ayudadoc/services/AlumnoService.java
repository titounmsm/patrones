package ayudadoc.services;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ayudadoc.entities.AlumnoEntity;
import ayudadoc.models.alumno.AlumnoPregrado;
import ayudadoc.models.alumno.FabricaAlumnos;
import ayudadoc.models.alumno.IAlumno;
import ayudadoc.repositories.AlumnoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Service

public class AlumnoService {
    @Autowired

    private AlumnoRepository AlumnoRepository;
    
        
    // El cliente interactúa con el proxy
  


    public Flux<AlumnoPregrado> obtenerTodos() {
        
        ConsultaServiceProxy.getInstance().obtenerTodosLosAlumnos();
        
        return AlumnoRepository.findAll().flatMap(AlumnoEntity::toDomainModelMono);
    }


    
    public AlumnoRepository getAlumnoRepository() {
        return AlumnoRepository;
    }
    public void setAlumnoRepository(AlumnoRepository alumnoRepository) {
        AlumnoRepository = alumnoRepository;
    }
    

}
