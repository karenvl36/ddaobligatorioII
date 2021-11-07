/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import excepciones.JugadorException;
import excepciones.ManoException;
import observador.Observador;

/**
 *
 * @author chiqu
 */
public class EstadoManoSinApuestas implements EstadoMano {

   @Override
    public void recibirApuesta(JugadorPartida jugador, int monto, Mano mano) throws JugadorException {
            jugador.realizarApuesta(monto);      
            ApuestaMano apuesta = new ApuestaMano(jugador, monto);
            mano.setApuesta(apuesta);
            mano.sumarPozo(monto);
            mano.vaciarListaPasantes();

       

    }

  @Override
    public void recibirPasar(JugadorPartida jugador, Mano mano) {
        mano.agregarPasante(jugador);
     
    }

    @Override
    public JugadorPartida finalizarMano(Mano mano) {
        mano.notificar(Observador.Evento.MANO_FINALIZADA);
        return null;
        //TODO: Si lo llama partida, no neceista notificar.
       
    }

    @Override
    public void recibirMatchApuesta(JugadorPartida j, Mano mano) throws JugadorException {
        throw new JugadorException("No hay apuestas que matchear");
    }

}