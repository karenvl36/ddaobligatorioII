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
public interface EstadoMano {
    
   
    
    public abstract void recibirApuesta(JugadorPartida jugador,int monto, Mano mano) throws ManoException;
    public abstract void recibirPasar(JugadorPartida jugador, Mano mano) throws ManoException;
    
    
    
    
}
