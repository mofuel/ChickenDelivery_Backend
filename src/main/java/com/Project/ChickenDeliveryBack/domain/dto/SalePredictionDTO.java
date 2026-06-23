package com.Project.ChickenDeliveryBack.domain.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class SalePredictionDTO {
    private Integer id;
    private LocalDateTime fechaPrediccion;
    private LocalDate fechaObjetivo;
    private Integer deliveryEstimado;
    private Integer recojoEstimado;
    private Integer totalEstimado;
    private Integer idUsuario;
    private String nombreUsuario;

    public SalePredictionDTO() {}

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public LocalDateTime getFechaPrediccion() { return fechaPrediccion; }
    public void setFechaPrediccion(LocalDateTime fechaPrediccion) { this.fechaPrediccion = fechaPrediccion; }
    public LocalDate getFechaObjetivo() { return fechaObjetivo; }
    public void setFechaObjetivo(LocalDate fechaObjetivo) { this.fechaObjetivo = fechaObjetivo; }
    public Integer getDeliveryEstimado() { return deliveryEstimado; }
    public void setDeliveryEstimado(Integer deliveryEstimado) { this.deliveryEstimado = deliveryEstimado; }
    public Integer getRecojoEstimado() { return recojoEstimado; }
    public void setRecojoEstimado(Integer recojoEstimado) { this.recojoEstimado = recojoEstimado; }
    public Integer getTotalEstimado() { return totalEstimado; }
    public void setTotalEstimado(Integer totalEstimado) { this.totalEstimado = totalEstimado; }
    public Integer getIdUsuario() { return idUsuario; }
    public void setIdUsuario(Integer idUsuario) { this.idUsuario = idUsuario; }
    public String getNombreUsuario() { return nombreUsuario; }
    public void setNombreUsuario(String nombreUsuario) { this.nombreUsuario = nombreUsuario; }
}
