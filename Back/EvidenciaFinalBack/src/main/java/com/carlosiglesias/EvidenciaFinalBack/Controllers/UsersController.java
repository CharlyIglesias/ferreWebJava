/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carlosiglesias.EvidenciaFinalBack.Controllers;

import com.carlosiglesias.EvidenciaFinalBack.Entity.Users;
import com.carlosiglesias.EvidenciaFinalBack.Repository.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Carlos Iglesias
 */
@RestController
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
    
    @PostMapping("/login")
    public Users authenticate(@RequestBody Users body){
        
        Users dbUser = this.userRepository.findByEmail(body.getEmail());
        
        if(dbUser.getPassword().equals(body.getPassword())){
             String token = getJWTToken(body.getEmail());   
               dbUser.setStatus("200 Ok");
               dbUser.setToken(token);
               userRepository.save(dbUser);
            return dbUser;
        }
        return null;
    }
    	private String getJWTToken(String username) {
		String secretKey = "mySecretKey";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_USER");
		
		String token = Jwts
				.builder()
				.setId("softtekJWT")
				.setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512,
						secretKey.getBytes()).compact();

		return token;
	}
}
