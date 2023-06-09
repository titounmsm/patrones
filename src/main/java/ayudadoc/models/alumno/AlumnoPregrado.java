
package ayudadoc.models.alumno;

import ayudadoc.entities.AlumnoEntity;
import ayudadoc.repositories.AlumnoRepository;

public class AlumnoPregrado implements IAlumno{
    private Long id;

  


    private String base;
    private String nombre;
   
    private int edad;

    public AlumnoPregrado(String base) {
        this.base = base;
    }

    public AlumnoPregrado(Long id, String base, String nombre, int edad) {
        this.id = id;
        this.base = base;
        this.nombre = nombre;
        this.edad = edad;
    }

  
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Long getId() {
        return id;
    }

    public String getBase() {
        return base;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }


    public void generarAlumno() {
       
            System.out.println("AlumnoPregrado [base=" + base + ", nombre=" + nombre + ", edad=" + edad + "]"); 
      
    }

    
    





 
    
    
}
