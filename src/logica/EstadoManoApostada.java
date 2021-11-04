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
public class EstadoManoApostada implements EstadoMano {

    
    public void recibirApuesta(JugadorPartida jugador,int monto, Mano mano) throws ManoException{
     
            throw new ManoException("No puedes apostar si alguien ya apostó");
       
    }


    public void recibirPasar(JugadorPartida jugador, Mano mano) throws ManoException {
        mano.eliminar(jugador);
        
    }
    
}
