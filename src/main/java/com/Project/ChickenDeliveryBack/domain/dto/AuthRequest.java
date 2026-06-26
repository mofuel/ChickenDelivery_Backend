package com.Project.ChickenDeliveryBack.domain.dto;

public class AuthRequest {
    private String usuario;
    private String contrasenia;

    public AuthRequest() {}

    public String getUsuario() { return usuario; }
    public void setUsuario(String usuario) { this.usuario = usuario; }
    public String getContrasenia() { return contrasenia; }
    public void setContrasenia(String contrasenia) { this.contrasenia = contrasenia; }
}
