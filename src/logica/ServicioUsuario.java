/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import excepciones.UserExceptions;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author chiqu
 */
public class ServicioUsuario {

    public List<UsuarioGenerico> usuarios;
    public List<UsuarioAdministrador> administradores;
    public List<UsuarioJugador> jugadores;
    public static ServicioUsuario instancia;

    public static ServicioUsuario getInstancia() {

        if (instancia == null) {
            instancia = new ServicioUsuario();
        }
        return instancia;
    }

    public ServicioUsuario() {
        this.usuarios = new ArrayList<>();
        this.administradores = new ArrayList<>();
        this.jugadores = new ArrayList<>();

    }

    // Agregar y Eliminar
    public boolean agregar(UsuarioGenerico user) {
        return this.usuarios.add(user);
    }

    public boolean agregar(UsuarioJugador jugador) {
        return this.jugadores.add(jugador);
    }

    public void agregar(UsuarioAdministrador admin) {
        this.administradores.add(admin);
    }

    /// Getters and Setters ///
    public List<UsuarioGenerico> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<UsuarioGenerico> usuarios) {
        this.usuarios = usuarios;
    }

    public List<UsuarioAdministrador> getAdministradores() {
        return administradores;
    }

    public void setAdministradores(List<UsuarioAdministrador> administradores) {
        this.administradores = administradores;
    }

    public List<UsuarioJugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<UsuarioJugador> jugadores) {
        this.jugadores = jugadores;
    }

    /// Metodos ///
    public UsuarioGenerico logInGenerico(String nickName, String password, List<UsuarioGenerico> usuarios) throws UserExceptions {
        for (UsuarioGenerico user : usuarios) {
            if (user.getNick().equals(nickName)) {

                user.checkPassword(password);
               
                    return user;

            }
        }
        return null;
    }

    public UsuarioAdministrador logInAdmin(String nickName, String password) throws UserExceptions {
        return (UsuarioAdministrador) logInGenerico(nickName, password, (ArrayList) administradores);
    }

    public UsuarioJugador logInJugador(String nickName, String password) throws UserExceptions {
        return (UsuarioJugador) logInGenerico(nickName, password, (ArrayList) jugadores);
    }

}
