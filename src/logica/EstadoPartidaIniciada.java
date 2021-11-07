/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import excepciones.PartidaException;

/**
 *
 * @author chiqu
 */
public class EstadoPartidaIniciada implements EstadoPartida {

    @Override
    public JugadorPartida agregar(UsuarioJugador jugador, Partida p) throws PartidaException {
        throw new PartidaException("La partida ya está iniciada");
        //Exception: no puede ingresar a una partida ya iniciada
    }

    
  
  
}
