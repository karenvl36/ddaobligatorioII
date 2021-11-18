/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz.vistas;

import interfaz.IVistaAdmin;
import interfaz.controladores.ControladorAdmin;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import logica.Partida.JugadorPartida;
import logica.Partida.Partida;
import logica.UsuarioAdministrador;

/**
 *
 * @author chiqu
 */
public class VistaAdministrador extends javax.swing.JFrame implements IVistaAdmin {

    private UsuarioAdministrador esteAdmin;
    private ControladorAdmin ca;

    /**
     * Creates new form VistaAdministrador
     */
    public VistaAdministrador(UsuarioAdministrador admin) {
        ca = new ControladorAdmin(this);

        this.esteAdmin = admin;

        initComponents();
        initListaYLabels();
        listaPartidasEnCurso.setCellRenderer(new PartidasRenderer());
        listaDetallesJugadores.setCellRenderer(new JugadoresRenderer());
        ca.actualizar();
  
     
                   
                   

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        listaPartidasEnCurso = new javax.swing.JList();
        labelPartidasEnCurso = new javax.swing.JLabel();
        labelDetalleJugador = new javax.swing.JLabel();
        labelAdminNick = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        listaDetallesJugadores = new javax.swing.JList();
        lblPrueba = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        listaPartidasEnCurso.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                listaPartidasEnCursoFocusLost(evt);
            }
        });
        listaPartidasEnCurso.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaPartidasEnCursoValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listaPartidasEnCurso);

        labelPartidasEnCurso.setText("Partidas en curso");

        labelDetalleJugador.setText("Detalles de los jugadores:");

        labelAdminNick.setForeground(new java.awt.Color(255, 51, 51));
        labelAdminNick.setText("labelAdminNick");

        jScrollPane3.setViewportView(listaDetallesJugadores);

        lblPrueba.setText("FECHA INICIO -  CANT JUGADORES- TOTAL APOSTADO - CANT MANOS JUGADAS");

        jLabel1.setText("Nombre - Total apostado - Saldo inicial - total ganado");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblPrueba, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47)))
                        .addGap(164, 164, 164))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelAdminNick)
                            .addComponent(labelDetalleJugador)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 608, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelPartidasEnCurso))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 663, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelAdminNick)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelPartidasEnCurso)
                .addGap(21, 21, 21)
                .addComponent(lblPrueba)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelDetalleJugador)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(69, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listaPartidasEnCursoValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaPartidasEnCursoValueChanged
        this.seleccionarPartida();
    }//GEN-LAST:event_listaPartidasEnCursoValueChanged

    private void listaPartidasEnCursoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_listaPartidasEnCursoFocusLost
 
    }//GEN-LAST:event_listaPartidasEnCursoFocusLost

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel labelAdminNick;
    private javax.swing.JLabel labelDetalleJugador;
    private javax.swing.JLabel labelPartidasEnCurso;
    private javax.swing.JLabel lblPrueba;
    private javax.swing.JList listaDetallesJugadores;
    private javax.swing.JList listaPartidasEnCurso;
    // End of variables declaration//GEN-END:variables

    private void initListaYLabels() {
        labelAdminNick.setText("Bienvenido " + this.esteAdmin.getNombreCompleto() + "!");
    }

    public void seleccionarPartida() {
        
        ca.getJugadoresPartidaSeleccionada(listaPartidasEnCurso.getSelectedValue());
    }

    @Override
    public void actualizar(List<Partida> partidasEnCurso) {
        
        this.listaPartidasEnCurso.setListData(partidasEnCurso.toArray());
        
    }

    @Override
    public void mostrarDetallesJugadores(List<JugadorPartida> jugadores) {
        listaDetallesJugadores.setListData(jugadores.toArray());
    }

    private class PartidasRenderer extends PanelDetallesPartida implements ListCellRenderer<Partida> {

        public Component getListCellRendererComponent(JList<? extends Partida> list, Partida partida, int index, boolean isSelected, boolean cellHasFocus) {
            this.lblFechaPartida.setText(partida.getFecha().toString());
            this.lblCantJugadores.setText(partida.getJugadores().size() + "");
            this.lblCantManosJugadas.setText(partida.getManos().size() + "");
            this.lblTotalApostado.setText(partida.getTotalApostado() + "");
            return this;
        }
    }

    private class JugadoresRenderer extends PanelDetallesJugadores implements ListCellRenderer<JugadorPartida> {

        public Component getListCellRendererComponent(JList<? extends JugadorPartida> list, JugadorPartida jp, int index, boolean isSelected, boolean cellHasFocus) {
            this.lblNombre.setText(jp.getJugador().getNombreCompleto());
            this.lblTotalApostado.setText("$" + jp.getApuestaPartida());
            this.lblSaldoInicial.setText("$" + jp.getSaldoInicial());
            this.lblTotalGanado.setText("$" + jp.getGananciaNeta());
            return this;

        }

    }
    

    

}
