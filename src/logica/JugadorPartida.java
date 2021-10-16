/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author chiqu
 */
public class JugadorPartida {

    private Partida partida;
    private UsuarioJugador jugador;
    private int saldoInicial;

    public JugadorPartida(Partida p, UsuarioJugador j, int saldoInicial) {
        this.partida = p;
        this.jugador = j;
        this.saldoInicial = saldoInicial;
    }

    public Partida getPartida() {
        return partida;
    }

    public void setPartida(Partida partida) {
        this.partida = partida;
    }

    public UsuarioJugador getJugador() {
        return jugador;
    }

    public void setJugador(UsuarioJugador jugador) {
        this.jugador = jugador;
    }

    public int getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(int saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

}
