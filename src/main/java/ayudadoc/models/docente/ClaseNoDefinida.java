package ayudadoc.models.docente;

public class ClaseNoDefinida implements IClaseDocente {

    private String clase = "No Definido";
    private int horas = 0;
    private int horasLectivas = 0;


    @Override
    public String claseDocente() {

        return clase;
    }

    @Override
    public int numeroHoras() {
        
        return horas;
    }

    @Override
    public int numeroHorasLectivas() {
        return horasLectivas;
    }
    
}
