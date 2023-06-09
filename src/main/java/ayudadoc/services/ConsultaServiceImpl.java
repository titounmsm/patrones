package ayudadoc.services;

import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ayudadoc.entities.AlumnoEntity;
import ayudadoc.entities.DocenteEntity;
import ayudadoc.models.alumno.AlumnoPregrado;
import ayudadoc.models.alumno.FabricaAlumnos;
import ayudadoc.models.alumno.IAlumno;
import ayudadoc.models.curso.Curso;
import ayudadoc.models.docente.Docente;
import ayudadoc.repositories.AlumnoRepository;
import ayudadoc.repositories.DocenteRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ConsultaServiceImpl implements ConsultaService{

    @Autowired
    private DocenteRepository docenteRepository;

    @Override
    public Flux<Docente> obtenerTodosLosDocentes() {
        System.out.println("hola");
        System.out.println("En ConsultaServiceImpl docenteRepository es :");
        System.out.println(docenteRepository.findAll().hasElements());
        return docenteRepository.findAll().flatMap(DocenteEntity::toDomainModelMono);
    }

    @Override
    public Flux<Curso> obtenerTodosLosCursos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerTodosLosCursos'");
    }

    @Override
    public Map<String, IAlumno> obtenerTodosLosAlumnos() {
        
        return fabricaralumnos();
    }

    private static final String base[]= {"2016","2017","2018","2019","2020"};
    private static final String[] NOMBRES = {    "Juan", "María", "Luis", "Ana", "Pedro", "Carolina", "Diego", "Valentina", "José", "Isabella",
       "Miguel", "Camila", "Carlos", "Laura", "Fernando", "Sofía", "Andrés", "Gabriela", "Ricardo", "Paola"};
   
   private static final String[] APELLIDOS = {    "González", "Rodríguez", "López", "Martínez", "Pérez", "Gómez", "Hernández", "Sánchez", "Ramírez", "Torres"};
   
  

           
       public  Map<String, IAlumno> fabricaralumnos() {
           for(int i=0;i<20;i++){
               AlumnoPregrado AlumnoPregrado= (AlumnoPregrado)FabricaAlumnos.getAlumnoPregrado(getRandomBase());
               AlumnoPregrado.setNombre(generarNombreCompleto());
               AlumnoPregrado.setEdad(generarNumeroAleatorio(18,  30));
               AlumnoPregrado.generarAlumno();
               AlumnoEntity alumnoEntity = AlumnoEntity.fromDomainModel( AlumnoPregrado ); 
              // AlumnoRepository.save(alumnoEntity).doOnSuccess(pl -> {}).block().toDomainModel();
           }
           return FabricaAlumnos.getAlumnos();
       }
       private static String getRandomBase(){
           return base[(int)(Math.random()*base.length)];
       }
       public static String generarNombreCompleto() {
           Random rand = new Random();
           String nombre = NOMBRES[rand.nextInt(NOMBRES.length)];
           String apellido = APELLIDOS[rand.nextInt(APELLIDOS.length)];
   
           return nombre + " " + apellido;
       }
   
       public static int generarNumeroAleatorio(int minimo, int maximo) {
           Random rand = new Random();
           return rand.nextInt((maximo - minimo) + 1) + minimo;
       }
       
 
}
