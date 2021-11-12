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
        PARTIDA_INICIADA,
        PARTIDA_FINALIZADA,
        APUESTA_RECIBIDA,
        APUESTA_PEDIDA,
        MANO_COMENZADA,
        TURNO_JUGADO,
        MANO_FINALIZADA,
        JUGADOR_ELIMINADO_SALDO_INSUFICIENTE;
        
        
       
        
    }
 
    public void notificar(Observable source, Object event);
}
