/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz.controladores;

import interfaz.IVistaAdmin;
import logica.Fachada;
import logica.Partida.Partida;
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
                || event == Observador.Evento.MANO_FINALIZADA  || event == Observador.Evento.JUGADOR_ELIMINADO) {
            actualizar();
        }
        //JUGADOR_ELIMINADO - actualiza cantidad de jugadores que siguen en la partida
        //POZO_AUMENTADO 
        //Actualiza el total apostado de la partida 
        //Actualiza el total apostado por jugador
        //MANO_INICIADA
        //Actualiza la cant de manos de la partida
        //MANO_FINALIZADA
        //Para actualizar el total ganado por jugador
        {
            
        }
    }

    public void actualizar() {
        vista.actualizar(Fachada.getInstancia().getPartidasEnCurso());
        if(partidaEnFoco != null) vista.mostrarDetallesJugadores(partidaEnFoco.getJugadores());
        
    }


    public void getJugadoresPartidaSeleccionada(Object selectedValue) {
        Partida p = (Partida) selectedValue;
        if (p != null) {
            partidaEnFoco = p;
            vista.mostrarDetallesJugadores(p.getJugadores());
            
        }

    }

}
