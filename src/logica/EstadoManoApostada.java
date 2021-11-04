/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import excepciones.ManoException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chiqu
 */
public class EstadoManoApostada extends EstadoMano {

    @Override
    public void apostar(JugadorPartida jugador,int monto) throws ManoException{
        try {
            throw new ManoException("No puedes apostar si alguien ya apostó");
        } catch (ManoException ex) {
            Logger.getLogger(EstadoManoApostada.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void pasar(JugadorPartida jugador) throws ManoException {
        // Como se manipulan los metodos de Mano en este?
    }
    
}
