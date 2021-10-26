/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author chiqu
 */
public class ServicioPartida {

    public List<Partida> partidasEnCurso;
    public Partida partidaNoIniciada; 
//    private static ServicioPartida instancia;
//
//    public static ServicioPartida getInstancia() {
//
//        if (instancia == null) {
//            instancia = new ServicioPartida();
//        }
//        return instancia;
//    }

    public ServicioPartida() {
        this.partidasEnCurso = new ArrayList<>();
        partidaNoIniciada = new Partida();
   
    }

    public boolean agregar(Partida p) {
        return this.partidasEnCurso.add(p);
    }

    public boolean terminar(Partida p) {
        return this.partidasEnCurso.add(p);
    }
    
    public void crearPartida(){
   
            Partida partidaNueva = new Partida();
            partidaNoIniciada = partidaNueva;

    }
    
    public void unirJugadorPartida(UsuarioJugador j) {
        JugadorPartida jugador = new JugadorPartida(j);
        
        if (partidaNoIniciada != null) {
            if (partidaNoIniciada.agregar(jugador) != null) {

                this.agregar(partidaNoIniciada);
                crearPartida();
         
            }
        }

    }



}
