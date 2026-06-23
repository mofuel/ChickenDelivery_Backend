package com.Project.ChickenDeliveryBack.domain.dto;

import java.time.LocalDateTime;

public class AICallDTO {
    private Integer id;
    private String telefonoCliente;
    private LocalDateTime fechaLlamada;
    private String resumen;
    private Integer duracionSegundos;
    private Integer idVenta;

    public AICallDTO() {}

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getTelefonoCliente() { return telefonoCliente; }
    public void setTelefonoCliente(String telefonoCliente) { this.telefonoCliente = telefonoCliente; }
    public LocalDateTime getFechaLlamada() { return fechaLlamada; }
    public void setFechaLlamada(LocalDateTime fechaLlamada) { this.fechaLlamada = fechaLlamada; }
    public String getResumen() { return resumen; }
    public void setResumen(String resumen) { this.resumen = resumen; }
    public Integer getDuracionSegundos() { return duracionSegundos; }
    public void setDuracionSegundos(Integer duracionSegundos) { this.duracionSegundos = duracionSegundos; }
    public Integer getIdVenta() { return idVenta; }
    public void setIdVenta(Integer idVenta) { this.idVenta = idVenta; }
}
