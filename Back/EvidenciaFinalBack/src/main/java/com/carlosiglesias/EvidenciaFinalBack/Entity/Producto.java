/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carlosiglesias.EvidenciaFinalBack.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Carlos Iglesias
 */
@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String titulo;
    private String descripcion;
    private double valor;
    private double cantDisponible;
    private boolean disponible;
    private String foto_url;
    
    public Producto(){}
    
    public Producto(int id, String titulo){
        this.id = id;
        this.titulo = titulo;
    }
    public Producto(int id, String titulo, String descripcion){
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getcantDisponible() {
        return cantDisponible;
    }

    public void setcantDisponible(double cantDisponible) {
        this.cantDisponible = cantDisponible;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String getfoto_url() {
        return foto_url;
    }

    public void setfoto_url(String foto_url) {
        this.foto_url = foto_url;
    }
    
}
