/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;

/**
 *
 * @author Karen
 */
public class FiguraPar extends Figura {

    public FiguraPar() {
        this.setDescripcion("Par");
        this.setPuntaje(5);
    }

    
    @Override
    public boolean esFigura(List<Carta> cartasEvaluar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int desempatar(Figura f) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 
    
}
