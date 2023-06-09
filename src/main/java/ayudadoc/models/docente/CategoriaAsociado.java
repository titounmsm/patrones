package ayudadoc.models.docente;

public class CategoriaAsociado implements ICategoriaDocente {

    private String categoria = "Asociado";
    private int periodo = 4;

    @Override
    public String categoriaDocente() {

        return categoria;
    }

    @Override
    public int periodoRatificacion() {
        
        return periodo;
    }
    
}
