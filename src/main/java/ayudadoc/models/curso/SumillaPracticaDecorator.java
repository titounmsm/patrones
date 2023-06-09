package ayudadoc.models.curso;

public class SumillaPracticaDecorator extends SumillaDecorator {

    public SumillaPracticaDecorator(ISumilla sumilla) {
        super(sumilla);
    }

    @Override
    public String generaSumilla() {

        return super.generaSumilla() + this.agregaSumillaPractica();
    }

    private String agregaSumillaPractica() {
        return " práctico";
    }
    
}
