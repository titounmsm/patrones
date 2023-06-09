package ayudadoc.models.curso;

public class ModalidadVirtual extends Modalidad {

    private String modalidad = "No presencial (virtual)";

    public ModalidadVirtual( ITipoAula tipoAula )    {
        super(tipoAula);
    }

    @Override
    public String getModalidad() {

        return modalidad;
    }

    @Override
    public void complementarModalidad() {

        System.out.println("");
        System.out.println("Clases virtuales de forma síncronas y asíncronas.");
        System.out.println("Se compartirá la información por el Aula virtual de Google Classroom.");
    }
    
}
