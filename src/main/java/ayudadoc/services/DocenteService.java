package ayudadoc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ayudadoc.entities.DocenteEntity;
import ayudadoc.helpers.AyudocLog;
import ayudadoc.helpers.error.AyudaDocException;
import ayudadoc.models.carga.CargaBean;
import ayudadoc.models.carga.CargaDocenteAuxiliarTCFactory;
import ayudadoc.models.carga.CargaDocenteAuxiliarTPFactory;
import ayudadoc.models.carga.CargaDocenteContratadoFactory;
import ayudadoc.models.carga.ICargaFactory;
import ayudadoc.models.docente.Docente;
import ayudadoc.repositories.DocenteRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class DocenteService {

    @Autowired
    private DocenteRepository docenteRepository;

    public Flux<Docente> obtenerTodos() {
        System.out.println("En DocenteService docenteRepository es : " );
        System.out.println(docenteRepository.findAll().hasElements());
        //return docenteRepository.findAll().flatMap(DocenteEntity::toDomainModelMono);
        return ConsultaServiceProxy.getInstance().obtenerTodosLosDocentes();
    }

    public Mono<Docente> obtenerPorId(Long id) {
        
        Docente doc = docenteRepository.findById(id).block().toDomainModel();

        if (doc!=null)
            System.out.println( doc.toString() );
        else 
            return Mono.error(
                new AyudaDocException("Docente no existe", "Docente con Id:" + id + " no existe.")
            );

        return Mono.just(doc);
    }

    public Mono<Docente> crearDocente(Docente docente) {

        DocenteEntity d1 = docenteRepository.findByCodigo(docente.getCodigo()).block();
        if ( d1!=null )    {

            return Mono.error(
                new AyudaDocException("Codigo no unico", "El codigo ya existe para otro docente")
            );
        }

        DocenteEntity d2 = docenteRepository.findByEmail(docente.getEmail()).block();
        if ( d2!=null )  {

            return Mono.error(
                new AyudaDocException("Email ya existente", "El email ya existe en otro docente")
            );
        }
        
        System.out.println("*********** Ingreso a crear... ***********************");
        docente.setEstado( "1" );

        DocenteEntity docenteEntity = DocenteEntity.fromDomainModel( docente ); 
        return Mono.just( docenteRepository.save(docenteEntity).doOnSuccess(pl -> {}).block().toDomainModel() );
        
      }

      public Mono<CargaBean> asignarCarga(CargaBean carga) {

        AyudocLog.getInstance().log("debug", "Carga al docente:" + carga.getTipoCarga() + "-" + carga.getCodigoDocente() );
        ICargaFactory factory = null;
        if (carga.getTipoCarga().equals("AUX-TC"))    {
            factory = new CargaDocenteAuxiliarTCFactory();
        }
        else if (carga.getTipoCarga().equals("AUX-TP"))    {
            factory = new CargaDocenteAuxiliarTPFactory();
        }
        else {
            factory = new CargaDocenteContratadoFactory();
        }

        Docente doc = docenteRepository.findByCodigo( carga.getCodigoDocente() ).block().toDomainModel(); 
        doc.setCarga( factory.createCarga() );
        
        AyudocLog.getInstance().log("debug", "Horas asignadas al docente: " + doc.calcularCarga() );
        carga.setResultado("OK");
        return Mono.just(carga);
      }
}
