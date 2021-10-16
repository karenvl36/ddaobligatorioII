/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author chiqu
 */
public class Sesion {
    
    private UsuarioGenerico user;

    public Sesion(UsuarioGenerico user){
        this.user = user;
    }

    public UsuarioGenerico getUser() {
        return user;
    }

    public void setUser(UsuarioGenerico user) {
        this.user = user;
    }
    
    
}
