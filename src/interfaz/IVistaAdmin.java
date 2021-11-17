/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.util.List;
import logica.Partida.JugadorPartida;
import logica.Partida.Partida;

/**
 *
 * @author chiqu
 */
public interface IVistaAdmin {

    public void actualizar(List<Partida> partidasEnCurso);

    public void mostrarDetallesJugadores(List<JugadorPartida> jugadores);
    
}
