package ayudadoc.models.carga;

public class CargaDocenteContratadoFactory implements ICargaFactory {

    @Override
    public ICarga createCarga() {

        return new CargaSoloLectiva();
    }
    
}
