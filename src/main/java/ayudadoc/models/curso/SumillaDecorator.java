package ayudadoc.models.curso;

public class SumillaDecorator implements ISumilla {

    private ISumilla sumilla;

    public SumillaDecorator(ISumilla sumilla)    {

        this.sumilla = sumilla;
    }

    @Override
    public String generaSumilla() {

        //return "Es un curso";
        return sumilla.generaSumilla();
    }
    
}
