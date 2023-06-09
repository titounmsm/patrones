package ayudadoc.models.curso;

public class ModalidadPresencial extends Modalidad {

    private String modalidad = "Presencial";

    public ModalidadPresencial( ITipoAula tipoAula )    {
        super(tipoAula);
    }

    @Override
    public String getModalidad() {

        return modalidad;
    }

    @Override
    public void complementarModalidad() {

        System.out.println("");
        System.out.println("Clases presenciales dentro de las instalaciones de la Facultad.");
        
    }
    
}
