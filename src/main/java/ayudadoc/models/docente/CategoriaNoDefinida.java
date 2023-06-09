package ayudadoc.models.docente;

public class CategoriaNoDefinida implements ICategoriaDocente {
    
    private String categoria = "Mo Definida";
    private int periodo = 0;

    @Override
    public String categoriaDocente() {

        return categoria;
    }

    @Override
    public int periodoRatificacion() {
        
        return periodo;
    }
}
