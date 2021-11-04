/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import excepciones.ManoException;

/**
 *
 * @author chiqu
 */
public class EstadoManoEnJuego extends EstadoMano {

    @Override
    public void apostar(JugadorPartida jugador, int monto) throws ManoException {
        ApuestaMano apuestaMano = new ApuestaMano(jugador, monto);
        apuesta = apuestaMano;
        pasantes.clear();

    }

    @Override
    public void pasar(JugadorPartida jugador) throws ManoException {
        pasantes.add(jugador);
    }

}
