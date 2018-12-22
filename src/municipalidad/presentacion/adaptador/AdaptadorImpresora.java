/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package municipalidad.presentacion.adaptador;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.Book;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import municipalidad.dominio.Beneficiario;
import municipalidad.presentacion.vistas.VistaPrevia;

/**
 *
 * @author usuario
 */
public class AdaptadorImpresora {
    
    private final VistaPrevia vista = new VistaPrevia();
   
    
       public AdaptadorImpresora(){
       
    }
    
    public  boolean imprima(ArrayList<Beneficiario> beneficiarios)
    {
         try {
            // Open printer dialog and pass JPanel to print
            //Se crea un libro para almacenar los carnets en el mismo
                PrinterJob job = PrinterJob.getPrinterJob();
                Book libro = new Book();
                PageFormat pf = job.defaultPage();
                pf.setOrientation(PageFormat.PORTRAIT);
                //Se verifica el tamaño de carnets a imprimir por hoja siendo que por cada hoja, caben 8 carnets como máximo
                //De acuerdo al tamaño se crean N hojas donde 8 carnets entran por hoja.
                if(beneficiarios.size()<=8)
                { //se imprime una sola hoja porque caben menos de u ocho carnets
                     ComponentPrintable f = new ComponentPrintable(this.vista,250.0,300.0, this.vista.getVistaCarnet(), beneficiarios);
                        libro.append(f, pf,1);
                }
                else
                {   
                    boolean ultimaPagina=false; //se verifica si es la ultima pagina del libro para que la relacion se redondee para arriba
                    int hojas;
                    if(beneficiarios.size()%8==0) hojas=(beneficiarios.size()/8); //si la cantidad de carnets es multiplo de 8, se crean N hojas
                    else    hojas=(int)(beneficiarios.size()/8)+1;  // si la division no da un numero entero, se redondea para arriba.
                        
                    for(int i =0;i<hojas;i++) // se imprimen N hojas
                    {
                        if((i+1)==hojas) ultimaPagina=true;
                       
                        ComponentPrintable f = new ComponentPrintable(this.vista,250.0,300.0, this.vista.getVistaCarnet(), adaptarArray(beneficiarios,i,ultimaPagina));
                        libro.append(f, pf,1);
                    }
                    
                }
                job.setPageable(libro);  //se asigna el libro a la impresora para imprimir
                if(job.printDialog()) job.print();  //se imprimen las N hoajs
                else return false;
                       
                
                return true;
                    
                
                
        } catch (PrinterException pex) {
              JOptionPane.showMessageDialog(null,"ERROR DE PROGRAMA","Error\n"+pex,JOptionPane.INFORMATION_MESSAGE);
              return false;
        }
    }
//Metodo que devuelve los ocho carnets(beneficiarios) para que se adapten a cada hoja, y que no se repitan
    private ArrayList<Beneficiario> adaptarArray(ArrayList<Beneficiario> beneficiarios, int k, boolean ultimaPagina) {
        int i=8*k;
        ArrayList<Beneficiario> auxiliar = new ArrayList<>();
        
        if(ultimaPagina)
        {
             for(int j=i;j<beneficiarios.size();j++)
                {
                       auxiliar.add(beneficiarios.get(j));
                }
        }
        else
        {
                for(int j=i;j<(i+8);j++)
                {
                       auxiliar.add(beneficiarios.get(j));
                }
        }
       
        return auxiliar;
    }

       
class BookComponentPrintable implements Printable {
  private Component component;

  public BookComponentPrintable(Component c) {
    this.component = c;
  }

  public int print(Graphics g, PageFormat pageFormat, int pageIndex) {
    Graphics2D g2 = (Graphics2D) g;
    g2.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
    this.component.paint(g2);
    return PAGE_EXISTS;
  }
}
//Clase que representaría lo que sería cada hoja
class ComponentPrintable implements Printable{

    private double imageableX, imageableY;
    private JFrame frame;
    private JPanel panel;
     private ArrayList<Beneficiario> beneficiarios;
    
    public ComponentPrintable(JFrame frame, double posX, double posY, JPanel panel, ArrayList<Beneficiario> beneficiarios ){
        this.frame = frame;
        imageableX = posX;
        imageableY = posY;
        this.panel = panel;
        this.beneficiarios=beneficiarios;
    }
    //Print dibuja literalmente cada hoja y se diseña la página de acuerdo a lo deseado
    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
          Graphics2D g2d = (Graphics2D)graphics;
           g2d.scale(0.35, 0.35);
           double proporcionY = (imageableY+100.0);
           double proporcionX=(imageableX*2)+150.0;
          for(int i=0;i<this.beneficiarios.size();i++)
          {
              this.beneficiarios.get(i).generarCarnet();
              adaptarVista(this.beneficiarios.get(i));
              if(i == 0)
              {
                   g2d.translate(imageableX, imageableY);
                   this.panel.print(g2d);
                   continue;
              }
              if(i % 2 == 0)
              {
                  g2d.translate(-proporcionX,proporcionY);
              }
              else
              {
                  g2d.translate(proporcionX, 0);
              }
              this.panel.print(g2d);
          }
        return PAGE_EXISTS;
    }
 } 
    //Cada JFrame que se refleje en la hoja debe ser adaptado por cada beneficiario(carnet)
    public void adaptarVista(Beneficiario b)
    {
        this.vista.getLbDireccion().setText(b.getDireccion());
        this.vista.getLbDni().setText(String.valueOf(b.getDni()));
        this.vista.getLbEjemplar().setText(String.valueOf(b.obtenerBeneficioActivo().getCarnet().getEjemplar()));
        this.vista.getLbDni().setText(String.valueOf(b.getDni()));
        this.vista.getLbFechaVenc().setText(b.obtenerBeneficioActivo().getFecVencimiento().toString());
        this.vista.getLbFoto().setIcon(b.getFotografia());
        this.vista.getLbNomAp().setText(b.getApellido()+", "+b.getNombre());
    }

    public VistaPrevia getVista() {
        return vista;
    }
}

