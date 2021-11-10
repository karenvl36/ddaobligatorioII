/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz.vistas;

import interfaz.IVistaMano;
import interfaz.controladores.ControladorPartida;
import java.util.List;
import logica.JugadorPartida;
import logica.Partida;

/**
 *
 * @author Karen
 */
public class VistaMano extends javax.swing.JFrame implements IVistaMano {

    /**
     * Creates new form VistaPartida
     */
    
    ControladorPartida cp;
    
    
    public VistaMano(Partida p, JugadorPartida jp) {
        initComponents();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(this.getParent());
        cp = new ControladorPartida(this, p, jp);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lJugadoresEnPartida = new javax.swing.JList();
        btnApostar = new javax.swing.JButton();
        btnPasar = new javax.swing.JButton();
        txtMontoApsotar = new javax.swing.JTextField();
        btnSalir = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblFigura = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        carta1 = new javax.swing.JLabel();
        carta3 = new javax.swing.JLabel();
        carta4 = new javax.swing.JLabel();
        carta5 = new javax.swing.JLabel();
        carta2 = new javax.swing.JLabel();
        lbJugador = new javax.swing.JLabel();
        txtApuestaActual = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 102));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jScrollPane1.setViewportView(lJugadoresEnPartida);

        btnApostar.setText("Apostar");
        btnApostar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApostarActionPerformed(evt);
            }
        });

        btnPasar.setText("Pasar");

        txtMontoApsotar.setText("Inserte monto");

        btnSalir.setText("Salir");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 156, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 77, Short.MAX_VALUE)
        );

        lblFigura.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        lblFigura.setText("Figura");

        jLabel1.setText("Jugadores activos:");

        carta1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        carta1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/Invertida.gif"))); // NOI18N
        carta1.setBorder(null);

        carta3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/Invertida.gif"))); // NOI18N
        carta3.setBorder(null);

        carta4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/Invertida.gif"))); // NOI18N
        carta4.setBorder(null);

        carta5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/Invertida.gif"))); // NOI18N
        carta5.setBorder(null);

        carta2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/Invertida.gif"))); // NOI18N
        carta2.setBorder(null);

        lbJugador.setText("jLabel2");

        txtApuestaActual.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(carta2)
                                .addGap(19, 19, 19)
                                .addComponent(carta1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(131, 131, 131)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtMontoApsotar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnApostar))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(141, 141, 141)
                                .addComponent(btnPasar))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(carta3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(carta4)))
                        .addGap(18, 18, 18)
                        .addComponent(carta5)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 3, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtApuestaActual)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbJugador)
                                .addGap(233, 233, 233)
                                .addComponent(btnSalir)))
                        .addGap(51, 51, 51))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(152, 152, 152)
                .addComponent(lblFigura, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSalir)
                            .addComponent(lbJugador))
                        .addGap(27, 27, 27)
                        .addComponent(txtApuestaActual)))
                .addGap(26, 26, 26)
                .addComponent(lblFigura, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(carta2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(carta4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(carta5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(carta1))
                            .addComponent(carta3))
                        .addGap(31, 31, 31)
                        .addComponent(txtMontoApsotar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnPasar)
                            .addComponent(btnApostar))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(102, 102, 102))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnApostarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApostarActionPerformed
        abrirDialogoApuesta(null, null);
        
    }//GEN-LAST:event_btnApostarActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
     
        salirMano();
    }//GEN-LAST:event_formWindowClosed

    
    
    public void mostrarCartas(String imagenFile){
        carta1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/2_1.gif")));
        carta2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/14_1.gif")));
        carta3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/10_1.gif")));
        carta4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/12_1.gif")));
        carta5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/8_1.gif")));
       // carta1.setIcon(new javax.swing.ImageIcon(getClass().getResource(rootPath + imagenFile)));
    }
    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApostar;
    private javax.swing.JButton btnPasar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel carta1;
    private javax.swing.JLabel carta2;
    private javax.swing.JLabel carta3;
    private javax.swing.JLabel carta4;
    private javax.swing.JLabel carta5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList lJugadoresEnPartida;
    private javax.swing.JLabel lbJugador;
    private javax.swing.JLabel lblFigura;
    private javax.swing.JLabel txtApuestaActual;
    private javax.swing.JTextField txtMontoApsotar;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mostrarCartas(String c1, String c2, String c3, String c4, String c5) {
        carta1.setIcon(new javax.swing.ImageIcon(getClass().getResource(c1)));
        carta2.setIcon(new javax.swing.ImageIcon(getClass().getResource(c2)));
        carta3.setIcon(new javax.swing.ImageIcon(getClass().getResource(c3)));
        carta4.setIcon(new javax.swing.ImageIcon(getClass().getResource(c4)));
        carta5.setIcon(new javax.swing.ImageIcon(getClass().getResource(c5)));
    }
    
    
    @Override
    public void mostrarJugadoresActivos(List<String> jugadores) {
        lJugadoresEnPartida.setListData(jugadores.toArray());
    }

    @Override
    public void abrirDialogoApuesta(Partida p, JugadorPartida jp) {
        
      //  DialogoApostar vista = new DialogoApostar(this, false, p, jp);
        new DialogoApostar(this, false, cp).setVisible(true);
    }

    @Override
    public void pasar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void salirMano() {
        cp.salir();
        this.dispose();
    }

    @Override
    public void init(String text) {
       lbJugador.setText(text);
    }

    @Override
    public void mostrarApuestaActiva(String jugador, int valor) {
        txtApuestaActual.setText("Apuesta por $ " + valor + "realizada por " + jugador);
    }

    @Override
    public void pedirApuesta(String jugador, int valor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
