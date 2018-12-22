/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package municipalidad.presentacion.presentadores;
import municipalidad.presentacion.interfaces.IAsignarBeneficioVista;
import municipalidad.persistencia.Repositorio;
import java.util.Date;
import municipalidad.dominio.Beneficiario;
import municipalidad.dominio.Beneficio;
import municipalidad.dominio.Documento;
import municipalidad.dominio.Reglas;
import municipalidad.dominio.TipoBeneficio;
/**
 *
 * @author ramir
 */
public class AsignarBeneficioPresentador {
    private IAsignarBeneficioVista vista;
    private Beneficiario beneficiario;
    private Beneficio beneficioEnCurso;

    public AsignarBeneficioPresentador(IAsignarBeneficioVista vista) {
        this.vista = vista;
        this.vista.setCarreras(Repositorio.getCarreras());
        this.vista.setEstablecimientos(Repositorio.getEstablecimientos());
        this.vista.setTipoBeneficios(TipoBeneficio.values());
    }
    
    public Beneficiario iniciarAsignacion(Integer dni){
        if(Repositorio.getExistencia(dni))
        {
             this.beneficiario = Repositorio.getBeneficiario(dni);
            this.vista.setDatosBeneficiario(this.beneficiario.getApellido()+", "+this.beneficiario.getNombre(), this.beneficiario.getFotografia());
            
            return this.beneficiario;
        }
        else return null;
       
    }
    
    
    public void asignarBeneficio(String establecimiento, String carrera, TipoBeneficio tipo){
        this.beneficioEnCurso = this.beneficiario.crearBeneficio(establecimiento, carrera, tipo);
    }
    
    
    
    public void confirmarDocumentoEntregado(String descripcion)
    {
        for(Documento d : this.beneficioEnCurso.getDocumentos())
        {
            if(d.getDescripcionDocumento().getDescripcion().equals(descripcion)) d.confirmarEntrega();
        }
    }
    
    public void cargarDatos(int dni) {
        this.vista.cargarDatos(Repositorio.getBeneficiario(dni));
     
    }
    
    public boolean confirmar(){
         this.beneficioEnCurso.setFecAlta(new Date());
        if(Reglas.getInstance().hayCupo(Repositorio.getCantidadBeneficiosActivos())){
            this.beneficioEnCurso.asignarEstado(true);
            this.beneficiario.guardarBeneficio(this.beneficioEnCurso);
            Repositorio.registrarBeneficiario(this.beneficiario);
            return true;
        }
        else{   this.beneficioEnCurso.asignarEstado(false);
            this.beneficiario.guardarBeneficio(this.beneficioEnCurso);
            Repositorio.registrarBeneficiario(this.beneficiario);
        return false;}
    }
}
