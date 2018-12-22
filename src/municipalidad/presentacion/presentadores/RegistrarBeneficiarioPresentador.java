/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package municipalidad.presentacion.presentadores;

import municipalidad.persistencia.Repositorio;
import java.util.Date;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import municipalidad.dominio.Beneficiario;
import municipalidad.dominio.Sexo;
import municipalidad.presentacion.interfaces.IRegistrarBeneficiarioVista;

/**
 *
 * @author ramir
 */
public class RegistrarBeneficiarioPresentador {

    private IRegistrarBeneficiarioVista vista;
    private Beneficiario beneficiario;

    public RegistrarBeneficiarioPresentador(IRegistrarBeneficiarioVista vista) {
        this.vista = vista;
        this.vista.setSexo(Sexo.values());
    }

    public boolean iniciarRegistracion(Integer dni) {
        boolean e = Repositorio.getExistencia(dni);
        if (!e) {
            this.beneficiario = new Beneficiario(dni);
            return true;
        }
        cargarDatosBeneficiario(dni);
        return false;
    }

    public void cargarDatosBeneficiario(Integer dni)
    {
        Beneficiario b = Repositorio.getBeneficiario(dni);
        this.vista.setDatosBeneficiarioExistente(b.getNombre(),b.getApellido(),b.getDireccion(),b.getTelefono(),b.getFecNac(),b.getSexo(),b.getFotografia());
    }
   

    public void tomarFotografia(Icon foto) {
        this.beneficiario.setFotografia((ImageIcon) foto);
    }

    public void setDatos(String apellido,String nombre, String dir, int telefono,Sexo sexo,int dia, int mes, int anio){
        this.beneficiario.setNombre(nombre);
        this.beneficiario.setApellido(apellido);
        this.beneficiario.setDireccion(dir);
        Date fechaNac = new Date();
        fechaNac.setDate(dia);
        fechaNac.setMonth(mes);
        fechaNac.setYear(anio);
        this.beneficiario.setFecNac(fechaNac);
        this.beneficiario.setSexo(sexo);
        this.beneficiario.setTelefono(telefono);
        
    }
    
    public void confirmarRegistracion() {
        Repositorio.registrarBeneficiario(this.beneficiario);
    }

}
