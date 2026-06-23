package com.Project.ChickenDeliveryBack.domain.dto;

import java.time.LocalDate;

public class PromotionDTO {
    private Integer id;
    private String codigo;
    private String nombre;
    private String descripcion;
    private Double precioCombo;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Boolean estado;

    public PromotionDTO() {}

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public Double getPrecioCombo() { return precioCombo; }
    public void setPrecioCombo(Double precioCombo) { this.precioCombo = precioCombo; }
    public LocalDate getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(LocalDate fechaInicio) { this.fechaInicio = fechaInicio; }
    public LocalDate getFechaFin() { return fechaFin; }
    public void setFechaFin(LocalDate fechaFin) { this.fechaFin = fechaFin; }
    public Boolean getEstado() { return estado; }
    public void setEstado(Boolean estado) { this.estado = estado; }
}
