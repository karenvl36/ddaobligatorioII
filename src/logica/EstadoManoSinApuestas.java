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
            mano.agregarTurnoJugado(jugador);
           

       

    }

  @Override
    public void recibirPasar(JugadorPartida jugador, Mano mano) throws JugadorException {
        if(mano.getPasantes().contains(jugador)){
            throw new JugadorException("Ya pasó esta mano"); 
        }
            mano.agregarTurnoJugado(jugador);
     
    }

    @Override
    public JugadorPartida finalizarMano(Mano mano) {
      //  mano.notificar(Observador.Evento.MANO_FINALIZADA);
                 //   mano.revisarGanador(); //Solo para test
        mano.notificar(Observador.Evento.MANO_FINALIZADA);
        return null;
        //TODO: Si lo llama partida, lo tiene que notificar Partida que es a donde está suscripto
       
    }

    @Override
    public void recibirMatchApuesta(JugadorPartida j, Mano mano) throws JugadorException {
        throw new JugadorException("No hay apuestas que matchear");
    }

    @Override
    public void retirarJugador(JugadorPartida j, Mano m) {
        m.getJugaronTurno().remove(j);
        m.getJugadoresActivos().remove(j);
    }

}
