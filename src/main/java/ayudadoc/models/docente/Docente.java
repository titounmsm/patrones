package ayudadoc.models.docente;

import ayudadoc.helpers.Constants;
import ayudadoc.models.auth.Usuario;
import ayudadoc.models.carga.ICarga;

public class Docente extends Usuario implements IDocente {

    private Long id;

    private String codigo;
    private String nombres;
    private String apellidos;
    private String email;
    private String estado;
    private String claseid;
    private String categoriaid;
    private IClaseDocente clase;
    private ICategoriaDocente categoria;

    private ICarga carga;

    public Docente() {
    }

    public Docente(Long id, String codigo, String nombres, String apellidos, String email, String estado
                        , String claseid, String categoriaid) {
    
        this.id = id;
        this.codigo = codigo;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.email = email;
        this.estado = estado;
        this.claseid = claseid;
        this.categoriaid = categoriaid;

        this.calculaClaseYCategoria();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClaseid() {
        return claseid;
    }

    public void setClaseid(String claseid) {
        this.claseid = claseid;
    }

    public String getCategoriaid() {
        return categoriaid;
    }

    public void setCategoriaid(String categoriaid) {
        this.categoriaid = categoriaid;
    }

    public ICarga getCarga() {
        return carga;
    }

    public void setCarga(ICarga carga) {
        this.carga = carga;
    }

    @Override
    public String toString() {

        return super.toString() + " - " + id + " - " + codigo + " - " + nombres + " - " + apellidos + " - " + email 
                + " - " + clase.claseDocente() + " - " + categoria.categoriaDocente();     
    }

    @Override
    public int maximoHorasTutoria() {

        return clase.numeroHoras() / 8; 
    }

    @Override
    public int totalHorasLectivas() {

        return clase.numeroHorasLectivas();
    }

    @Override
    public int totalHorasNoLectivas() {

        return clase.numeroHoras() - clase.numeroHorasLectivas();
    }

    @Override
    public void calculaClaseYCategoria() {

        if (claseid!=null)  {
            if (claseid.equals(Constants.CLASE_DOCENTE_TC))
                clase = new ClaseTC();
            else if (claseid.equals(Constants.CLASE_DOCENTE_TP))
                clase = new ClaseTP();
            else
                clase = new ClaseNoDefinida();
        }
        if (categoriaid!=null)  {
            if (categoriaid.equals(Constants.CATEGORIA_DOCENTE_AUX))
                categoria = new CategoriaAuxiliar();
            else if (categoriaid.equals(Constants.CATEGORIA_DOCENTE_ASO))
                categoria = new CategoriaAsociado();
            else
            categoria = new CategoriaNoDefinida();
        }
    }

    public Integer calcularCarga()  {

        return carga.totalHoras();
    }
}
