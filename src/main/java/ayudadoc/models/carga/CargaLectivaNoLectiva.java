package ayudadoc.models.carga;

public class CargaLectivaNoLectiva implements ICarga {
   
    private Integer horasLectivas = 8;
    private Integer horasNoLectivas = 12;
    private Float factor = 2f;
    
    public CargaLectivaNoLectiva() {
    }

    public CargaLectivaNoLectiva( Integer horasLectivas, Integer horasNoLectivas )  {

        this.horasLectivas = horasLectivas;
        this.horasNoLectivas = horasNoLectivas;
    }

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
