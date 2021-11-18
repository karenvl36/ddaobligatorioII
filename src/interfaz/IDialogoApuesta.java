/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

/**
 *
 * @author Karen
 */
public interface IDialogoApuesta {
    
    public void mostrarSaldo(int Saldo);
    public void recibirApuesta();
    public void mostrarError(String error);
    public void cerrarDialogo();
    
}
