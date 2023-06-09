package ayudadoc.models.notas;

public class Nota implements INota {

    private Double nota;

    public Nota( Double nota )  {
        this.nota = nota;
    }

    @Override
    public void listarNotas() {

        System.out.println("[Nota]: " + this.nota);
    }

    @Override
    public Double calcularNota() {

        return this.nota;
    }
    
}
