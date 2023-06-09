package ayudadoc.models.notas;

import java.util.ArrayList;
import java.util.List;

public class NotaCalculada implements INota {

    private List<INota> notas;

    public NotaCalculada()    {
        notas = new ArrayList<INota>();
    }

    @Override
    public void listarNotas() {

        for (INota unaNota : notas) {

            unaNota.listarNotas();
        }
    }

    @Override
    public Double calcularNota() {

        Double notaFinal = 0.0;
        for (INota unaNota : notas) {

            notaFinal = notaFinal + unaNota.calcularNota();
        }
        notaFinal = notaFinal / notas.size();
        return notaFinal;
    }

    public void agregarNota(INota Nota)    {

        if (Nota != null)
            this.notas.add(Nota);
    }

    public void quitarNota(int posicion)    {

        this.notas.remove(posicion);
    }

    public List<INota> getNotas()   {

        return this.notas;
    }
}
