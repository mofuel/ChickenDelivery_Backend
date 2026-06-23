package com.Project.ChickenDeliveryBack.domain.dto;

public class PromotionDetailDTO {
    private Integer id;
    private Integer idVenta;
    private Integer idPromocion;
    private String codigoPromocion;
    private String nombrePromocion;
    private Integer cantidad;
    private Double precioUnitario;
    private Double subtotal;

    public PromotionDetailDTO() {}

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public Integer getIdVenta() { return idVenta; }
    public void setIdVenta(Integer idVenta) { this.idVenta = idVenta; }
    public Integer getIdPromocion() { return idPromocion; }
    public void setIdPromocion(Integer idPromocion) { this.idPromocion = idPromocion; }
    public String getCodigoPromocion() { return codigoPromocion; }
    public void setCodigoPromocion(String codigoPromocion) { this.codigoPromocion = codigoPromocion; }
    public String getNombrePromocion() { return nombrePromocion; }
    public void setNombrePromocion(String nombrePromocion) { this.nombrePromocion = nombrePromocion; }
    public Integer getCantidad() { return cantidad; }
    public void setCantidad(Integer cantidad) { this.cantidad = cantidad; }
    public Double getPrecioUnitario() { return precioUnitario; }
    public void setPrecioUnitario(Double precioUnitario) { this.precioUnitario = precioUnitario; }
    public Double getSubtotal() { return subtotal; }
    public void setSubtotal(Double subtotal) { this.subtotal = subtotal; }
}
