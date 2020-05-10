/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carlosiglesias.EvidenciaFinalBack.Repository;

import com.carlosiglesias.EvidenciaFinalBack.Entity.Carrito;
import com.carlosiglesias.EvidenciaFinalBack.Entity.CarritoItem;
import com.carlosiglesias.EvidenciaFinalBack.Entity.Pedido;
import com.carlosiglesias.EvidenciaFinalBack.Entity.Producto;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Carlos Iglesias
 */
public interface CarritoItemRepository extends CrudRepository<CarritoItem, Integer>{
}
