package com.Project.ChickenDeliveryBack.persistence.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "factura")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_factura")
    private Integer id;

    @Column(name = "numero_factura", nullable = false, unique = true, length = 20)
    private String numeroFactura;

    @Column(name = "ruc_cliente", nullable = false, length = 11)
    private String rucCliente;

    @Column(name = "razon_social", nullable = false, length = 100)
    private String razonSocial;

    @Column(name = "direccion_fiscal", nullable = false, length = 150)
    private String direccionFiscal;

    @Column(name = "fecha_emision", nullable = false)
    private LocalDateTime fechaEmision;

    @Column(nullable = false, precision = 10, scale = 2)
    private Double total;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_venta", nullable = false, unique = true)
    private Sale venta;

    public Invoice() {}

    //Getters and Setters

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getNumeroFactura() { return numeroFactura; }

    public void setNumeroFactura(String numeroFactura) { this.numeroFactura = numeroFactura; }

    public String getRucCliente() { return rucCliente; }

    public void setRucCliente(String rucCliente) { this.rucCliente = rucCliente; }

    public String getRazonSocial() { return razonSocial; }

    public void setRazonSocial(String razonSocial) { this.razonSocial = razonSocial; }

    public String getDireccionFiscal() { return direccionFiscal; }

    public void setDireccionFiscal(String direccionFiscal) { this.direccionFiscal = direccionFiscal; }

    public LocalDateTime getFechaEmision() { return fechaEmision; }

    public void setFechaEmision(LocalDateTime fechaEmision) { this.fechaEmision = fechaEmision; }

    public Double getTotal() { return total; }

    public void setTotal(Double total) { this.total = total; }

    public Sale getVenta() { return venta; }

    public void setVenta(Sale venta) { this.venta = venta; }

}
