package com.Project.ChickenDeliveryBack.persistence.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "venta")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_venta")
    private Integer id;

    @Column(name = "fecha_venta", nullable = false)
    private LocalDateTime fechaVenta;

    @Column(name = "tipo_entrega", nullable = false, length = 20)
    private String tipoEntrega;

    @Column(name = "metodo_pago", nullable = false, length = 30)
    private String metodoPago;

    @Column(name = "canal_venta", nullable = false, length = 20)
    private String canalVenta;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal total;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", nullable = false)
    private User usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente")
    private Customer cliente;

    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SaleDetail> detalles;

    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PromotionDetail> detallePromociones;

    @OneToOne(mappedBy = "venta", cascade = CascadeType.ALL, orphanRemoval = true)
    private Delivery delivery;

    @OneToOne(mappedBy = "venta", cascade = CascadeType.ALL, orphanRemoval = true)
    private Voucher comprobante;

    public Sale() {}

    //Getters and Setters

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public LocalDateTime getFechaVenta() { return fechaVenta; }

    public void setFechaVenta(LocalDateTime fechaVenta) { this.fechaVenta = fechaVenta; }

    public String getTipoEntrega() { return tipoEntrega; }

    public void setTipoEntrega(String tipoEntrega) { this.tipoEntrega = tipoEntrega; }

    public String getMetodoPago() { return metodoPago; }

    public void setMetodoPago(String metodoPago) { this.metodoPago = metodoPago; }

    public String getCanalVenta() { return canalVenta; }

    public void setCanalVenta(String canalVenta) { this.canalVenta = canalVenta; }

    public BigDecimal getTotal() { return total; }

    public void setTotal(BigDecimal total) { this.total = total; }

    public User getUsuario() { return usuario; }

    public void setUsuario(User usuario) { this.usuario = usuario; }

    public Customer getCliente() { return cliente; }

    public void setCliente(Customer cliente) { this.cliente = cliente; }

    public List<SaleDetail> getDetalles() { return detalles; }

    public void setDetalles(List<SaleDetail> detalles) { this.detalles = detalles; }

    public List<PromotionDetail> getDetallePromociones() { return detallePromociones; }

    public void setDetallePromociones(List<PromotionDetail> detallePromociones) { this.detallePromociones = detallePromociones; }

    public Delivery getDelivery() { return delivery; }

    public void setDelivery(Delivery delivery) { this.delivery = delivery; }

    public Voucher getComprobante() { return comprobante; }

    public void setComprobante(Voucher comprobante) { this.comprobante = comprobante; }

}
