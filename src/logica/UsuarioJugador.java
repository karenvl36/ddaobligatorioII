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
public class UsuarioJugador extends UsuarioGenerico{
    
    private int saldo;
    
    public UsuarioJugador(String nickName, String nombreCompleto, String contraseña,int saldo) {
        super(nickName, nombreCompleto, contraseña);
        this.saldo = saldo;
    }
    
    
    public int getSaldo(){
        return this.saldo;
    }
    
    public void setSaldo(int newSaldo){
        this.saldo = newSaldo;
    }
    
    
    public void restarSaldo(int apuesta){
        this.setSaldo(saldo - apuesta);
        
    }

    public void sumarSaldo(int valor) {
       this.setSaldo(saldo + valor);
    }
    
    
}
