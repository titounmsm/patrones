package ayudadoc.repositories;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

import ayudadoc.entities.AlumnoEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AlumnoRepository extends R2dbcRepository<AlumnoEntity, Long>{
  
}
    
