/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz.vistas;

import interfaz.controladores.ControladorLogin;
import interfaz.controladores.CtrLoginJugador;
import interfaz.vistas.VistaLoginGeneral;
import interfaz.vistas.VistaJugadorLobby;
import logica.Fachada;
import logica.Partida.JugadorPartida;
import logica.Partida.Partida;
import logica.UsuarioGenerico;
import logica.UsuarioJugador;

/**
 *
 * @author chiqu
 */
public class DialogoLoginJugador extends VistaLoginGeneral {

    /**
     * Creates new form DialogoLoginJugador
     */
     //CtrLoginJugador controladorLogin;
    
   // ControladorLogin controladorLogin;
    
    public DialogoLoginJugador(java.awt.Frame parent, boolean modal) {
       
        initComponents();
        this.controladorLogin = new CtrLoginJugador(this);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

//    @Override
//    public void logIn(String name, String passwd) {
//          this.controladorLogin.logUsuario(name, passwd);
//    }
//


//    @Override
//    public void abrirDialogo(UsuarioGenerico userGenerico) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//


    @Override
    public void abrirFrame(Partida partida, UsuarioGenerico usuario) {
     
    }

    @Override
    public void abrirFrame(Partida partida, UsuarioGenerico usuario, JugadorPartida jp) {
        new VistaJugadorLobby(partida, jp).setVisible(true);
        
         this.dispose();
    }
    
      public void abrirFramePartida(Partida p, JugadorPartida jp) {
       
            // new VistaPartida(p, jp).setVisible(true);
         new VistaMano(p, jp).setVisible(true);
         this.dispose();
       
    }





  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
