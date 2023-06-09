package ayudadoc.models.curso;

public class AulaLocal implements ITipoAula {
    
    @Override
    public void ubicacionAula() {

        System.out.println("  Facultad de Ing. de Sistemas e Informática");
        System.out.println("  Pabellón Nuevo, Segundo piso");
    }

    @Override
    public void nombreAula() {

        System.out.println("  Aula 204");
    }
    
}
