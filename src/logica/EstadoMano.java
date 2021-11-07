/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import excepciones.JugadorException;
import excepciones.ManoException;


/**
 *
 * @author chiqu
 */
public interface EstadoMano {
    
   
    
    public void recibirApuesta(JugadorPartida jugador, int monto, Mano mano) throws JugadorException;
    public abstract void recibirPasar(JugadorPartida jugador, Mano mano);
    public JugadorPartida finalizarMano(Mano mano);
    public void recibirMatchApuesta(JugadorPartida j, Mano mano) throws JugadorException;
    
    
    
    
}
