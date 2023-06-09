package ayudadoc.models.docente;

public class ClaseTC implements IClaseDocente {

    private String clase = "TC - Tiempo Completo";
    private int horas = 40;
    private int horasLectivas = 15;

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
