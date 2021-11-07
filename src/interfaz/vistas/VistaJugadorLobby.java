
package interfaz.vistas;

import interfaz.VistaLobbyPartida;
import interfaz.controladores.ControladorPartida;
import logica.JugadorPartida;
import logica.Partida;
import logica.UsuarioJugador;




public class VistaJugadorLobby extends javax.swing.JFrame implements VistaLobbyPartida {

private Partida estaPartidaNoIniciada;
private UsuarioJugador jugador;
private JugadorPartida jugadorP;
private ControladorPartida cp;
    public VistaJugadorLobby(Partida partidaLobby,UsuarioJugador jugador) {
        initComponents();
        this.estaPartidaNoIniciada = partidaLobby;
        this.jugador=jugador;
        //(VistaPartida view, VistaLobbyPartida lobbyView, Partida unaPartida, JugadorPartida player)
        cp = new ControladorPartida(null,this,estaPartidaNoIniciada,jugadorP);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelEsperandoJugadores = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        labelEsperandoJugadores.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(221, 221, 221)
                .addComponent(labelEsperandoJugadores)
                .addContainerGap(256, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(labelEsperandoJugadores)
                .addContainerGap(277, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
       cp.salir();
       this.dispose();
    }//GEN-LAST:event_formWindowClosed

   


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel labelEsperandoJugadores;
    // End of variables declaration//GEN-END:variables


    
    @Override
    public void mostrarJugadoresFaltantes(int cantJugadoresFaltantes) {
        labelEsperandoJugadores.setText("Faltan: " + cantJugadoresFaltantes);
        this.setTitle("Esperando jugadores, faltan: " + cantJugadoresFaltantes);
    }

 



  
}
