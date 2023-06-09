package ayudadoc.models.curso;

public class SumillaLaboratorioDecorator extends SumillaDecorator {

    public SumillaLaboratorioDecorator(ISumilla sumilla) {
        super(sumilla);
    }

    @Override
    public String generaSumilla() {

        return super.generaSumilla() + this.agregaSumillaLaboratorio();
    }

    private String agregaSumillaLaboratorio() {
        return " con laboratorio";
    }

}
