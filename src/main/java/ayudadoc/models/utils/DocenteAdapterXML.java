package ayudadoc.models.utils;

import ayudadoc.models.docente.Docente;

public class DocenteAdapterXML implements IExportaXML {


    private Docente docente;
    
    public DocenteAdapterXML( Docente docente ) {
        this.docente = docente;
    }

    @Override
    public String generaXML() {

        String xml = "";
        xml = "<Docente>";
        xml = xml + "<id>" + docente.getId() + "</id>";
        xml = xml + "<codigo>" + docente.getCodigo() + "</codigo>";
        xml = xml + "<nombres>" + docente.getNombres() + "</nombres>";
        xml = xml + "<apellidos>" + docente.getApellidos() + "</apellidos>";
        xml = xml + "<email>" + docente.getEmail()+ "</email>";
        xml = xml + "<claseId>" + docente.getClaseid() + "</claseId>";
        xml = xml + "<categoriaId>" + docente.getCategoriaid() + "</categoriaId>";
        xml = xml + "</Docente>";

        return xml;
    }



    public Docente getDocente() {
        return docente;
    }



    public void setDocente(Docente docente) {
        this.docente = docente;
    }
    
}
