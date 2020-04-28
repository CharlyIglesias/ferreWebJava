/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carlosiglesias.EvidenciaFinalBack.Repository;

import com.carlosiglesias.EvidenciaFinalBack.Entity.Pedido;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Carlos Iglesias
 */
public interface PedidoRepository extends CrudRepository<Pedido, Integer>{
    
    Pedido findById(int id);
    
    List<Pedido> findAll();
}
