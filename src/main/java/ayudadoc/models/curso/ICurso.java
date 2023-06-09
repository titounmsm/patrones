package ayudadoc.models.curso;

import ayudadoc.models.periodo.IPeriodoAcademico;

public interface ICurso {

    public Long getId();
 
    public String getCodigo();

    public String getNombre();

    public String getTipo();

    public Long getNumHorasTeoria();

    public Long getNumHorasPractica();

    public Long getNumHorasLaboratorio();

    public Long getNumCreditos();

    public String getPlanEstudiosId();

    public IPlanEstudios getPlanEstudios();

    public void setPlanEstudios( IPlanEstudios planEstudios );

    public String getCiclo();

    public String getPeriodoAcademicoId();

    public IPeriodoAcademico getPeriodoAcademico();

    public void setPeriodoAcademico( IPeriodoAcademico periodoAcademico );

    public String getEstado();

    public void setEstado( String estado );

    public Object clone() throws CloneNotSupportedException;

}
