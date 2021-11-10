/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz.controladores;

import excepciones.JugadorException;
import excepciones.PartidaException;
import interfaz.LoginVista;
import logica.EstadoPartidaIniciada;
import logica.Fachada;
import logica.JugadorPartida;
import logica.Partida;
import logica.UsuarioGenerico;
import logica.UsuarioJugador;
import observador.Observable;
import observador.Observador;

/**
 *
 * @author Karen
 */
public class CtrLoginJugador extends ControladorLogin {
    
    
    private JugadorPartida jp;
    private Partida p;
    
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

            JugadorPartida jp = new JugadorPartida((UsuarioJugador)u);
             Partida p = Fachada.getInstancia().unirJugadorPartida(jp);
//             p.subscribir(this);
//            this.jp = jp;
//            this.p = p;
           
                
            if(p.faltanJugadores() == 0){ //TODO: Esto está mal porquen no debería preguntar
               loginVista.abrirFramePartida(p, jp);
            }else{
               loginVista.abrirFrame(p, u, jp); //Este abre el lobby
            }
               

            
        }catch(PartidaException pe ){
        
            loginVista.mostrarError(pe.getMessage());
        }catch(JugadorException je){
            loginVista.mostrarError(je.getMessage());
        
        }
       
    }


    

     
     
}
