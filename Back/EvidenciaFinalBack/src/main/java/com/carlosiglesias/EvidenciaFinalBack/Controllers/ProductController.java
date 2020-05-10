/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carlosiglesias.EvidenciaFinalBack.Controllers;

import com.carlosiglesias.EvidenciaFinalBack.Entity.Producto;
import com.carlosiglesias.EvidenciaFinalBack.Repository.ProductRepository;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Carlos Iglesias
 */
@RestController
public class ProductController {
    @Autowired
    private ProductRepository productRepository;
    
    @GetMapping("/findProductById")
    public Producto findById(@RequestParam(value="id") int id){
       return this.productRepository.findById(id);
    }
    
    @GetMapping("/getProductos")
    public List<Producto> getProducts(@RequestParam(value="searchString") String searchString){
        
        List<Producto> DbProduct;
        List<Producto> DbProduct2;
        
        if(searchString != null && !searchString.equals("")){
            DbProduct = this.productRepository.findByTituloContains(searchString);
            DbProduct2 = this.productRepository.findByDescripcionContains(searchString);
            Set<Producto> set = new LinkedHashSet<>(DbProduct);
            set.addAll(DbProduct2);
            DbProduct = new ArrayList<>(set);
        }else{
            DbProduct = this.productRepository.findAll();
        }
        
        return DbProduct;
    }
    
    @PostMapping("/createProduct")
    public @ResponseBody String create(@RequestBody Producto product){
        Producto newProd = new Producto();
            //Para editar user se le envia el id que se va a editar
            
            newProd.setId(product.getId());                        
            newProd.setTitulo(product.getTitulo());
            newProd.setDescripcion(product.getDescripcion());
            newProd.setValor(product.getValor());
            newProd.setcantDisponible(product.getcantDisponible());
            newProd.setDisponible(product.isDisponible());
            newProd.setfoto_url(product.getfoto_url());
            productRepository.save(newProd);
            
            return "Success";
    }
    
    @PostMapping("/deleteProduct")
    public String delete(@RequestParam(value="id") int id){
       Producto product =  this.productRepository.findById(id);
       productRepository.delete(product);
       return "Deleted succesfully";
    }
    
}
