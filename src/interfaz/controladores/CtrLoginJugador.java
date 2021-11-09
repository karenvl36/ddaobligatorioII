/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz.controladores;

import excepciones.JugadorException;
import excepciones.PartidaException;
import interfaz.LoginVista;
import logica.Fachada;
import logica.JugadorPartida;
import logica.Partida;
import logica.UsuarioGenerico;
import logica.UsuarioJugador;

/**
 *
 * @author Karen
 */
public class CtrLoginJugador extends ControladorLogin {
    
    
     public CtrLoginJugador(LoginVista loginVista) {
          super(loginVista);
   }

    @Override
    public UsuarioGenerico logUsuario(String nick, String pass) {
         return Fachada.getInstancia().logInJugador(nick, pass);
    }

    @Override
    protected void abrirFrame(UsuarioGenerico u) {   
        try{
            Partida p = Fachada.getInstancia().getPartidaSinIniciar();  
            //JugadorPartida jp = new JugadorPartida(u);
            JugadorPartida jp = Fachada.getInstancia().unirJugadorPartida((UsuarioJugador)u);      
            loginVista.abrirFrame(p, u, jp);
            
        }catch(PartidaException pe ){
        
            loginVista.mostrarError(pe.getMessage());
        }catch(JugadorException je){
            loginVista.mostrarError(je.getMessage());
        
        }
       
    }
    

     
     
}
