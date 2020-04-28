/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carlosiglesias.EvidenciaFinalBack.Controllers;

import com.carlosiglesias.EvidenciaFinalBack.Entity.Pedido;
import com.carlosiglesias.EvidenciaFinalBack.Repository.PedidoRepository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Carlos Iglesias
 */
@RestController
public class PedidoController {
    
    @Autowired
    private PedidoRepository pedidoRepository;
    
    @GetMapping("/getPedidos")
    public List<Pedido> getPedidos(){
        
        List<Pedido> DbPedido = this.pedidoRepository.findAll();
        return DbPedido;
    }
    
    @PostMapping("/createPedido")
    public @ResponseBody String create(@RequestBody Pedido pedido){
        Pedido newPedido = new Pedido();
            //Para editar user se le envia el id que se va a editar
            //newUser.setId(2);                        

            newPedido.setFecha(pedido.getFecha());
            newPedido.setSubtotal(pedido.getSubtotal());
            newPedido.setIva(pedido.getIva());
            newPedido.setTotal(pedido.getTotal());
            pedidoRepository.save(newPedido);
            
            return "Success";
    }
}
