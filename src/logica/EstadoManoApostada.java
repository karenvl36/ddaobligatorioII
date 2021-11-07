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
public class EstadoManoApostada implements EstadoMano {

    @Override
    public void recibirApuesta(JugadorPartida jugador,int monto, Mano mano) throws JugadorException{
     
            throw new JugadorException("No puedes apostar si alguien ya apostó");
       
    }

    @Override
    public void recibirPasar(JugadorPartida jugador, Mano mano) {
        mano.eliminar(jugador);
        
    }

    @Override
    public void recibirMatchApuesta(JugadorPartida j, Mano mano) throws JugadorException {
          
        j.realizarApuesta(mano.getApuesta().getValor());//pasamos el valor de la apuesta en juego
            mano.sumarPozo(mano.getApuesta().getValor());
            mano.comprobarFinalizacion();
        
        
  

    }
    
    
    @Override
   public JugadorPartida finalizarMano(Mano mano) {
        JugadorPartida ganador = null;
        if(mano.getJugadoresActivos().size() == 1){
            ganador = mano.getApuesta().getJugador();
        }else{
             //TODO; Revisar ganador

        }
         mano.declararGanador(ganador);
         mano.notificar(Observador.Evento.MANO_FINALIZADA);
         
         return ganador;
    }

    
}
