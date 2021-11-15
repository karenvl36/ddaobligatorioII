/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz.controladores;

import interfaz.IVistaAdmin;
import java.util.List;
import logica.Fachada;
import logica.Partida;
import logica.UsuarioAdministrador;
import observador.Observable;
import observador.Observador;

/**
 *
 * @author chiqu
 */
public class ControladorAdmin implements Observador {

    private UsuarioAdministrador admin;
    private IVistaAdmin vista;
    private Partida partidaEnFoco;

    public ControladorAdmin(IVistaAdmin vista, UsuarioAdministrador adm) {
        this.vista = vista;
        this.admin = adm;
        Fachada.getInstancia().subscribir(this);
      
    }

    public ControladorAdmin(IVistaAdmin vista) {
        this.vista = vista;
        Fachada.getInstancia().subscribir(this);
    }

    @Override
    public void notificar(Observable source, Object event) {
        if (event == Observador.Evento.PARTIDA_INICIADA || event == Observador.Evento.PARTIDA_FINALIZADA
                || event == Observador.Evento.POZO_MODIFICADO || event == Observador.Evento.MANO_COMENZADA
                || event == Observador.Evento.MANO_FINALIZADA) {
            actualizar();
        }
        //JUGADOR_ELIMINADO? - tiene que saber la cantidad de jugadores que tuvo la partida o lo que todavía están?
        //Actualiza la info de cant jugadores de la partida
        //POZO_AUMENTADO - el total apostado en la partida es tanto de las apuestas como de lo que matcheo?
        //Actualiza el total apostado de la partida 
        //Actualiza el total apostado por jugador
        //MANO_INICIADA
        //Actualiza la cant de manos de la partida
        //MANO_FINALIZADA??? o GANADOR_DECLARADO???
        //Para actualizar el total ganado por jugador
        {
            
        }
    }

    public void actualizar() {
        vista.actualizar(Fachada.getInstancia().getPartidasEnCurso());
        if(partidaEnFoco != null) vista.mostrarDetallesJugadores(partidaEnFoco.getJugadores());
        
    }

    /*El sistema muestra la lista de partidas en curso indicando fecha/hora de inicio, cantidad de
jugadores en la partida, total apostado en la partida y cantidad de manos jugadas.

    El usuario podrá seleccionar una partida y visualizar el nombre completo, el total apostado
en esa partida, el saldo al iniciar la partida y el total ganado (puede ser negativo) de cada
uno de los jugadores que han participado en esa partida.*/
    public void getJugadoresPartidaSeleccionada(Object selectedValue) {
        Partida p = (Partida) selectedValue;
        if (p != null) {
            partidaEnFoco = p;
            vista.mostrarDetallesJugadores(p.getJugadores());
            
        }

    }

}
