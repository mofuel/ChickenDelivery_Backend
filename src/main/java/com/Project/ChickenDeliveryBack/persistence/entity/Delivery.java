package com.Project.ChickenDeliveryBack.persistence.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "delivery")
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_delivery")
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_venta", nullable = false, unique = true)
    private Sale venta;

    @Column(name = "estado_delivery", nullable = false, length = 30)
    private String estadoDelivery;

    @Column(name = "costo_delivery", nullable = false, precision = 10, scale = 2)
    private BigDecimal costoDelivery;

    @Column(name = "fecha_salida")
    private LocalDateTime fechaSalida;

    @Column(name = "fecha_entrega")
    private LocalDateTime fechaEntrega;

    public Delivery() {}

    //Getters and Setters

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public Sale getVenta() { return venta; }

    public void setVenta(Sale venta) { this.venta = venta; }

    public String getEstadoDelivery() { return estadoDelivery; }

    public void setEstadoDelivery(String estadoDelivery) { this.estadoDelivery = estadoDelivery; }

    public BigDecimal getCostoDelivery() { return costoDelivery; }

    public void setCostoDelivery(BigDecimal costoDelivery) { this.costoDelivery = costoDelivery; }

    public LocalDateTime getFechaSalida() { return fechaSalida; }

    public void setFechaSalida(LocalDateTime fechaSalida) { this.fechaSalida = fechaSalida; }

    public LocalDateTime getFechaEntrega() { return fechaEntrega; }

    public void setFechaEntrega(LocalDateTime fechaEntrega) { this.fechaEntrega = fechaEntrega; }
}
