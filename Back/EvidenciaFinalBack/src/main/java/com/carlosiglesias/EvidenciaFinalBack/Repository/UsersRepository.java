/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carlosiglesias.EvidenciaFinalBack.Repository;

import com.carlosiglesias.EvidenciaFinalBack.Entity.Users;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Carlos Iglesias
 */
public class UsersRepository {
    public interface UserRepository extends CrudRepository<Users, Integer> {
    
    Users findByEmail(String email);
    
    List<Users> findAll();
}
}
