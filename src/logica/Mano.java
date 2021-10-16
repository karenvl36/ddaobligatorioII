/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;

/**
 *
 * @author chiqu
 */
public class Mano {
    
    private List<JugadorPartida> jugadoresActivos;
    private Mazo mazo;
     private int pozo;

      public Mano(List<JugadorPartida> players,Mazo mazo,int pozo){
        this.jugadoresActivos=players;
        this.mazo = mazo;
        this.pozo = pozo;
    }

    public List<JugadorPartida> getJugadoresActivos() {
        return jugadoresActivos;
    }

    public void setJugadoresActivos(List<JugadorPartida> jugadoresActivos) {
        this.jugadoresActivos = jugadoresActivos;
    }

    public Mazo getMazo() {
        return mazo;
    }

    public void setMazo(Mazo mazo) {
        this.mazo = mazo;
    }

    public int getPozo() {
        return pozo;
    }

    public void setPozo(int pozo) {
        this.pozo = pozo;
    }
  
   
    
   
    
  
    
    
    
}
