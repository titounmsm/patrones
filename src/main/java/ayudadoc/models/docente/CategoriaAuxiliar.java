package ayudadoc.models.docente;

public class CategoriaAuxiliar implements ICategoriaDocente {
    
    private String categoria = "Auxiliar";
    private int periodo = 3;

    @Override
    public String categoriaDocente() {

        return categoria;
    }

    @Override
    public int periodoRatificacion() {
        
        return periodo;
    }
}
