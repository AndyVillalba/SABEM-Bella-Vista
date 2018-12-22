/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package municipalidad.presentacion.presentadores;

import municipalidad.presentacion.interfaces.IGenerarCarnet;
import java.util.ArrayList;
import municipalidad.dominio.Beneficiario;
import municipalidad.persistencia.Repositorio;
import municipalidad.presentacion.adaptador.AdaptadorImpresora;

/**
 *
 * @author usuario
 */
public final class GenerarCarnetPresentador {

    private final IGenerarCarnet vista;
    private ArrayList<Beneficiario> beneficiariosConCarnetsPendientesAImprimir;
    private final AdaptadorImpresora impresora = new AdaptadorImpresora();
    private ArrayList<Beneficiario> beneficiariosConCarnetsPendientes= new ArrayList<>();
    public GenerarCarnetPresentador(IGenerarCarnet vista) {
      this.vista=vista;
      this.beneficiariosConCarnetsPendientes = buscarBeneficiariosConCarnetPendientes();
      this.vista.setBeneficiarios(this.beneficiariosConCarnetsPendientes);
     
    }
    
    public ArrayList<Beneficiario> buscarBeneficiariosConCarnetPendientes()
    {
         this.beneficiariosConCarnetsPendientesAImprimir = new ArrayList<>();
           return  Repositorio.obtenerBeneficiariosConCarnetsPendientes();
    }
    
     public void seleccionarCarnet(Integer dni)
    {
        for(Beneficiario b : this.beneficiariosConCarnetsPendientes)
        {
            if(b.getDni().equals(dni))
            {
                this.beneficiariosConCarnetsPendientesAImprimir.add(b);
                return;
            }
        }
       
    }
     
     public void confirmarImpresion()
     {
        
          boolean resultado = this.impresora.imprima(this.beneficiariosConCarnetsPendientesAImprimir);
          
                   /*for(Beneficiario b : this.beneficiariosConCarnetsPendientesAImprimir)
                    {
                        b.generarCarnet();
                    }*/
          
          Repositorio.actualizarBeneficiarios(this.beneficiariosConCarnetsPendientesAImprimir);
          this.beneficiariosConCarnetsPendientesAImprimir.clear();
          this.beneficiariosConCarnetsPendientes = buscarBeneficiariosConCarnetPendientes();
          this.vista.setBeneficiarios(this.beneficiariosConCarnetsPendientes);
         
     }
    
     
      public ArrayList<Beneficiario> getBeneficiariosConCarnetsPendientesAImprimir() {
        return this.beneficiariosConCarnetsPendientesAImprimir;
    }

    public void setBeneficiariosConCarnetsPendientesAImprimir(ArrayList<Beneficiario> beneficiariosConCarnetsPendientesAImprimir) {
        this.beneficiariosConCarnetsPendientesAImprimir = beneficiariosConCarnetsPendientesAImprimir;
    }

    public ArrayList<Beneficiario> getBeneficiariosConCarnetsPendientes() {
        return beneficiariosConCarnetsPendientes;
    }

    public void setBeneficiariosConCarnetsPendientes(ArrayList<Beneficiario> beneficiariosConCarnetsPendientes) {
        this.beneficiariosConCarnetsPendientes = beneficiariosConCarnetsPendientes;
    }
    
    
    
}
