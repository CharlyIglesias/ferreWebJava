/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carlosiglesias.EvidenciaFinalBack.Repository;

import com.carlosiglesias.EvidenciaFinalBack.Entity.Producto;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Carlos Iglesias
 */
public interface ProductRepository extends CrudRepository<Producto, Integer>{
    
    Producto findById(int id);
    
    List<Producto> findAll();
    
}
