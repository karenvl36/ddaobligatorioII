/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz.controladores;

import interfaz.LoginVista;
import logica.Fachada;
import logica.UsuarioAdministrador;

import logica.UsuarioJugador;

/**
 *
 * @author chiqu
 */
public class ControladorLogin {
    
    private LoginVista loginVista;

    public ControladorLogin(LoginVista loginVista) {
        this.loginVista = loginVista;
    }
    
    public void ingresar(String nick, String password) {
        
        // Preguntar como se haria con polimorfismo
//        loginVista.logIn(nick,password);
//        loginVista.metodoAuxiliar(u);
//        if (u == null) {
//            loginVista.mostrarError("El usuario es incorrecto");
//        } else {
//            loginVista.abrirDialogo(u);
//        }
    }

    public void logInJugador(String nick, String pass) {
        UsuarioJugador player = (UsuarioJugador) Fachada.getInstancia().logInJugador(nick, pass);
    }

    public void logInAdministrador(String nick, String pass) {
        UsuarioAdministrador admin = (UsuarioAdministrador) Fachada.getInstancia().logInJugador(nick, pass);
      //  loginVista.metodoAuxiliar(admin);
       
    }
    
    
    
    
 

}
