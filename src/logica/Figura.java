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
public abstract class Figura implements Comparable<Figura>{
    
    private String descripcion;
    private Palo palo;
    private Carta highCard;
    private List<Carta> cartas;
    
    
    public abstract boolean esFigura(List<Carta> cartasEvaluar);
    public abstract int desempatar(Figura f); 

    @Override
    public abstract int compareTo(Figura o);
    
           
    
}
