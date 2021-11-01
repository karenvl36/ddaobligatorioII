/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import excepciones.ManoException;

/**
 *
 * @author Karen
 */
public class ApuestaMano {

    private int valor;
    private JugadorPartida jugador;

    public ApuestaMano(JugadorPartida jugador, int valor) throws ManoException {
        this.jugador = jugador;
        setValor(valor);
    }

    public int getApuestaMano() {
        return valor;
    }

    public void setValor(int apuestaMano) throws ManoException {
        if (validarApuesta(apuestaMano)) {
            this.valor = apuestaMano;
        }
        throw new ManoException("Su saldo es insuficiente para realizar esta apuesta.");
    }

    public JugadorPartida getJugador() {
        return jugador;
    }

    public void setJugador(JugadorPartida jugador) {
        this.jugador = jugador;
    }

    public boolean validarApuesta(int valorApuesta) {
        return this.jugador.saldoSuficiente(valorApuesta);
    }

}
