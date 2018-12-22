/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package municipalidad.dominio;

/**
 *
 * @author usuario
 */
public class Reglas {
    
    private  int cantidadCupo = 1024;
    private static final Reglas reglas = new Reglas();
    public  int getCantidadCupo() {
        return cantidadCupo;
    }

    public  void setCantidadCupo(int cantidadCupo) {
        this.cantidadCupo = cantidadCupo;
    }
    
    public  boolean hayCupo(int cantBeneficiosActivos)
    {
        return this.cantidadCupo > cantBeneficiosActivos;
    }
    
    public static Reglas getInstance()
    {
        return Reglas.reglas;
    }
    
}
