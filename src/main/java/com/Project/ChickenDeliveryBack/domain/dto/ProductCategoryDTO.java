package com.Project.ChickenDeliveryBack.domain.dto;

public class ProductCategoryDTO {
    private Integer id;
    private String nombre;
    private String descripcion;
    private Boolean estado;

    public ProductCategoryDTO() {}

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public Boolean getEstado() { return estado; }
    public void setEstado(Boolean estado) { this.estado = estado; }
}
