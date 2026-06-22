package com.Project.ChickenDeliveryBack.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "categoria_producto")
public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Integer id;

    @Column(nullable = false, unique = true, length = 50)
    private String nombre;

    @Column(length = 150)
    private String descripcion;

    @Column(nullable = false)
    private Boolean estado;

    public ProductCategory() {}

    //Getters and Setters

    public Integer getId() {return id;}

    public void setId(Integer id) {this.id = id;}

    public String getNombre() {return nombre;}

    public void setNombre(String nombre) {this.nombre = nombre;}

    public String getDescripcion() {return descripcion;}

    public void setDescripcion(String descripcion) {this.descripcion = descripcion;}

    public Boolean getEstado() {return estado;}

    public void setEstado(Boolean estado) {this.estado = estado;}
}
