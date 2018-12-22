package municipalidad.dominio;


public class Carnet {

    private int nroCarnet=0;
    private int ejemplar;
    private EstadoCarnet estado;

    public Carnet() {
        this.ejemplar = 1;
        this.estado = EstadoCarnet.Pendiente;
        this.nroCarnet++;
    }

    public void confirmarImpresion()
    {
        this.estado=EstadoCarnet.Impreso;
    }
    
    public void confirmarExtravio()
    {
        this.ejemplar++;
    }

    public int getEjemplar() {
        return ejemplar;
    }

    public void setEjemplar(int ejemplar) {
        this.ejemplar = ejemplar;
    }

    public EstadoCarnet getEstado() {
        return estado;
    }

    public void setEstado(EstadoCarnet estado) {
        this.estado = estado;
    }

    public int getNroCarnet() {
        return nroCarnet;
    }

    public void setNroCarnet(int nroCarnet) {
        this.nroCarnet = nroCarnet;
    }
    
    
    
}
