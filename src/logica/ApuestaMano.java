/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author Karen
 */
public class ApuestaMano {
    
    int valor;
    JugadorPartida jugador;

    public int getApuestaMano() {
        return valor;
    }

    public void setValor(int apuestaMano) {
        this.valor = apuestaMano;
    }

    public JugadorPartida getJugador() {
        return jugador;
    }

    public void setJugador(JugadorPartida jugador) {
        this.jugador = jugador;
    }
    
}
