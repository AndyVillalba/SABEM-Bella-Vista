/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package municipalidad_boleto;

import java.net.MalformedURLException;
import municipalidad.presentacion.vistas.VistaPrincipal;
import municipalidad.persistencia.Repositorio;

/**
 *
 * @author Coyote
 */
public class Municipalidad_Boleto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws MalformedURLException {
        // TODO code application logic here
        Repositorio.iniciar();
        new VistaPrincipal();
    }

}
