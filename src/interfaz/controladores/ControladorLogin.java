/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz.controladores;

import interfaz.LoginVista;
import logica.Fachada;
import logica.UsuarioAdministrador;
import logica.UsuarioGenerico;

import logica.UsuarioJugador;
import observador.Observador;

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
                
        UsuarioGenerico u = logUsuario(nick, password);
      
        if (u == null) {
            loginVista.mostrarError("El usuario es incorrecto");
        } else {
            this.abrirFrame(u);
 
        }
    }

    public void setLoginVista(LoginVista loginVista) {
        this.loginVista = loginVista;
    }
    
    //TODO: Averiguar si es válido que haya un retorno que no sea void si el método es para uso itnerno del Controller
    protected abstract UsuarioGenerico logUsuario(String nick, String pass);
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
