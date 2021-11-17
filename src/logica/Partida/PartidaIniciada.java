/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.Partida;

import excepciones.PartidaException;

/**
 *
 * @author chiqu
 */
public class PartidaIniciada implements EstadoPartida {

    @Override
    public Partida agregar(JugadorPartida jp, Partida p) throws PartidaException {
        throw new PartidaException("La partida ya está iniciada");
        //Exception: no puede ingresar a una partida ya iniciada
    }

    
  
  
}
