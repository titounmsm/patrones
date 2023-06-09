package ayudadoc.models.curso;

public class SumillaBasica implements ISumilla {

    @Override
    public String generaSumilla() {

        return this.agregaSumillaBasica();
    }
    
    private String agregaSumillaBasica() {
        return "Es un curso";
    }
    
}
