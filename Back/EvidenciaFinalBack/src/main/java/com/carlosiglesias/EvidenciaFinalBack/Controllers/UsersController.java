/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carlosiglesias.EvidenciaFinalBack.Controllers;

import com.carlosiglesias.EvidenciaFinalBack.Entity.Users;
import com.carlosiglesias.EvidenciaFinalBack.Repository.UsersRepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Carlos Iglesias
 */
public class UsersController {
    
    @Autowired
    private UserRepository userRepository;
    
    @PostMapping("/register")
    public @ResponseBody String create(@RequestBody Users user){
        Users newUser = new Users();
            //Para editar user se le envia el id que se va a editar
            //newUser.setId(2);
                        
            newUser.setEmail(user.getEmail());
            newUser.setPassword(user.getPassword());
            newUser.setToken(user.getToken());
            newUser.setRole(user.getRole());
            newUser.setTelefono(user.getTelefono());
            newUser.setDireccion(user.getDireccion());
            newUser.setNombre(user.getNombre());
            newUser.setStatus(user.getStatus());
            
            userRepository.save(newUser);
             
            return "Success";
    }
    
    @PostMapping("/authenticate")
    public Users authenticate(@RequestBody Users body){
        
        Users dbUser = this.userRepository.findByEmail(body.getEmail());
        
        if(dbUser.getPassword().equals(body.getPassword())){
            return dbUser;
        }
        return null;
    }
}
