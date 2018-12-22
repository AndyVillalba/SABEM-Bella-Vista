package municipalidad.dominio;

public class Documentacion {

    private String descripcion;
    private boolean obligatorio;

    public Documentacion(String descripcion, boolean obligatorio) {
        this.descripcion = descripcion;
        this.obligatorio = obligatorio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isObligatorio() {
        return obligatorio;
    }

    public void setObligatorio(boolean obligatorio) {
        this.obligatorio = obligatorio;
    }
    
    
    
}
