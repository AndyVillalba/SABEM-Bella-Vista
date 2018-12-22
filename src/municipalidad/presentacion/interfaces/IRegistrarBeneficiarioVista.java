/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package municipalidad.presentacion.interfaces;

import java.util.Date;
import javax.swing.ImageIcon;
import municipalidad.dominio.Sexo;

/**
 *
 * @author ramir
 */
public interface IRegistrarBeneficiarioVista {
    void setSexo(Sexo[] sexos);

    public void setDatosBeneficiarioExistente(String nombre, String apellido, String direccion, int telefono, Date fecNac, Sexo sexo, ImageIcon fotografia);
}
