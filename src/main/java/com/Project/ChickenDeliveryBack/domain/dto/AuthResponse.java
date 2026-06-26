package com.Project.ChickenDeliveryBack.domain.dto;

public class AuthResponse {
    private String token;
    private Integer id;
    private String nombre;
    private String usuario;
    private String rol;

    public AuthResponse() {}

    public AuthResponse(String token, Integer id, String nombre, String usuario, String rol) {
        this.token = token;
        this.id = id;
        this.nombre = nombre;
        this.usuario = usuario;
        this.rol = rol;
    }

    public String getToken() { return token; }
    public void setToken(String token) { this.token = token; }
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getUsuario() { return usuario; }
    public void setUsuario(String usuario) { this.usuario = usuario; }
    public String getRol() { return rol; }
    public void setRol(String rol) { this.rol = rol; }
}
