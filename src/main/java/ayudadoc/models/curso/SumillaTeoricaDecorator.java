package ayudadoc.models.curso;

public class SumillaTeoricaDecorator extends SumillaDecorator {

    public SumillaTeoricaDecorator(ISumilla sumilla) {
        super(sumilla);
    }

    @Override
    public String generaSumilla() {

        return super.generaSumilla() + this.agregaSumillaTeorica();
    }

    private String agregaSumillaTeorica() {
        return " teórico";
    }
    
}
