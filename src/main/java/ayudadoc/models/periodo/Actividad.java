package ayudadoc.models.periodo;

public class Actividad {
    
    private String actividad;

    private String fechas;

    public Actividad( String actividad, String fechas)   {
        this.actividad = actividad;
        this.fechas = fechas;
    }

    public String getActividad() {
        return actividad;
    }
    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public String getFechas() {
        return fechas;
    }
    public void setFechas(String fechas) {
        this.fechas = fechas;
    }
}
