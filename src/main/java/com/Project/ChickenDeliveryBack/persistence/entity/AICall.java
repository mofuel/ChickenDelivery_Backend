package com.Project.ChickenDeliveryBack.persistence.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "llamada_ia")
public class AICall {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_llamada")
    private Integer id;

    @Column(name = "telefono_cliente", length = 20)
    private String telefonoCliente;

    @Column(name = "fecha_llamada", nullable = false)
    private LocalDateTime fechaLlamada;

    @Column(columnDefinition = "TEXT")
    private String resumen;

    @Column(name = "duracion_segundos")
    private Integer duracionSegundos;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_venta")
    private Sale venta;

    public AICall() {}

    //Getters and Setters

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

    public Sale getVenta() { return venta; }

    public void setVenta(Sale venta) { this.venta = venta; }
}
