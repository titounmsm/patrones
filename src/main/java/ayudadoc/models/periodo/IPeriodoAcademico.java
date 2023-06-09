package ayudadoc.models.periodo;

import java.util.List;

import ayudadoc.models.curso.IRegimenAcademico;

public interface IPeriodoAcademico extends IRegimenAcademico {

    public List<Actividad> getActividades();

    public void addActividad( String actividad, String fechas );

    public String getCodigo();

    public String getDescripcion();
    
    public String getTipo();

    public String getFechaInicio();
    
    public String getFechaFin();

    public String getModalidad();

}
