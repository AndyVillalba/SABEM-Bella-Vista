package municipalidad.dominio;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ImageIcon;

public class Beneficiario {

    private String nombre;
    
    private Integer dni;

    private String apellido;

    private String direccion;

    private int telefono;

    private Date fecNac;
    
    private Sexo sexo;

    private ImageIcon fotografia;
    
    private final ArrayList<Beneficio> beneficios= new ArrayList<>();

    public Beneficiario(String nombre,String apellido ,Integer dni,String direccion, int telefono, Date fecNac, Sexo sexo, ImageIcon fotografia) {
        this.nombre = nombre;
        this.dni = dni;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fecNac = fecNac;
        this.sexo = sexo;
        this.fotografia = fotografia;
    }

    public Beneficiario(Integer dni) {
        this.dni=dni;
    }

   
    public void guardarBeneficio(Beneficio b) {
        beneficios.add(b);
    }

  
    public void confirmarAsignacion(boolean cupo, Beneficio b)
    {
        b.asignarEstado(cupo);
    }

    public void entregarDocumento(Documento doc)
    {
        obtenerBeneficioActivo().confirmarDocumentoEntregado(doc);
    }
    
    
    public void generarCarnet() {
        obtenerBeneficioActivo().generarCarnet();
    }

    public Beneficio obtenerBeneficioActivo() {
       for(Beneficio b: this.beneficios)
       {
           if(b.getEstado().equals(EstadoBeneficio.Activo))
           {
               return b;
           }
       }
       return null;
   
    }

    public Beneficio crearBeneficio(String establecimiento, String carrera, TipoBeneficio tipo)
    {
       return (new Beneficio(establecimiento,carrera,tipo));
    }
    //Getters and Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public Date getFecNac() {
        return fecNac;
    }

    public void setFecNac(Date fecNac) {
        this.fecNac = fecNac;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public ImageIcon getFotografia() {
        return fotografia;
    }

    public void setFotografia(ImageIcon fotografia) {
        this.fotografia = fotografia;
    }


    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public ArrayList<Beneficio> getBeneficios() {
        return beneficios;
    }

   
    
    
    
}
