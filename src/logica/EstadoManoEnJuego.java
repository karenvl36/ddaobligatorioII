/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import excepciones.ManoException;
import observador.Observador;

/**
 *
 * @author chiqu
 */
public class EstadoManoEnJuego implements EstadoMano {

   @Override
    public void recibirApuesta(JugadorPartida jugador, int monto, Mano mano) throws ManoException {
        if (jugador.realizarApuesta(monto)) {      
            ApuestaMano apuesta = new ApuestaMano(jugador, monto);
            mano.setApuesta(apuesta);
            mano.sumarPozo(monto);
            mano.vaciarListaPasantes();

        }
        
         throw new ManoException("No tiene saldo suficiente para realizar esta apuesta.");

    }

  @Override
    public void recibirPasar(JugadorPartida jugador, Mano mano) throws ManoException {
        mano.agregarPasante(jugador);
     
    }

    @Override
    public void finalizarMano(Mano mano) {
        mano.notificar(Observador.Evento.MANO_FINALIZADA);

        //TODO: Método de finalizar mano pasada
       
    }

    @Override
    public void recibirMatchApuesta(JugadorPartida jugador, Mano mano) throws ManoException {
        throw new ManoException("No hay apuestas que matchear");
    }

}
