package ayudadoc.repositories;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Mono;
import ayudadoc.entities.DocenteEntity;
//import ayudadoc.models.Docentew;

public interface DocenteRepository extends R2dbcRepository<DocenteEntity, Long> {
    
    Mono<DocenteEntity> findByEmail(String email);

    Mono<DocenteEntity> findByCodigo(String codigo);
    
}