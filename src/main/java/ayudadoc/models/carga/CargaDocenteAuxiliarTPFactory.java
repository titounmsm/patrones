package ayudadoc.models.carga;

public class CargaDocenteAuxiliarTPFactory implements ICargaFactory {

    @Override
    public ICarga createCarga() {

        return new CargaLectivaNoLectiva();
    }
    
}
