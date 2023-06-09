package ayudadoc.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import ayudadoc.models.alumno.AlumnoPregrado;
import reactor.core.publisher.Mono;

@Table("alumno")
public class AlumnoEntity {

    @Id
    private Long id;

    private String base;
    private String nombre;

    private int edad;
   

          
    public AlumnoEntity() {
    }

    public AlumnoEntity(Long id, String base, String nombre, int edad) {
    
        this.id = id;
        this.base = base;
        this.nombre = nombre;
        this.edad = edad;
      
    }

    public static AlumnoEntity fromDomainModel( AlumnoPregrado Alumno ) {
        
        return new AlumnoEntity( Alumno.getId(), Alumno.getBase(), Alumno.getNombre(), Alumno.getEdad());
    }

    public AlumnoPregrado toDomainModel()  {

        return new AlumnoPregrado( id, base, nombre, edad);
    }

    public Mono<AlumnoPregrado> toDomainModelMono()  {

        return Mono.just( new AlumnoPregrado( id, base, nombre, edad) );
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

   
}
