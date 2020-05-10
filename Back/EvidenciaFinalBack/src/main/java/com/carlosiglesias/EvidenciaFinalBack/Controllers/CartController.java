/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carlosiglesias.EvidenciaFinalBack.Controllers;

import com.carlosiglesias.EvidenciaFinalBack.Entity.Carrito;
import com.carlosiglesias.EvidenciaFinalBack.Entity.CarritoItem;
import com.carlosiglesias.EvidenciaFinalBack.Entity.Producto;
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

/**
 *
 * @author Carlos Iglesias
 */
@RestController
public class CartController {
    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private CartRepository cartRepository;
    
    @Autowired
    private CarritoItemRepository cartItemRepository;
    
    @PostMapping("/addProductToCart")
    public @ResponseBody String create(@RequestParam int productId, @RequestParam String cartToken){
        
        Producto producto = productRepository.findById(productId);
        CarritoItem item = new CarritoItem(producto);
        Carrito cart;
        
        if( cartToken != null && !cartToken.equals("")){
            cart = cartRepository.findByToken(cartToken);
        }else{
            cart = new Carrito();
            cart.createToken();
        }
        cart.setFechaDeActualizacion(new Timestamp(System.currentTimeMillis()));
        
        cart.addCarritoItem(item);
        item.setCarrito(cart);
        
        cartRepository.save(cart);
            
        return cart.getToken();
    }
    
    @GetMapping("/getCart")
    public List<CarritoItem> getCart(@RequestParam String cartToken){
       return cartRepository.findByToken(cartToken).getProductos();
    }
    
    @PostMapping("/deleteFromCart")
    public String deleteFromCart(@RequestParam int productId, @RequestParam String cartToken){
        
        Producto producto = productRepository.findById(productId);
        Carrito cart = cartRepository.findByToken(cartToken);
        for(int i = 0; i<=cart.getProductos().size()-1; i++){
            CarritoItem currentItem = cart.getProductos().get(i);
            if(currentItem.getProducto() == producto){
                cartItemRepository.delete(currentItem);
                cart.getProductos().remove(currentItem);
            }
        }
        cartRepository.save(cart);
        
        cart.setFechaDeActualizacion(new Timestamp(System.currentTimeMillis()));
       
        return cart.getToken();
    }
    
    @PostMapping("/changeQuantity")
    public String changeQuantity(@RequestParam int productId, @RequestParam String cartToken, @RequestParam int quantity){
        
        Carrito cart = cartRepository.findByToken(cartToken);
        Producto producto = productRepository.findById(productId);
        
        for(int i = 0; i<=cart.getProductos().size()-1; i++){
            CarritoItem currentItem = cart.getProductos().get(i);
            if(currentItem.getProducto() == producto){
                currentItem.setCantidad(quantity);
            }
        }
        
        cartRepository.save(cart);
       
        return cart.getToken();
    }
    
}
