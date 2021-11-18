/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz.controladores;

import excepciones.JugadorException;
import excepciones.ManoException;
import excepciones.PartidaException;
import excepciones.UserExceptions;
import interfaz.LoginVista;
import logica.Fachada;
import logica.Partida.JugadorPartida;
import logica.Partida.Partida;
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
    public UsuarioGenerico logUsuario(String nick, String pass) throws UserExceptions {
         return Fachada.getInstancia().logInJugador(nick, pass);
    }

    @Override
    protected void abrirFrame(UsuarioGenerico u) {   
        try{

            JugadorPartida jp = new JugadorPartida((UsuarioJugador)u);
             Partida p = Fachada.getInstancia().unirJugadorPartida(jp);      
            if(p.ultimoJugadorEnUnirse()){ //TODO: ???
               loginVista.abrirFramePartida(p, jp);
            }else{
               loginVista.abrirFrame(p, u, jp); //Este abre el lobby
            }
               

            
        }catch(ManoException me){
        
            loginVista.mostrarError(me.getMessage());
     
        }catch(JugadorException je){
            loginVista.mostrarError(je.getMessage());
        
        }catch(PartidaException pe){
            loginVista.mostrarError(pe.getMessage());
        }
       
    }


    

     
     
}
