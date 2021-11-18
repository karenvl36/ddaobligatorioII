/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.Partida;

import excepciones.JugadorException;
import excepciones.ManoException;

/**
 *
 * @author Karen
 */
public class ApuestaMano {

    private int valor;
    private JugadorPartida jugador;

    public ApuestaMano(JugadorPartida jugador, int valor) throws JugadorException {
        this.jugador = jugador;
        setValor(valor);
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int apuestaMano) throws JugadorException {
           // validarApuesta(apuestaMano);
            this.valor = apuestaMano;
       
        
    }

    public JugadorPartida getJugador() {
        return jugador;
    }

    public void setJugador(JugadorPartida jugador) {
        this.jugador = jugador;
    }

    
    public String getNickJugador(){
        return this.jugador.getJugador().getNick();
    }

}
