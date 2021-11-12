/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import excepciones.JugadorException;
import excepciones.PartidaException;
import java.util.ArrayList;
import java.util.List;
import observador.Observable;

/**
 *
 * @author chiqu
 */
public class Fachada extends Observable {
    private static Fachada instancia;
    ServicioUsuario su = ServicioUsuario.getInstancia();
    ServicioPartida sp = new ServicioPartida();

    public static Fachada getInstancia() {
        if (instancia == null) {
            instancia = new Fachada();
        }
        return instancia;
    }
    
    
    

    
    public UsuarioGenerico logInAdmin(String name,String pw){
        return su.logInAdmin(name, pw);
    }
    
    
    public UsuarioGenerico logInJugador(String name,String pw){
        return su.logInJugador(name, pw);
    }
    
    
    public Partida unirJugadorPartida(JugadorPartida j) throws PartidaException, JugadorException{
         return sp.unirJugadorPartida(j);
    }
    
    public Partida getPartidaSinIniciar(){
        return sp.getPartidaSinIniciar();
    }
    
    public List<Partida> getPartidasEnCurso(){
        return sp.getPartidasEnCurso();
    }
    
  
    
}
