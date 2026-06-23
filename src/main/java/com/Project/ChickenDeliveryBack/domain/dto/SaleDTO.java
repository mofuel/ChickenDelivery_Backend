package com.Project.ChickenDeliveryBack.domain.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class SaleDTO {
    private Integer id;
    private LocalDateTime fechaVenta;
    private String tipoEntrega;
    private String metodoPago;
    private String canalVenta;
    private BigDecimal total;
    private Integer idUsuario;
    private String nombreUsuario;
    private Integer idCliente;
    private String nombreCliente;
    private List<SaleDetailDTO> detalles;
    private List<PromotionDetailDTO> detallePromociones;
    private DeliveryDTO delivery;
    private VoucherDTO comprobante;

    public SaleDTO() {}

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
    public Integer getIdUsuario() { return idUsuario; }
    public void setIdUsuario(Integer idUsuario) { this.idUsuario = idUsuario; }
    public String getNombreUsuario() { return nombreUsuario; }
    public void setNombreUsuario(String nombreUsuario) { this.nombreUsuario = nombreUsuario; }
    public Integer getIdCliente() { return idCliente; }
    public void setIdCliente(Integer idCliente) { this.idCliente = idCliente; }
    public String getNombreCliente() { return nombreCliente; }
    public void setNombreCliente(String nombreCliente) { this.nombreCliente = nombreCliente; }
    public List<SaleDetailDTO> getDetalles() { return detalles; }
    public void setDetalles(List<SaleDetailDTO> detalles) { this.detalles = detalles; }
    public List<PromotionDetailDTO> getDetallePromociones() { return detallePromociones; }
    public void setDetallePromociones(List<PromotionDetailDTO> detallePromociones) { this.detallePromociones = detallePromociones; }
    public DeliveryDTO getDelivery() { return delivery; }
    public void setDelivery(DeliveryDTO delivery) { this.delivery = delivery; }
    public VoucherDTO getComprobante() { return comprobante; }
    public void setComprobante(VoucherDTO comprobante) { this.comprobante = comprobante; }
}
