/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import excepciones.ManoException;
import java.util.List;

/**
 *
 * @author chiqu
 */
public abstract class EstadoMano {
    
    protected List<JugadorPartida> pasantes;
    protected ApuestaMano apuesta;

    public List<JugadorPartida> getPasantes() {
        return pasantes;
    }

    public void setPasantes(List<JugadorPartida> pasantes) {
        this.pasantes = pasantes;
    }

    public ApuestaMano getApuesta() {
        return apuesta;
    }

    public void setApuesta(ApuestaMano apuesta) {
        this.apuesta = apuesta;
    }
    
    
    public abstract void apostar(JugadorPartida jugador,int monto) throws ManoException;
    public abstract void pasar(JugadorPartida jugador) throws ManoException;
    
    
    
    
}
