/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.Partida;

import excepciones.JugadorException;
import excepciones.ManoException;
import excepciones.PartidaException;

/**
 *
 * @author chiqu
 */
public class PartidaFinalizada implements EstadoPartida {

    @Override
   public Partida agregar(JugadorPartida jp, Partida p) throws PartidaException, JugadorException, ManoException {
        throw new PartidaException("No puede unirse a una partida finalizada."); //To change body of generated methods, choose Tools | Templates.
        //Exception: Esta partida está fnalizada
    }

  
   
    
}
