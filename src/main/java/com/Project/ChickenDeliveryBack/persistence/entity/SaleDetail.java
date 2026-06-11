package com.Project.ChickenDeliveryBack.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "detalle_venta")
public class SaleDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_venta", nullable = false)
    private Sale venta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_producto", nullable = false)
    private Product producto;

    @Column(nullable = false)
    private Integer cantidad;

    @Column(name = "precio_unitario", nullable = false, precision = 10, scale = 2)
    private Double precioUnitario;

    @Column(nullable = false, precision = 10, scale = 2)
    private Double subtotal;

    public SaleDetail() {}

    //Getters and Setters

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public Sale getVenta() { return venta; }

    public void setVenta(Sale venta) { this.venta = venta; }

    public Product getProducto() { return producto; }

    public void setProducto(Product producto) { this.producto = producto; }

    public Integer getCantidad() { return cantidad; }

    public void setCantidad(Integer cantidad) { this.cantidad = cantidad; }

    public Double getPrecioUnitario() { return precioUnitario; }

    public void setPrecioUnitario(Double precioUnitario) { this.precioUnitario = precioUnitario; }

    public Double getSubtotal() { return subtotal; }

    public void setSubtotal(Double subtotal) { this.subtotal = subtotal; }

}
