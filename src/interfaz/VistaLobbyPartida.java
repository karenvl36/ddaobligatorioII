/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import logica.JugadorPartida;
import logica.Partida;

/**
 *
 * @author chiqu
 */
public interface VistaLobbyPartida {
    
   
    public void mostrarJugadoresFaltantes(int cantJugadoresFaltantes);
    public void abrirFrame(Partida p, JugadorPartida jp);
    
    
}
