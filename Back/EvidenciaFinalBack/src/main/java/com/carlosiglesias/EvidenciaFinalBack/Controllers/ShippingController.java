/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carlosiglesias.EvidenciaFinalBack.Controllers;

import com.carlosiglesias.EvidenciaFinalBack.Entity.Carrito;
import com.carlosiglesias.EvidenciaFinalBack.Entity.CarritoItem;
import com.carlosiglesias.EvidenciaFinalBack.Entity.Producto;
import com.carlosiglesias.EvidenciaFinalBack.Entity.Shipping;
import com.carlosiglesias.EvidenciaFinalBack.Repository.CartRepository;
import com.carlosiglesias.EvidenciaFinalBack.Repository.ProductRepository;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.carlosiglesias.EvidenciaFinalBack.Repository.CarritoItemRepository;
import com.carlosiglesias.EvidenciaFinalBack.Repository.ShippingRepository;

/**
 *
 * @author Carlos Iglesias
 */
@RestController
public class ShippingController {
    @Autowired
    private ShippingRepository shippingRepository;
    
    @Autowired
    private CartRepository cartRepository;
    
    @PostMapping("/addShipping")
    public @ResponseBody String create(@RequestBody Shipping shipping){
        Shipping shipment = new Shipping();
        shipment.setAddress(shipping.getAddress());
        shipment.setCity(shipping.getCity());
        shipment.setCountry(shipping.getCountry());
        shipment.setEmailAddress(shipping.getEmailAddress());
        shipment.setFirstName(shipping.getFirstName());
        shipment.setLastName(shipping.getLastName());
        shipment.setPhone(shipping.getPhone());
        shipment.setPrice(shipping.getPrice());
        shipment.setZip(shipping.getZip());
        
        Carrito cart = cartRepository.findByToken(shipping.getToken());
        shipment.setCarrito(cart);
        
        shippingRepository.save(shipment);
        
        return "ok";
    }
    
}
