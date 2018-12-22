package municipalidad.dominio;

public class Documento {

    private boolean entregado;
    
    private Documentacion descripcionDocumento;

    public Documento(Documentacion descripcionDocumento) {
        this.descripcionDocumento = descripcionDocumento;
        this.entregado=false;
    }

    
    
    public void confirmarEntrega()
    {
        this.entregado=true;
    }

    public boolean isEntregado() {
        return entregado;
    }

    public void setEntregado(boolean entregado) {
        this.entregado = entregado;
    }

    public Documentacion getDescripcionDocumento() {
        return descripcionDocumento;
    }

    public void setDescripcionDocumento(Documentacion descripcionDocumento) {
        this.descripcionDocumento = descripcionDocumento;
    }
    
    
    
    
}
