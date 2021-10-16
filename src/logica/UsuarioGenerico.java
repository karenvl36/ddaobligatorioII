/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import excepciones.UserExceptions;

/**
 *
 * @author chiqu
 */
public abstract class UsuarioGenerico {

    private String nickName;
    private String nombreCompleto;
    private String contraseña;

    public UsuarioGenerico(String nickName, String nombreCompleto, String contraseña) {
        this.nickName = nickName;
        this.nombreCompleto = nombreCompleto;
        this.contraseña = contraseña;
    }

    public boolean setNombreCompleto(String newName) {
        String bkUp = this.nombreCompleto;
        this.nombreCompleto = newName;
        if (validarNombreCompleto()) {
            return true;
        } else {
            this.nombreCompleto = bkUp;
            return false;
        }
    }

    public boolean setContraseña(String newPassword) {
        String bkUp = this.contraseña;
        this.contraseña = newPassword;
        if (validarContraseña()) {
            return true;
        } else {
            this.contraseña = bkUp;
            return false;
        }
    }
    
        public boolean setNick(String nuevoNick) {
        String bkUp = this.nickName;
        if (validarNick()) {
            return true;
        } else {
            this.nickName = bkUp;
            return false;
        }
    }

    public String getNick() {
        return this.nickName;
    }

    public String getNombreCompleto() {
        return this.nombreCompleto;
    }

    public String getContraseña() {
        return this.contraseña;
    }



    // Validaciones //   Puse un ejemplo viejo de  un práctico anterior, se puede mejorar la validación.
    public boolean validarNick() {
        boolean isOk = false;
        if (this.getNick() != null && !this.getNick().trim().equals("")) {
            int digitos = this.nickName.length();
            if (digitos >= 2) {
                isOk = true;
            }
        }
        return isOk;
    }

    private boolean validarContraseña() {
         boolean isOk = false;
        if (this.getContraseña()!= null && !this.getContraseña().trim().equals("")) {
            int digitos = this.contraseña.length();
            if (digitos >= 2) {
                isOk = true;
            }
        }
        return isOk;
    }

    private boolean validarNombreCompleto() {
         boolean isOk = false;
        if (this.getNombreCompleto() != null && !this.getNombreCompleto().trim().equals("")) {
            int digitos = this.nombreCompleto.length();
            if (digitos >= 5) {
                isOk = true;
            }
        }
        return isOk;
    }
    
    
    
    //Excepciones -- A TRABAJAR ESTO
    
     public void validar() throws UserExceptions {
        if(this.nickName.isBlank()){
            throw new UserExceptions("Falta el nickname del usuario.");
        }
        if(this.nombreCompleto.isBlank()){
            throw new UserExceptions("Falta el nombre completo del usuario.");
        }
        if(this.contraseña.isBlank()){
            throw new UserExceptions("La contraseña del usuario");
        }
    }

}
