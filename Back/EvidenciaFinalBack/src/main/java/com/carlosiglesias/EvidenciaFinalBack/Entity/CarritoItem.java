/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carlosiglesias.EvidenciaFinalBack.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Carlos Iglesias
 */
@Entity
public class CarritoItem {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Timestamp fechaDeCreacion;
    private Timestamp fechaDeActualizacion;
    
    @ManyToOne
    private Producto producto;
    
    @ManyToOne
    @JsonIgnoreProperties("productos")
    private Carrito carrito;
    
    private int cantidad;
    
    public CarritoItem(){}
    
    
    public CarritoItem(Producto producto){
        this.producto = producto;
        this.cantidad = 1;
        this.fechaDeCreacion = new Timestamp(System.currentTimeMillis());
        this.fechaDeActualizacion = new Timestamp(System.currentTimeMillis());
    }

    public int getId() {
        return id;
    }

    public Timestamp getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public Timestamp getFechaDeActualizacion() {
        return fechaDeActualizacion;
    }

    public void setFechaDeActualizacion(Timestamp fechaDeActualizacion) {
        this.fechaDeActualizacion = fechaDeActualizacion;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Carrito getCarrito() {
        return carrito;
    }

    public void setCarrito(Carrito carrito) {
        this.carrito = carrito;
    }
    
    
 
}
