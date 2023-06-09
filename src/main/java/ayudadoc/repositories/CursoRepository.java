package ayudadoc.repositories;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

import ayudadoc.entities.CursoEntity;
import reactor.core.publisher.Mono;

public interface CursoRepository extends R2dbcRepository<CursoEntity, Long>  {
    
    Mono<CursoEntity> findByCodigo(String codigo);
}
