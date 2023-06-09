package ayudadoc.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import ayudadoc.models.curso.Curso;
import reactor.core.publisher.Mono;

@Table("Curso")
public class CursoEntity {

    @Id
    private Long id;

    private String codigo;
    private String nombre;
    private String tipo;
    private Long numhorasteoria;
    private Long numhoraspractica;
    private Long numhoraslaboratorio;
    private Long numcreditos;
    private String planestudiosid;
    private String ciclo;
    private String periodoacademicoid;
    private String estado;
    private String sumilla;
    private String modalidad;
    

    public CursoEntity() {
    }

    public CursoEntity(Long id, String codigo, String nombre, String tipo, Long numhorasteoria, Long numhoraspractica, Long numhoraslaboratorio
                        , Long numcreditos, String ciclo, String planestudiosid, String periodoacademicoid, String estado 
                        , String sumilla, String modalidad ) {
    
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.tipo = tipo;
        this.numhorasteoria  = numhorasteoria;
        this.numhoraspractica = numhoraspractica;
        this.numhoraslaboratorio = numhoraslaboratorio;
        this.numcreditos = numcreditos;
        this.planestudiosid = planestudiosid;
        this.ciclo = ciclo;
        this.periodoacademicoid = periodoacademicoid;
        this.estado = estado;
        this.sumilla = sumilla;
        this.modalidad = modalidad;
    }

    public static CursoEntity fromDomainModel( Curso curso ) {
        
        return new CursoEntity( curso.getId(), curso.getCodigo(), curso.getNombre(), curso.getTipo()
                                , curso.getNumHorasTeoria(), curso.getNumHorasPractica(), curso.getNumHorasLaboratorio()
                                , curso.getNumCreditos(), curso.getCiclo(), curso.getPlanEstudiosId(), curso.getPeriodoAcademicoId()
                                , curso.getEstado(), curso.getSumilla(), curso.getModalidad());
    }

    public Curso toDomainModel()  {

        return new Curso( id, codigo, nombre, tipo, numhorasteoria, numhoraspractica, numhoraslaboratorio, numcreditos, 
                          ciclo, planestudiosid, periodoacademicoid, estado, sumilla, modalidad);
    }

    public Mono<Curso> toDomainModelMono()  {

        return Mono.just( new Curso( id, codigo, nombre, tipo, numhorasteoria, numhoraspractica, numhoraslaboratorio, numcreditos, 
                                     ciclo, planestudiosid, periodoacademicoid, estado, sumilla, modalidad) );
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

    public Long getNumhorasteoria() {
        return numhorasteoria;
    }

    public void setNumhorasteoria(Long numhorasteoria) {
        this.numhorasteoria = numhorasteoria;
    }

    public Long getNumhoraspractica() {
        return numhoraspractica;
    }

    public void setNumhoraspractica(Long numhoraspractica) {
        this.numhoraspractica = numhoraspractica;
    }

    public Long getNumhoraslaboratorio() {
        return numhoraslaboratorio;
    }

    public void setNumhoraslaboratorio(Long numhoraslaboratorio) {
        this.numhoraslaboratorio = numhoraslaboratorio;
    }

    public Long getNumcreditos() {
        return numcreditos;
    }

    public void setNumcreditos(Long numcreditos) {
        this.numcreditos = numcreditos;
    }

    public String getPlanestudiosid() {
        return planestudiosid;
    }

    public void setPlanestudiosid(String planestudiosid) {
        this.planestudiosid = planestudiosid;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public String getPeriodoacademicoid() {
        return periodoacademicoid;
    }

    public void setPeriodoacademicoid(String periodoacademicoid) {
        this.periodoacademicoid = periodoacademicoid;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getSumilla() {
        return sumilla;
    }

    public void setSumilla(String sumilla) {
        this.sumilla = sumilla;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

}
