/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carlosiglesias.EvidenciaFinalBack.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Carlos Iglesias
 */
public class Users {
     
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
   
    private String email;
    private String password;
    private String token;
    private String role;
    private String telefono;
    private String direccion;
    private String nombre;
    private String status;
    
    public Users(){
    
    }
    public Users(String email, String password){
        this.email = email;
        this.password = password;
    }
    public Users(int id, String email, String password){
        this.id = id;
        this.email = email;
        this.password = password;
    }
    
     public int getId() {
        return id;
      }
      public void setId(int id) {
        this.id = id;
      }
      
      public String getEmail() {
        return email;
      }
      public void setEmail(String email) {
        this.email = email;
      }
      
      public String getPassword() {
        return password;
      }
      public void setPassword(String password) {
        this.password = password;
      }
      
      public String getToken() {
		return token;
	}

      public void setToken(String token) {
		this.token = token;
	}
      
      public String getStatus() {
		return status;
	}

      public void setStatus(String status) {
		this.status = status;
	}

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
      
      @Override
      public String toString(){
          return "User{"+
                  "id="+id+
                  "email='"+email +"'"+
                  "password='"+password+"'"+
                  "token='"+token+"'"+
                  "role='"+role+"'"+
                  "direccion='"+direccion+"'"+
                  "nombre='"+nombre+"'"+
                  "telefono='"+telefono+"'"+
                  "status='"+status+"'"+
                  "}";
      }
}
