package ayudadoc.models.periodo;

import java.util.List;

public interface IPeriodoAcademicoBuilder {
    
    public PeriodoAcademicoBuilder withPlanificacion( String tipo, String fechaInicio, String fechaFin );

    public PeriodoAcademicoBuilder withModalidad( String modalidad );

    public PeriodoAcademicoBuilder withActividades(List<Actividad> actividades);
}
