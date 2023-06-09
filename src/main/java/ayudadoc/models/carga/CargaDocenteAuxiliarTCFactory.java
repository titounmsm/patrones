package ayudadoc.models.carga;

public class CargaDocenteAuxiliarTCFactory implements ICargaFactory   {

    @Override
    public ICarga createCarga() {

        return new CargaLectivaNoLectiva( 20, 20 );
    }
    
}
