/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observador;

public interface Observador {
    
    public enum Evento {
        JUGADOR_AGREGADO,
        JUGADOR_ELIMINADO,
        MANO_FINALIZADA,
        APUESTA_PEDIDA,
        MANO_COMENZADA,
        PARTIDA_FINALIZADA,
        PARTIDA_INICIADA;
        
    }
 
    public void notificar(Observable source, Object event);
}
