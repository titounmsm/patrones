package ayudadoc.models.curso;

public abstract class Modalidad {

    protected ITipoAula tipoAula;

    protected Modalidad( ITipoAula tipoAula )  {
        this.tipoAula = tipoAula;
    }

    public abstract String getModalidad();

    public abstract void complementarModalidad();
    
    public void describirModalidad() {

        System.out.println("Modalidad: " + getModalidad());

        System.out.println("Aula:");
        tipoAula.ubicacionAula();
        tipoAula.nombreAula();

        complementarModalidad();
    }
}
