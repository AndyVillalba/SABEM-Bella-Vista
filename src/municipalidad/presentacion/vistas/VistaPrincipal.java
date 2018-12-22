/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package municipalidad.presentacion.vistas;

/**
 *
 * @author Coyote
 */
public class VistaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form vistaPrincipal
     */
    public VistaPrincipal() {
        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.panelPrincipal = new PanelAsignarBeneficio();
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        panelPrincipal = new javax.swing.JPanel();
        menuBarra = new javax.swing.JMenuBar();
        menuArchivo = new javax.swing.JMenu();
        menuBeneficios = new javax.swing.JMenu();
        menuEntregarBoletos = new javax.swing.JMenuItem();
        menuRenovar = new javax.swing.JMenuItem();
        menuCarnet = new javax.swing.JMenu();
        menuImprimirCarnet = new javax.swing.JMenuItem();
        menuReportarExtravio = new javax.swing.JMenuItem();
        menuBeneficiarios = new javax.swing.JMenu();
        menuBeneficio = new javax.swing.JMenuItem();
        menuActualizar = new javax.swing.JMenuItem();
        menuCancelarBeneficio = new javax.swing.JMenuItem();
        menuListaCandidatos = new javax.swing.JMenuItem();
        menuRegistracion = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelPrincipal.setBackground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 577, Short.MAX_VALUE)
        );

        menuArchivo.setText("Archivo");
        menuBarra.add(menuArchivo);

        menuBeneficios.setText("Beneficios");

        menuEntregarBoletos.setText("Entregar Boletos");
        menuBeneficios.add(menuEntregarBoletos);

        menuRenovar.setText("Renovar");
        menuBeneficios.add(menuRenovar);

        menuBarra.add(menuBeneficios);

        menuCarnet.setText("Carnet");

        menuImprimirCarnet.setText("Imprimir Carnets");
        menuImprimirCarnet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuImprimirCarnetActionPerformed(evt);
            }
        });
        menuCarnet.add(menuImprimirCarnet);

        menuReportarExtravio.setText("Reportar Extravio");
        menuCarnet.add(menuReportarExtravio);

        menuBarra.add(menuCarnet);

        menuBeneficiarios.setText("Beneficiarios");

        menuBeneficio.setText("Asignar Beneficio");
        menuBeneficio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBeneficioActionPerformed(evt);
            }
        });
        menuBeneficiarios.add(menuBeneficio);

        menuActualizar.setText("Actualizar Datos");
        menuBeneficiarios.add(menuActualizar);

        menuCancelarBeneficio.setText("Cancelar Beneficio");
        menuBeneficiarios.add(menuCancelarBeneficio);

        menuListaCandidatos.setText("Lista de Candidatos");
        menuListaCandidatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuListaCandidatosActionPerformed(evt);
            }
        });
        menuBeneficiarios.add(menuListaCandidatos);

        menuBarra.add(menuBeneficiarios);

        menuRegistracion.setText("Registracion");

        jMenuItem1.setText("Nuevo beneficiario");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menuRegistracion.add(jMenuItem1);

        menuBarra.add(menuRegistracion);

        setJMenuBar(menuBarra);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuListaCandidatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuListaCandidatosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuListaCandidatosActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        RegistrarBeneficiarioVista rbv = new RegistrarBeneficiarioVista(this, false);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void menuBeneficioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuBeneficioActionPerformed
        // TODO add your handling code here:
        AsignarBeneficioVista abv = new AsignarBeneficioVista(this, true);
    }//GEN-LAST:event_menuBeneficioActionPerformed

    private void menuImprimirCarnetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuImprimirCarnetActionPerformed
        (new VistaGenerarCarnet()).setVisible(true);
    }//GEN-LAST:event_menuImprimirCarnetActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem menuActualizar;
    private javax.swing.JMenu menuArchivo;
    private javax.swing.JMenuBar menuBarra;
    private javax.swing.JMenu menuBeneficiarios;
    private javax.swing.JMenuItem menuBeneficio;
    private javax.swing.JMenu menuBeneficios;
    private javax.swing.JMenuItem menuCancelarBeneficio;
    private javax.swing.JMenu menuCarnet;
    private javax.swing.JMenuItem menuEntregarBoletos;
    private javax.swing.JMenuItem menuImprimirCarnet;
    private javax.swing.JMenuItem menuListaCandidatos;
    private javax.swing.JMenu menuRegistracion;
    private javax.swing.JMenuItem menuRenovar;
    private javax.swing.JMenuItem menuReportarExtravio;
    private javax.swing.JPanel panelPrincipal;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the menuActualizar
     */
    public javax.swing.JMenuItem getMenuActualizar() {
        return menuActualizar;
    }

    /**
     * @return the menuArchivo
     */
    public javax.swing.JMenu getMenuArchivo() {
        return menuArchivo;
    }

    /**
     * @return the menuBarra
     */
    public javax.swing.JMenuBar getMenuBarra() {
        return menuBarra;
    }

    /**
     * @return the menuBeneficiarios
     */
    public javax.swing.JMenu getMenuBeneficiarios() {
        return menuBeneficiarios;
    }

    /**
     * @return the menuBeneficio
     */
    public javax.swing.JMenuItem getMenuBeneficio() {
        return menuBeneficio;
    }

    /**
     * @return the menuBeneficios
     */
    public javax.swing.JMenu getMenuBeneficios() {
        return menuBeneficios;
    }

    /**
     * @return the menuCancelarBeneficio
     */
    public javax.swing.JMenuItem getMenuCancelarBeneficio() {
        return menuCancelarBeneficio;
    }

    /**
     * @return the menuCarnet
     */
    public javax.swing.JMenu getMenuCarnet() {
        return menuCarnet;
    }

    /**
     * @return the menuEntregarBoletos
     */
    public javax.swing.JMenuItem getMenuEntregarBoletos() {
        return menuEntregarBoletos;
    }

    /**
     * @return the menuImprimirCarnet
     */
    public javax.swing.JMenuItem getMenuImprimirCarnet() {
        return menuImprimirCarnet;
    }

    /**
     * @return the menuListaCandidatos
     */
    public javax.swing.JMenuItem getMenuListaCandidatos() {
        return menuListaCandidatos;
    }

    /**
     * @return the menuRegistracion
     */
    public javax.swing.JMenu getMenuRegistracion() {
        return menuRegistracion;
    }

    /**
     * @return the menuRenovar
     */
    public javax.swing.JMenuItem getMenuRenovar() {
        return menuRenovar;
    }

    /**
     * @return the menuReportarExtravio
     */
    public javax.swing.JMenuItem getMenuReportarExtravio() {
        return menuReportarExtravio;
    }

    /**
     * @return the panelPrincipal
     */
    public javax.swing.JPanel getPanelPrincipal() {
        return panelPrincipal;
    }


}
