/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package municipalidad.persistencia;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ImageIcon;
import municipalidad.dominio.Beneficiario;
import municipalidad.dominio.Beneficio;
import municipalidad.dominio.Documento;
import municipalidad.dominio.EstadoBeneficio;
import municipalidad.dominio.EstadoCarnet;
import municipalidad.dominio.Sexo;
import municipalidad.dominio.TipoBeneficio;

/**
 *
 * @author ramir
 */
public class Repositorio {
    private static final ArrayList<String> establecimientos = new ArrayList<>();
    private static final ArrayList<String> carreras = new ArrayList<>();
    private static final ArrayList<Beneficiario> beneficiarios = new ArrayList<>();
    private static final ArrayList<Beneficio> beneficios = new ArrayList<>();
    private static final ArrayList<Documento> documentos = new ArrayList<>();
    
    public static void iniciar() throws MalformedURLException{
        //crearDocumentosRequeridos();
        crearEstablecimientos();
        crearCarreras();
        //setBeneficiarios();
    }
    
    private static void crearEstablecimientos(){
        establecimientos.add("Universidad Teconológica Nacional - FRT");
        establecimientos.add("Universidad Nacional Tucumán");
    }
    
    private static void crearCarreras(){
        carreras.add("Ingenieria en Sistemas");
        carreras.add("Ingenieria Electronica");
        carreras.add("Arquitectura");        
    }
    
    public static ArrayList<String> getEstablecimientos() {
        return establecimientos;
    }

    public static ArrayList<String> getCarreras() {
        return carreras;
    }

    public static ArrayList<Beneficiario> getBeneficiarios() {
        return beneficiarios;
    }
    
    public static Boolean getExistencia(int dni){
        boolean e = false;
        for(Beneficiario b : beneficiarios){
            if(b.getDni() == dni){
                e = true;
                return e;
            }
        }
        return e;
    }
    
    public static void registrarBeneficiario(Beneficiario b){
        Repositorio.beneficiarios.add(b);
    }

    
     public static int getCantidadBeneficios(){
        int i = 0;
        for(Beneficiario b : Repositorio.beneficiarios){
            for(Beneficio ben : b.getBeneficios())
            {
                i++;
            }
        }
        return i;
    }
    
    
    public static int getCantidadBeneficiosActivos(){
        int i = 0;
        for(Beneficio b : beneficios){
            if(b.getEstado() == EstadoBeneficio.Activo){
                i++;
            }
        }
        return i;
    }
    
   
     
    public  static ArrayList<Beneficiario> obtenerBeneficiariosConCarnetsPendientes() {
        ArrayList<Beneficiario> auxiliar = new ArrayList<>();
        
        for(Beneficiario b : Repositorio.beneficiarios)
        {
            if(b.obtenerBeneficioActivo().getCarnet().getEstado().equals(EstadoCarnet.Pendiente))
            {
                auxiliar.add(b);
            }
        }
        return auxiliar;
    }
    
    public static Beneficiario getBeneficiario(Integer dni)
    {
          for(Beneficiario b : Repositorio.beneficiarios)
        {
            if(b.getDni().equals(dni))
            {
                return b;
            }
        }
        return null;
    }
    
    
    public static void actualizarBeneficiarios(ArrayList<Beneficiario> beneficiarios2)
    {
         for(Beneficiario b : Repositorio.beneficiarios)
         {
             for(Beneficiario b1: beneficiarios2)
             {
                 if(b.equals(b1)) b=b1;
             }
         }
    }
    
 
    
    public static void setBeneficiarios() throws MalformedURLException
    {
        URL url = new URL("https://estaticos.qdq.com/swdata/photos/769/769385991/25bc2f3e9e924f0db4c05cb91cbaf772.jpg");
        ImageIcon icon = new ImageIcon(url);
       
        for(int i =0;i<69;i++)
        {
            Beneficiario ben =  new Beneficiario(""+i,"Navarro",i,"Lomas papá",4623434,new Date(18,05,1998),Sexo.MASCULINO,icon);
            Beneficio b = new Beneficio("UTN","INGENIERIA EN SISTEMAS DE INFORMACION",TipoBeneficio.Universitario);
            b.setEstado(EstadoBeneficio.Activo);
            b.establecerFechaVencimiento(new Date(18,12,2018));
            ben.getBeneficios().add(b);
            beneficiarios.add(ben);
        }
    }
    
    
}
