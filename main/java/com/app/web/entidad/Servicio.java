package com.app.web.entidad;


import java.math.BigDecimal;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "servicios") // Cambio el nombre de la tabla a "servicios"

public class Servicio { // Cambio el nombre de la clase a "Servicio"
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;
    
    @Column(name = "descripcion", nullable = false, length = 50)
    private String descripcion;
    
    @Column(name = "precio", nullable = false, length = 50)
    private BigDecimal precio;

    @OneToMany(mappedBy = "servicio")
    private List<OrdenTrabajo> ordentrabajo;
 
    public Servicio() {
        
    }

    public Servicio(Long id, String nombre, String descripcion, BigDecimal precio) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }
    
    public Servicio(String nombre, String descripcion, BigDecimal precio) {
        super();
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    //Agregamos un método para actualizar el precio
    public void actualizarPrecio(BigDecimal nuevoPrecio) {
        this.precio = nuevoPrecio;
    }

    @Override
    public String toString() {
        return "Servicio [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ",precio=" + precio +"]";
    }

}
