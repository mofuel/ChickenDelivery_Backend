package com.Project.ChickenDeliveryBack.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "cliente")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Integer id;

    @Column(unique = true, length = 8)
    private String dni;

    @Column(nullable = false, length = 80)
    private String nombre;

    @Column(length = 15)
    private String telefono;

    @Column(length = 120)
    private String direccion;

    @Column(nullable = false)
    private Boolean estado;

    public Customer() {}

    //Getters and Setters

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getDni() { return dni; }

    public void setDni(String dni) { this.dni = dni; }

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getTelefono() { return telefono; }

    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getDireccion() { return direccion; }

    public void setDireccion(String direccion) { this.direccion = direccion; }

    public Boolean getEstado() { return estado; }

    public void setEstado(Boolean estado) { this.estado = estado; }

}
