package ayudadoc.models.periodo;

import java.util.ArrayList;
import java.util.List;

public class PeriodoAcademicoBuilder implements IPeriodoAcademicoBuilder {
   
    private String codigo;
    private String descripcion;
    private String tipo;
    private String fechaInicio;
    private String fechaFin;
    private String modalidad;
    private List<Actividad> actividades = new ArrayList<Actividad>();
    
    public PeriodoAcademicoBuilder( String codigo, String descripcion )    {

        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    public PeriodoAcademicoBuilder withPlanificacion(String tipo, String fechaInicio, String fechaFin)  {
        this.tipo = tipo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        return this;
    }

    public PeriodoAcademicoBuilder withModalidad(String modalidad)  {
        this.modalidad = modalidad;
        return this;
    }
    
    public PeriodoAcademicoBuilder withActividades(List<Actividad> actividades)  {
        this.actividades = actividades;
        return this;
    } 

    public PeriodoAcademico build() {
    
        PeriodoAcademico periodo = new PeriodoAcademico();        
        periodo.setCodigo(this.codigo);
        periodo.setDescripcion(this.descripcion);
        periodo.setTipo(this.tipo);
        periodo.setFechaInicio(this.fechaInicio);
        periodo.setFechaFin(this.fechaFin);
        periodo.setModalidad(this.modalidad);
        periodo.setActividades(this.actividades);
        return periodo;
    }
    
        
 }