/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz.vistas;


import interfaz.controladores.CtrLoginAdmin;
import interfaz.vistas.VistaLoginGeneral;
import logica.Partida.JugadorPartida;
import logica.Partida.Partida;
import logica.UsuarioAdministrador;
import logica.UsuarioGenerico;

/**
 *
 * @author chiqu
 */
public class DialogoLoginAdministrador extends VistaLoginGeneral {

  

    /**
     * Creates new form DialogoLoginUsuario
     */
   // CtrLoginAdmin controladorLogin;
    public DialogoLoginAdministrador(java.awt.Frame parent, boolean modal) {

        initComponents();
        this.controladorLogin = new CtrLoginAdmin(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
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
//        this.controladorLogin.logUsuario(name, passwd);
//    
//
//    }

    @Override 
     public void abrirFrame(Partida partida, UsuarioGenerico usuario, JugadorPartida jp) {
        new VistaAdministrador((UsuarioAdministrador) usuario).setVisible(true);
        this.dispose();
    }

    @Override
    public void abrirFrame(Partida partida, UsuarioGenerico usuario) {
       new VistaAdministrador((UsuarioAdministrador) usuario).setVisible(true);
        this.dispose();
    }

    @Override
    public void abrirFramePartida(Partida p, JugadorPartida jp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 
    
    

    

  
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
