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
    public Partida partidaAIniciar;
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
        partidaAIniciar = new Partida();

    }

    public boolean agregar(Partida p) {
        return this.partidasEnCurso.add(p);
    }

    public boolean terminar(Partida p) {
        return this.partidasEnCurso.add(p);
    }

    public void crearPartida() {

        Partida partidaNueva = new Partida();
        partidaAIniciar = partidaNueva;

    }

    public Partida getPartidaSinIniciar() {
        return this.partidaAIniciar;
    }

    public JugadorPartida unirJugadorPartida(UsuarioJugador j) {
        JugadorPartida jugadorRetorno = null;
        if (partidaAIniciar != null) {
            jugadorRetorno = partidaAIniciar.agregar(j);
            if (jugadorRetorno != null && partidaAIniciar.comprobarInicio() != null) {
                    agregar(partidaAIniciar);
                    crearPartida();

            }
        }
        return jugadorRetorno;

    }

}
