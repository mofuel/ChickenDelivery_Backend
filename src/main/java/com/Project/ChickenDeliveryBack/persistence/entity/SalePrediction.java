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

    @Column(name = "delivery_estimado", nullable = false)
    private Integer deliveryEstimado;

    @Column(name = "recojo_estimado", nullable = false)
    private Integer recojoEstimado;

    @Column(name = "total_estimado", nullable = false)
    private Integer totalEstimado;

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

    public Integer getDeliveryEstimado() { return deliveryEstimado; }

    public void setDeliveryEstimado(Integer deliveryEstimado) { this.deliveryEstimado = deliveryEstimado; }

    public Integer getRecojoEstimado() { return recojoEstimado; }

    public void setRecojoEstimado(Integer recojoEstimado) { this.recojoEstimado = recojoEstimado; }

    public Integer getTotalEstimado() { return totalEstimado; }

    public void setTotalEstimado(Integer totalEstimado) { this.totalEstimado = totalEstimado; }

    public User getUsuario() { return usuario; }
    
    public void setUsuario(User usuario) { this.usuario = usuario; }


}
