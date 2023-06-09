package ayudadoc.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import ayudadoc.models.docente.Docente;
import reactor.core.publisher.Mono;

@Table("Docente")
public class DocenteEntity {

    @Id
    private Long id;

    private String codigo;
    private String nombres;
    private String apellidos;
    private String email;
    private String estado;
    private String claseid;
    private String categoriaid;

          
    public DocenteEntity() {
    }

    public DocenteEntity(Long id, String codigo, String nombres, String apellidos, String email, String estado
                        , String claseid, String categoriaid) {
    
        this.id = id;
        this.codigo = codigo;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.email = email;
        this.estado = estado;
        this.claseid = claseid;
        this.categoriaid = categoriaid;
    }

    public static DocenteEntity fromDomainModel( Docente docente ) {
        
        return new DocenteEntity( docente.getId(), docente.getCodigo(), docente.getNombres(), docente.getApellidos()
                                , docente.getEmail(), docente.getEstado(), docente.getClaseid(), docente.getCategoriaid());
    }

    public Docente toDomainModel()  {

        return new Docente( id, codigo, nombres, apellidos, email, estado, claseid, categoriaid);
    }

    public Mono<Docente> toDomainModelMono()  {

        return Mono.just( new Docente( id, codigo, nombres, apellidos, email, estado, claseid, categoriaid) );
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

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClaseid() {
        return claseid;
    }

    public void setClaseid(String claseid) {
        this.claseid = claseid;
    }

    public String getCategoriaid() {
        return categoriaid;
    }

    public void setCategoriaid(String categoriaid) {
        this.categoriaid = categoriaid;
    }


}
