package ayudadoc.models.docente;

public class ClaseTP implements IClaseDocente {

    private String clase = "TP - Tiempo Parcial";
    private int horas = 20;
    private int horasLectivas = 8;

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
