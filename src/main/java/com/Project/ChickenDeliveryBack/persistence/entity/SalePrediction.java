package com.Project.ChickenDeliveryBack.persistence.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "prediccion_venta")
public class SalePrediction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_prediccion")
    private Integer id;

    @Column(name = "fecha_prediccion", nullable = false)
    private LocalDateTime fechaPrediccion;

    @Column(name = "fecha_objetivo", nullable = false)
    private LocalDate fechaObjetivo;

    @Column(name = "monto_estimado", nullable = false, precision = 10, scale = 2)
    private Double montoEstimado;

    @Column(name = "cantidad_productos_estimada", nullable = false)
    private Integer cantidadProductosEstimada;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", nullable = false)
    private User usuario;

    public SalePrediction() {}

    //Getters and Setters

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public LocalDateTime getFechaPrediccion() { return fechaPrediccion; }

    public void setFechaPrediccion(LocalDateTime fechaPrediccion) { this.fechaPrediccion = fechaPrediccion; }

    public LocalDate getFechaObjetivo() { return fechaObjetivo; }

    public void setFechaObjetivo(LocalDate fechaObjetivo) { this.fechaObjetivo = fechaObjetivo; }

    public Double getMontoEstimado() { return montoEstimado; }

    public void setMontoEstimado(Double montoEstimado) { this.montoEstimado = montoEstimado; }

    public Integer getCantidadProductosEstimada() { return cantidadProductosEstimada; }

    public void setCantidadProductosEstimada(Integer cantidadProductosEstimada) { this.cantidadProductosEstimada = cantidadProductosEstimada; }

    public User getUsuario() { return usuario; }

    public void setUsuario(User usuario) { this.usuario = usuario; }
    
}
