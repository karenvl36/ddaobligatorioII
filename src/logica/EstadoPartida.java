/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import excepciones.JugadorException;
import excepciones.ManoException;
import excepciones.PartidaException;

/**
 *
 * @author chiqu
 */
public interface  EstadoPartida {
   
    
    public Partida agregar(JugadorPartida jp, Partida p) throws PartidaException, JugadorException, ManoException;
           
    
}
