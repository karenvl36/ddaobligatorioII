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
     
    public void init(String nombreJugador, String pozo);
    public void mostrarCartas(String c1, String c2, String c3, String c4, String c5, String Figura, String cartas);
    public void mostrarJugadoresActivos(List<String> jugadores);
    public void mostrarApuestaActiva(String jugador, int valor);
    public void actualizarPozo(String pozo);
    
    public void pedirApuesta(String apostante, int valor, String jugador);
    public void abrirDialogoApuesta(Partida p, JugadorPartida jp);
    public void pasar();
    public void fold();
    public void vistaFolded(String cartaReserva, String mensaje);
    
    public void mostrarError(String error);
    public void mostrarMensaje(String mensaje);
    public void mostrarGanador(String ganador, String figura, String cartas, String saldo);
    public void ofrecerSiguienteMano(String ganador, String figura, String cartas, String saldo);
    public void cerrarVentana();
    
    

   
    
}
