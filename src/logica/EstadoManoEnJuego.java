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
public class EstadoManoEnJuego implements EstadoMano {

   
    public void recibirApuesta(JugadorPartida jugador, int monto, Mano mano) throws ManoException {
        //validar que tenga saldo suficiente
        ApuestaMano apuestaMano = new ApuestaMano(jugador, monto);
        ApuestaMano apuesta = new ApuestaMano(jugador, monto);
        mano.setApuesta(apuesta);
        
        mano.vaciarListaPasantes();

    }

  
    public void recibirPasar(JugadorPartida jugador, Mano mano) throws ManoException {
        mano.agregarPasante(jugador);
    }

}
