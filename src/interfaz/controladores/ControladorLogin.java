/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz.controladores;

import excepciones.UserExceptions;
import interfaz.LoginVista;

import logica.UsuarioGenerico;


/**
 *
 * @author chiqu
 */
public abstract class ControladorLogin  {
    
    protected LoginVista loginVista;

    public ControladorLogin(LoginVista loginVista) {
        this.loginVista = loginVista;
    }
    
    public void ingresar(String nick, String password) {
                
        try{
        
        UsuarioGenerico u = logUsuario(nick, password);
      
        if (u == null) {
            loginVista.mostrarError("El usuario es incorrecto");
        } else {
            this.abrirFrame(u);
 
        }
        
        }catch(UserExceptions ex){
        
             loginVista.mostrarError(ex.getMessage());
        }
    }

    public void setLoginVista(LoginVista loginVista) {
        this.loginVista = loginVista;
    }
    
   
    protected abstract UsuarioGenerico logUsuario(String nick, String pass) throws UserExceptions;
    protected abstract void abrirFrame(UsuarioGenerico u);


//    public void logInJugador(String nick, String pass) {
//        UsuarioJugador player = (UsuarioJugador) Fachada.getInstancia().logInJugador(nick, pass);
//    }
//
//    public void logInAdministrador(String nick, String pass) {
//        UsuarioAdministrador admin = (UsuarioAdministrador) Fachada.getInstancia().logInJugador(nick, pass);
// 
//       
//    }
    
    
    
    
 

}
