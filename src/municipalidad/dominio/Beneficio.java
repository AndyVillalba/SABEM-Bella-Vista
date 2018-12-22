package municipalidad.dominio;
import java.util.ArrayList;
import java.util.Date;



public final class Beneficio {

    private int codigoBeneficio=0;
    
    private Date fecAlta;

    private Date fecBaja;
    
    private Date fecVencimiento;

    private String establecimiento;
    
    private String carrera;
    
    private EstadoBeneficio estado;
    
    private final ArrayList<Documento> documentos = new ArrayList<>();
    
    private final ArrayList<Renovacion> renovaciones = new ArrayList<>();
    
    private final ArrayList<EntregaBoletos> entregas = new ArrayList<>();
    
    private TipoBeneficio tipo;
    
    private Carnet carnet;

    public Beneficio(String establecimiento, String carrera, TipoBeneficio tipo) {
        this.establecimiento = establecimiento;
        this.carrera = carrera;
        this.tipo = tipo;
        this.codigoBeneficio++;
        this.fecAlta= new Date();
        this.fecVencimiento= new Date();
        this.estado=EstadoBeneficio.Pendiente;
        this.carnet = new Carnet();
        crearDocumentosRequeridos();
    }

    public Beneficio() {
        this.codigoBeneficio++;
        this.estado=EstadoBeneficio.Pendiente;
        this.carnet = new Carnet();
        crearDocumentosRequeridos();
    }
    
    
    public void generarCarnet(){
        this.carnet.confirmarImpresion();
    }
    

    public void asignarEstado(boolean cupo) {
          
          if(cupo) setEstado(EstadoBeneficio.Activo);
          else  setEstado(EstadoBeneficio.Pendiente);
             
    }

    public void establecerFechaVencimiento(Date fecha)
    {
        this.fecVencimiento=fecha;
    }
    
    public void confirmarDocumentoEntregado(Documento doc) {
        for(Documento d : this.documentos)
        {
            if(d.equals(doc)) d.confirmarEntrega();
            
        }
    }
    
    
    public void crearDocumentosRequeridos()
    {
        documentos.add(new Documento(new Documentacion("Fotocopia de DNI",true)));
        documentos.add(new Documento(new Documentacion("Constancia de estudios en curso",true)));
        documentos.add(new Documento(new Documentacion("Certificado de residencia",false)));
        documentos.add(new Documento(new Documentacion("Boleta de servicio",false)));
        documentos.add(new Documento(new Documentacion("Negativa de anses",false)));
    }
    public int getCodigoBeneficio() {
        return codigoBeneficio;
    }

    public void setCodigoBeneficio(int codigoBeneficio) {
        this.codigoBeneficio = codigoBeneficio;
    }

    public Date getFecAlta() {
        return fecAlta;
    }

    public void setFecAlta(Date fecAlta) {
        this.fecAlta = fecAlta;
    }

    public Date getFecBaja() {
        return fecBaja;
    }

    public void setFecBaja(Date fecBaja) {
        this.fecBaja = fecBaja;
    }

    public Date getFecVencimiento() {
        return fecVencimiento;
    }

    public void setFecVencimiento(Date fecVencimiento) {
        this.fecVencimiento = fecVencimiento;
    }

    public String getEstablecimiento() {
        return establecimiento;
    }

    public void setEstablecimiento(String establecimiento) {
        this.establecimiento = establecimiento;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public EstadoBeneficio getEstado() {
        return estado;
    }

    public void setEstado(EstadoBeneficio estado) {
        this.estado = estado;
    }

    public TipoBeneficio getTipo() {
        return tipo;
    }

    public void setTipo(TipoBeneficio tipo) {
        this.tipo = tipo;
    }

    public Carnet getCarnet() {
        return carnet;
    }

    public void setCarnet(Carnet carnet) {
        this.carnet = carnet;
    }

    public ArrayList<Documento> getDocumentos() {
        return documentos;
    }

    public ArrayList<Renovacion> getRenovaciones() {
        return renovaciones;
    }

    public ArrayList<EntregaBoletos> getEntregas() {
        return entregas;
        
    }
    
    
     

}
