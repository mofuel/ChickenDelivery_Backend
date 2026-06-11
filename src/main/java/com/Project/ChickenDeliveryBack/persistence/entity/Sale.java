package com.Project.ChickenDeliveryBack.persistence.entity;

import jakarta.persistence.*;
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

    @Column(nullable = false, precision = 10, scale = 2)
    private Double total;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", nullable = false)
    private User usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente")
    private Customer cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_promocion")
    private Promotion promocion;

    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SaleDetail> detalles;

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

    public Double getTotal() { return total; }

    public void setTotal(Double total) { this.total = total; }

    public User getUsuario() { return usuario; }

    public void setUsuario(User usuario) { this.usuario = usuario; }

    public Customer getCliente() { return cliente; }

    public void setCliente(Customer cliente) { this.cliente = cliente; }

    public Promotion getPromocion() { return promocion; }

    public void setPromocion(Promotion promocion) { this.promocion = promocion; }

    public List<SaleDetail> getDetalles() { return detalles; }

    public void setDetalles(List<SaleDetail> detalles) { this.detalles = detalles; }

}
