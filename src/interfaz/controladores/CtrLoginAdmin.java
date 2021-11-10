/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz.controladores;

import interfaz.LoginVista;
import logica.Fachada;
import logica.UsuarioGenerico;
import observador.Observable;

/**
 *
 * @author Karen
 */
public class CtrLoginAdmin extends ControladorLogin {
    
     
   public CtrLoginAdmin(LoginVista loginVista) {
          super(loginVista);
   }

    @Override
    public UsuarioGenerico logUsuario(String nick, String pass) {
        return Fachada.getInstancia().logInAdmin(nick, pass);
    }

    @Override
    protected void abrirFrame(UsuarioGenerico u) {
          loginVista.abrirFrame(null, u, null);
    }


    
}
