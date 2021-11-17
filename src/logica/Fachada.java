/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import logica.Partida.JugadorPartida;
import logica.Partida.ServicioPartida;
import logica.Partida.Partida;
import excepciones.JugadorException;
import excepciones.ManoException;
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
    
    
    public Partida unirJugadorPartida(JugadorPartida j) throws PartidaException, JugadorException, ManoException{
         return sp.unirJugadorPartida(j);
    }
    
    public Partida getPartidaSinIniciar(){
        return sp.getPartidaSinIniciar();
    }
    
    public List<Partida> getPartidasEnCurso(){
        return sp.getPartidasEnCurso();
    }

    public boolean agregar(Partida p) {
        return sp.agregar(p);
    }

    public void apostar(Partida p, JugadorPartida j, int apuesta) throws JugadorException {
        sp.apostar(p, j, apuesta);
    }

    public void pasar(Partida p, JugadorPartida j) throws ManoException, JugadorException {
        sp.pasar(p, j);
    }

    public void matchApuesta(Partida p, JugadorPartida j) throws JugadorException {
        sp.matchApuesta(p, j);
    }

    public void retirarJugador(Partida p, JugadorPartida j) {
        sp.retirarJugador(p, j);
    }

    public void unirJugadorASiguienteMano(Partida p, JugadorPartida j) throws JugadorException, ManoException {
        sp.unirJugadorASiguienteMano(p, j);
    }


    
    
    
  
    
}
