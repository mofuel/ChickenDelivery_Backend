package com.Project.ChickenDeliveryBack.domain.dto;

import java.time.LocalDateTime;

public class DeliveryDTO {
    private Integer id;
    private Integer idVenta;
    private String estadoDelivery;
    private Double costoDelivery;
    private LocalDateTime fechaSalida;
    private LocalDateTime fechaEntrega;

    public DeliveryDTO() {}

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public Integer getIdVenta() { return idVenta; }
    public void setIdVenta(Integer idVenta) { this.idVenta = idVenta; }
    public String getEstadoDelivery() { return estadoDelivery; }
    public void setEstadoDelivery(String estadoDelivery) { this.estadoDelivery = estadoDelivery; }
    public Double getCostoDelivery() { return costoDelivery; }
    public void setCostoDelivery(Double costoDelivery) { this.costoDelivery = costoDelivery; }
    public LocalDateTime getFechaSalida() { return fechaSalida; }
    public void setFechaSalida(LocalDateTime fechaSalida) { this.fechaSalida = fechaSalida; }
    public LocalDateTime getFechaEntrega() { return fechaEntrega; }
    public void setFechaEntrega(LocalDateTime fechaEntrega) { this.fechaEntrega = fechaEntrega; }
}
