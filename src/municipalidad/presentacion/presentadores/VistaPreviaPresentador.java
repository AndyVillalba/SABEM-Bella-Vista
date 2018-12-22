/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package municipalidad.presentacion.presentadores;

import municipalidad.dominio.Beneficiario;
import municipalidad.persistencia.Repositorio;
import municipalidad.presentacion.interfaces.IVistaPrevia;
import municipalidad.presentacion.interfaces.IVistaPrevia;

/**
 *
 * @author usuario
 */
public class VistaPreviaPresentador {
    
    private final IVistaPrevia vista;
    private final Beneficiario beneficiario;
    
    public VistaPreviaPresentador(IVistaPrevia vista, Integer dni) {
        this.vista = vista;
        this.beneficiario=Repositorio.getBeneficiario(dni);
        this.vista.setBeneficiario(this.beneficiario);
    }
    
}
