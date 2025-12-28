package com.backend.clasesya.dto;

public abstract class UsuarioCreateDTO {

    private String nombre;
    private String correo;
    private String contrasena;

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getContrasena() {
        return contrasena;
    }

}
