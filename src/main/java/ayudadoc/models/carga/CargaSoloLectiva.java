package ayudadoc.models.carga;

public class CargaSoloLectiva implements ICarga {

    private Integer horasLectivas = 10;
    private Integer horasNoLectivas= 0;
    private Float factor = 2f;
    
    @Override
    public Integer numeroHorasLectiva() {

        return horasLectivas;
    }

    @Override
    public Integer numeroHorasNoLectiva() {

        return horasNoLectivas;
    }

    @Override
    public Integer totalHoras() {

        return horasLectivas + horasNoLectivas;
    }

    @Override
    public Float numeroPuntos() {

        return (horasLectivas + horasNoLectivas) * factor;
    }
    
}
