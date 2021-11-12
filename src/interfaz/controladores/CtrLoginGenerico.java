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

/**
 *
 * @author chiqu
 */

//TODO: eliminar esto 
public class CtrLoginGenerico  {

//    private CtrLoginJugador loginJugador;
//    private CtrLoginAdmin loginAdmin;
//    
//    public CtrLoginGenerico(LoginVista loginVista) {
//        super(loginVista);
//        loginJugador = new CtrLoginJugador(loginVista);
//        loginAdmin = new CtrLoginAdmin(loginVista);
//    }
//    
//
//    
//    
//
//    @Override
//    protected UsuarioGenerico logUsuario(String nick, String pass) {
//       UsuarioAdministrador a = (UsuarioAdministrador) Fachada.getInstancia().logInAdmin(nick,pass);
//        if(a!=null){
//            UsuarioAdministrador adm = (UsuarioAdministrador) loginAdmin.logUsuario(a.getNick(), a.getContraseña());
//            loginAdmin.abrirFrame(adm);
//           return a;
//        }
//        else{
//            UsuarioJugador j = (UsuarioJugador) Fachada.getInstancia().logInJugador(nick,pass);
//            UsuarioJugador jug = (UsuarioJugador) loginJugador.logUsuario(nick,pass);
//            loginJugador.abrirFrame(jug);
//            return j;
//        }
//    }
//
//    @Override
//    protected void abrirFrame(UsuarioGenerico u) {
//    
//    }
    
}
