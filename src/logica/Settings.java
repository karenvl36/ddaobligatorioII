/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author Karen
 */
public class Settings {
    
        private static int apuestaBase; //solo para probar
        private static int cantMaximaJugadores; //test
        private static Settings instancia; 

    public static Settings getInstancia() {
        if (instancia == null){
            instancia = new Settings();  
        }        
        
        return instancia;
    }

    
 
    private Settings() {
        
    }

        
        
    public int getApuestaBase() {
        return apuestaBase;
    }

    public void setApuestaBase(int apuestaBase) {
        this.apuestaBase = apuestaBase;
    }

    public int getCantMaximaJugadores() {
        return cantMaximaJugadores;
    }

    public void setCantMaximaJugadores(int cantMaximaJugadores) {
        this.cantMaximaJugadores = cantMaximaJugadores;
    }
    
}
