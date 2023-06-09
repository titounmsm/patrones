
package ayudadoc.models.alumno;

import java.util.HashMap;
import java.util.Map;


public class FabricaAlumnos {
    
    private static final Map<String,IAlumno> MapaAlumno=new HashMap();
    
    public static IAlumno getAlumnoPregrado(String base){
        AlumnoPregrado A1=(AlumnoPregrado)MapaAlumno.get(base);
        
        if(A1 ==null){
            A1=new AlumnoPregrado(base);
            MapaAlumno.put(base, A1);
            System.out.println("Creando alumno pregrado base :  "+base);
         }
        return A1;
    }
    public static Map<String, IAlumno> getAlumnos(){
        return MapaAlumno;
    }
    
}
