/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carlosiglesias.EvidenciaFinalBack.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Carlos Iglesias
 */
@Entity
public class Carrito {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Timestamp fechaDeCreacion;
    private Timestamp fechaDeActualizacion;
    
    @OneToMany(mappedBy = "carrito", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("carrito")
    private List<CarritoItem> productos;
    
    @OneToOne(mappedBy = "carrito", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("carrito")
    private Shipping envio;
    
    
    
    private String token;
    
    
    public Carrito(){
        this.fechaDeCreacion = new Timestamp(System.currentTimeMillis());
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

    public List<CarritoItem> getProductos() {
        return productos;
    }
    
    public void addCarritoItem(CarritoItem producto){
        if(productos == null){
            productos = new ArrayList<CarritoItem>();
        }
        boolean found = false;
        for(int i = 0; i<=productos.size()-1; i++){
            CarritoItem currentItem = productos.get(i);
            if(currentItem.getProducto() == producto.getProducto()){
                found = true;
                currentItem.setCantidad(currentItem.getCantidad()+1);
            }
        }
        if(!found){
            productos.add(producto);
        }
    }

    public String getToken() {
        return token;
    }
    
    public String createToken(){
        this.token = UUID.randomUUID().toString();
        return this.token;
    }

    public Shipping getEnvio() {
        return envio;
    }

    public void setEnvio(Shipping envio) {
        this.envio = envio;
    }
 
    
}
