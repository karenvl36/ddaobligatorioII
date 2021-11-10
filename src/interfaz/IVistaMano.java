/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.util.List;
import logica.JugadorPartida;
import logica.Partida;

/**
 *
 * @author chiqu
 */
public interface IVistaMano {
        
    public void mostrarCartas(String c1, String c2, String c3, String c4, String c5);
    public void mostrarJugadoresActivos(List<String> jugadores);
    public void abrirDialogoApuesta(Partida p, JugadorPartida jp);
    public void pasar();
    public void salirMano();
    public void init(String text);
    public void mostrarApuestaActiva(String jugador, int valor);
    public void pedirApuesta(String jugador, int valor);
   
    
}
