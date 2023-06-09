package ayudadoc.models.curso;

import ayudadoc.models.periodo.IPeriodoAcademico;

public class Curso implements ICurso    {

    private Long id;

    private String codigo;
    private String nombre;
    private String tipo;
    private Long numHorasTeoria;
    private Long numHorasPractica;
    private Long numHorasLaboratorio;
    private Long numCreditos;
    private String planEstudiosId;
    private IPlanEstudios planEstudios;
    private String ciclo;
    private String periodoAcademicoId;
    private IPeriodoAcademico periodoAcademico;
    private String estado;
    private String nuevoCodigo;
    private String sumilla;
    private String modalidad;
    private Modalidad tipoModalidad;

    public Curso()  {
    }

    public Curso(Long id, String codigo, String nombre, String tipo,
                 Long numHorasTeoria, Long numHorasPractica, Long numHorasLaboratorio, Long numCreditos,
                 String ciclo, String planEstudiosId, String periodoAcademicoId, String estado, String sumilla, 
                 String modalidad ) {

        this.id = id;                    
        this.codigo = codigo;
        this.nombre = nombre;
        this.tipo = tipo;
        this.numHorasTeoria = numHorasTeoria;
        this.numHorasPractica = numHorasPractica;
        this.numHorasLaboratorio = numHorasLaboratorio;
        this.numCreditos = numCreditos;
        this.planEstudiosId = planEstudiosId;
        this.ciclo = ciclo;
        this.periodoAcademicoId = periodoAcademicoId;
        this.estado = estado;
        this.sumilla = sumilla;
        this.modalidad = modalidad;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public Long getNumHorasTeoria() {
        return numHorasTeoria;
    }
    public void setNumHorasTeoria(Long numHorasTeoria) {
        this.numHorasTeoria = numHorasTeoria;
    }
    public Long getNumHorasPractica() {
        return numHorasPractica;
    }
    public void setNumHorasPractica(Long numHorasPractica) {
        this.numHorasPractica = numHorasPractica;
    }
    public Long getNumHorasLaboratorio() {
        return numHorasLaboratorio;
    }
    public void setNumHorasLaboratorio(Long numHorasLaboratorio) {
        this.numHorasLaboratorio = numHorasLaboratorio;
    }
    public Long getNumCreditos() {
        return numCreditos;
    }
    public void setNumCreditos(Long numCreditos) {
        this.numCreditos = numCreditos;
    }
    public String getPlanEstudiosId() {
        return planEstudiosId;
    }
    public void setPlanEstudiosId(String planEstudiosId) {
        this.planEstudiosId = planEstudiosId;
    }
    public IPlanEstudios getPlanEstudios() {
        return planEstudios;
    }
    public void setPlanEstudios(IPlanEstudios planEstudios) {
        this.planEstudios = planEstudios;
    }
    public String getCiclo() {
        return ciclo;
    }
    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }
    public String getPeriodoAcademicoId() {
        return periodoAcademicoId;
    }
    public void setPeriodoAcademicoId(String periodoAcademicoId) {
        this.periodoAcademicoId = periodoAcademicoId;
    }
    public IPeriodoAcademico getPeriodoAcademico() {
        return periodoAcademico;
    }
    public void setPeriodoAcademico(IPeriodoAcademico periodoAcademico) {
        this.periodoAcademico = periodoAcademico;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getNuevoCodigo() {
        return nuevoCodigo;
    }
    public void setNuevoCodigo(String nuevoCodigo) {
        this.nuevoCodigo = nuevoCodigo;
    }
    public String getSumilla() {
        return sumilla;
    }
    public void setSumilla(String sumilla) {
        this.sumilla = sumilla;
    }
    public String getModalidad() {
        return this.modalidad;
    }
    public Modalidad getTipoModalidad() {
        return tipoModalidad;
    }
    public void setTipoModalidad(Modalidad tipoModalidad) {
        this.tipoModalidad = tipoModalidad;
        this.modalidad = tipoModalidad.getModalidad();
    }

    @Override
    public String toString()    {

        return "[" + codigo + " - \n" 
                   + nombre + " - \n"
                   + planEstudiosId + " - \n"
                   + "Hs.T:" + numHorasTeoria + " - \n"
                   + "Hs.P:" + numHorasPractica + " - \n"
                   + "Hs.L:" + numHorasLaboratorio + " - \n"
                   + "Cred:" + numCreditos + " - \n"
                   + periodoAcademicoId + " - \n"
                   + ciclo + " - \n"
                   + modalidad + " - \n"
                   + sumilla
                +"]";
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        
        Curso newCurso = new Curso();
        newCurso.setCodigo(codigo);
        newCurso.setNombre(nombre);
        newCurso.setTipo(tipo);
        newCurso.setNumHorasTeoria(numHorasTeoria);
        newCurso.setNumHorasPractica(numHorasPractica);
        newCurso.setNumHorasLaboratorio(numHorasLaboratorio);
        newCurso.setNumCreditos(numCreditos);
        newCurso.setPeriodoAcademicoId(periodoAcademicoId);
        newCurso.setPeriodoAcademico(periodoAcademico);
        newCurso.setPlanEstudiosId(planEstudiosId);
        newCurso.setPlanEstudios(planEstudios);
        newCurso.setCiclo(ciclo);
        newCurso.setSumilla(sumilla);
        newCurso.setTipoModalidad(tipoModalidad);
        return newCurso;
    }


}
