package ayudadoc.models.periodo;

import java.util.ArrayList;
import java.util.List;

public class PeriodoAcademico implements IPeriodoAcademico {

    private String codigo;
    private String descripcion;
    private String tipo;
    private String fechaInicio;
    private String fechaFin;
    private String modalidad;
    private List<Actividad> actividades = new ArrayList<Actividad>();

    public PeriodoAcademico()   {}

    public PeriodoAcademico(String codigo)   {
        this.codigo = codigo;
    }

    public PeriodoAcademico(String codigo, String descripcion, 
                            String tipo, String fechaInicio, String fechaFin, 
                            String modalidad) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.modalidad = modalidad;
    }

    @Override
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    @Override
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String getTipo() {

        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String getFechaInicio() {

        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    @Override
    public String getFechaFin() {

        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    @Override
    public String getModalidad() {

        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    @Override
    public List<Actividad> getActividades() {

        return actividades;
    }

    public void setActividades( List<Actividad> actividades )    {
        this.actividades = actividades;
    }

    @Override
    public void addActividad(String actividad, String fechas) {

        actividades.add(new Actividad(actividad, fechas));
    }
    
}
