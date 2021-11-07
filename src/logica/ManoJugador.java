/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;

/**
 *
 * @author Karen
 */
public class ManoJugador {
    int apuestaTurno;
    ArrayList<Carta> cartas;
    Figura figura;

    // <editor-fold defaultstate="collapsed" desc="Getters-Setters">
    public int getApuestaTurno() {
        return apuestaTurno;
    }

    public void setApuestaTurno(int apuestaTurno) {
        this.apuestaTurno = apuestaTurno;
    }

    public ArrayList<Carta> getCartas() {
        return cartas;
    }

    public void setCartas(ArrayList<Carta> cartas) {
        this.cartas = cartas;
    }

    public Figura getFigura() {
        return figura;
    }

    public void setFigura(Figura figura) {
        this.figura = figura;
    }


    // </editor-fold>
    
    
}
