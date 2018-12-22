/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package municipalidad.presentacion.interfaces;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import municipalidad.dominio.Beneficiario;
import municipalidad.dominio.TipoBeneficio;

/**
 *
 * @author ramir
 */
public interface IAsignarBeneficioVista {
    void setTipoBeneficios(TipoBeneficio[] tipoBeneficios);
    void setEstablecimientos(ArrayList<String> establecimientos);
    void setCarreras(ArrayList<String> carreras);
    void cargarDatos(Beneficiario b);
    public void setDatosBeneficiario(String apYNom, ImageIcon foto);
}
