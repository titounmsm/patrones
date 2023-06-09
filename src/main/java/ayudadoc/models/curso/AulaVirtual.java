package ayudadoc.models.curso;

public class AulaVirtual implements ITipoAula {

    @Override
    public void ubicacionAula() {

        System.out.println("  https://meet.google.com/cgt-kbuu-pjm");
    }

    @Override
    public void nombreAula() {

        System.out.println("  Google Classroom [kam2mhm]");
    }
    
}
