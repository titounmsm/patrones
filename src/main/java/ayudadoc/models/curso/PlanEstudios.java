package ayudadoc.models.curso;

public class PlanEstudios implements IPlanEstudios  {

    private String codigo;
    private String escuela;
    private String vigenciaPlan;

    public PlanEstudios()   {
    }

    public PlanEstudios(String codigo)  {
        
        this.codigo = codigo;
    }

    public PlanEstudios(String codigo, String escuela, String vigenciaPlan)   {

        this.codigo = codigo;
        this.escuela = escuela;
        this.vigenciaPlan = vigenciaPlan;
    }

    @Override
    public String getCodigo() {

        return codigo;
    }

    @Override
    public String getEscuela() {
        return escuela;
    }

    @Override
    public String getVigenciaPlan() {

        return vigenciaPlan;
    }
    
}
