package ayudadoc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ayudadoc.entities.CursoEntity;
import ayudadoc.helpers.AyudocLog;
import ayudadoc.helpers.error.AyudaDocException;
import ayudadoc.models.curso.Curso;
import ayudadoc.models.curso.ICurso;
import ayudadoc.models.periodo.IPeriodoAcademico;
import ayudadoc.models.curso.IPlanEstudios;
import ayudadoc.models.curso.ISumilla;
import ayudadoc.models.curso.Modalidad;
import ayudadoc.models.curso.ModalidadVirtual;
import ayudadoc.models.curso.AulaVirtual;
import ayudadoc.models.periodo.PeriodoAcademico;
import ayudadoc.models.periodo.PeriodoAcademicoBuilder;
import ayudadoc.models.curso.PlanEstudios;
import ayudadoc.models.curso.SumillaBasica;
import ayudadoc.models.curso.SumillaLaboratorioDecorator;
import ayudadoc.models.curso.SumillaTeoricaDecorator;
import ayudadoc.models.notas.Nota;
import ayudadoc.models.notas.NotaCalculada;
import ayudadoc.repositories.CursoRepository;
import reactor.core.publisher.Mono;

@Service
public class CursoService {
    
    @Autowired
    private CursoRepository cursoRepository;
    
    private IPeriodoAcademico periodoActual;

    public Mono<IPeriodoAcademico> crearPeriodo(String codigo, String descripcion, 
                                                 String tipo, String fechaInicio, String fechaFin, 
                                                 String modalidad) {

        periodoActual = new PeriodoAcademico(codigo, descripcion, tipo, 
                                        fechaInicio, fechaFin, modalidad);

        AyudocLog.getInstance().log("debug", "Creando: " + periodoActual.getCodigo() );
        return Mono.just( periodoActual );
    }

    public Mono<IPeriodoAcademico> obtenerPeriodo(String codigo)  {

        AyudocLog.getInstance().log("debug", "Recibe el código: ["+ codigo +"]");
        IPeriodoAcademico periodo = null;

        if (periodoActual!=null && periodoActual.getCodigo().equals(codigo))   {

            periodo = periodoActual;
        }
        else {

            return Mono.error(
                new AyudaDocException("Periodo académico no existe", "El periodo académico no existe")
            );
        }
        //periodo.addActividad("Prematricula", "Jueves 16 y viernes 17 de marzo");
        //periodo.addActividad("Matrícula regular", "Lunes 20 al viernes 24 de marzo");
        //periodo.addActividad("Clases", "Inicio: Lunes 27 de marzo - Término: Viernes 14 de julio");
        
        return Mono.just(periodo);
    }

    public Mono<IPeriodoAcademico> crearPeriodo(IPeriodoAcademico periodo) {

        PeriodoAcademicoBuilder periodoBuilder = new PeriodoAcademicoBuilder(periodo.getCodigo(), 
                                                                             periodo.getDescripcion());
        if (periodo.getFechaInicio()!=null)    {

            periodoBuilder.withPlanificacion( periodo.getTipo(), periodo.getFechaInicio(), periodo.getFechaFin());
        }

        if (periodo.getModalidad()!=null)    {

            periodoBuilder.withModalidad( periodo.getModalidad());
        }

        if (periodo.getActividades()!=null)    {

            periodoBuilder.withActividades( periodo.getActividades());
        }

        periodoActual = periodoBuilder.build();
        AyudocLog.getInstance().log("debug", "Creando con build: " + periodoActual.getCodigo() );
        return Mono.just( periodoActual );
    }

    public Mono<ICurso> crearCurso( Curso curso ) {

        AyudocLog.getInstance().log("debug", "Ingresando a crer el curso: " + curso.getCodigo() );
        
        Curso newCurso = curso;

        if ( curso.getPlanEstudiosId()!=null )  {
            IPlanEstudios planEstudios = new PlanEstudios( curso.getPlanEstudiosId() );
            newCurso.setPlanEstudios( planEstudios );
        }
        if ( curso.getPeriodoAcademicoId()!=null )  {
            IPeriodoAcademico periodoAcademico = new PeriodoAcademico( curso.getPeriodoAcademicoId() );
            newCurso.setPeriodoAcademico( periodoAcademico );
        }
        newCurso.setEstado( "1" );

        // Prueba del patrón Decorator
        ISumilla sumilla = new SumillaLaboratorioDecorator( new SumillaTeoricaDecorator( new SumillaBasica() ) );
        newCurso.setSumilla( sumilla.generaSumilla() );

        // Prueba del patrón Bridge
        Modalidad modalidadCurso = new ModalidadVirtual( new AulaVirtual() );
        modalidadCurso.describirModalidad();
        newCurso.setTipoModalidad( modalidadCurso );

        AyudocLog.getInstance().log("debug", "Creando el Curso: " + newCurso );

        //  Grabar en la BD
        CursoEntity cursoEntity = CursoEntity.fromDomainModel( newCurso );
        return Mono.just( cursoRepository.save(cursoEntity).doOnSuccess(pl -> {}).block().toDomainModel() );
        //return Mono.just( curso );
    }

    public Mono<ICurso> copiarCurso( Curso curso )   {

        AyudocLog.getInstance().log("debug", "Copiando el curso: " + curso );
        CursoEntity cE = cursoRepository.findByCodigo(curso.getCodigo()).block();
        if ( cE==null )    {

            return Mono.error(
                new AyudaDocException("Codigo no encontrado", "El codigo de curso no fue encontrado")
            );
        }
        else    {
            AyudocLog.getInstance().log("debug", "Encontrado el curso: " + cE.toDomainModel() );
        }
    
        Curso nuevoCurso = new Curso();
        try {

            nuevoCurso = (Curso)cE.toDomainModel().clone();
            nuevoCurso.setCodigo( curso.getNuevoCodigo() );
            if (curso.getNombre()!=null)
                nuevoCurso.setNombre( curso.getNombre() );
            AyudocLog.getInstance().log("debug", nuevoCurso.toString() );

        } catch (CloneNotSupportedException e) {
            
            AyudocLog.getInstance().log("error", "Error en la copia: " + e.getMessage() );
            e.printStackTrace();
        }

        CursoEntity cursoEntity = CursoEntity.fromDomainModel( nuevoCurso );
        return Mono.just( cursoRepository.save(cursoEntity).doOnSuccess(pl -> {}).block().toDomainModel() );        
        //return Mono.just( nuevoCurso );
    }


    public Mono<Curso> mostrarNotas( Long cursooid )   {

        Mono<Curso> cursoN = cursoRepository.findById( cursooid ).block().toDomainModelMono();


        NotaCalculada promedioPracticas = new NotaCalculada();
        promedioPracticas.agregarNota( new Nota(20.0));
        promedioPracticas.agregarNota( new Nota(15.0));
        promedioPracticas.agregarNota( new Nota(10.0));
        promedioPracticas.agregarNota( new Nota(15.0));
        promedioPracticas.agregarNota( new Nota(20.0));

        NotaCalculada promedioFinal = new NotaCalculada();
        promedioFinal.agregarNota( new Nota(20.0) );
        promedioFinal.agregarNota( promedioPracticas );
        promedioFinal.agregarNota( new Nota(15.0) );

        System.out.println("Promedio de practicas: " + promedioPracticas.calcularNota() );

        System.out.println("Promedio Final: " + promedioFinal.calcularNota() );

        return cursoN;
    }

}
