/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carlosiglesias.EvidenciaFinalBack;

import com.carlosiglesias.EvidenciaFinalBack.Security.JWTAuthorizationFilter;
import java.util.Collections;
import javax.persistence.EntityManagerFactory;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 *
 * @author Carlos Iglesias
 */
@SpringBootApplication
public class jwtDemoApplication {
    public static void main(String[] args) {
		SpringApplication.run(jwtDemoApplication.class, args);
	}

        @Bean
        public FilterRegistrationBean<CorsFilter> simpleCorsFilter() {
            UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
            CorsConfiguration config = new CorsConfiguration();
            config.setAllowCredentials(true);
            config.setAllowedOrigins(Collections.singletonList("*"));
            config.setAllowedMethods(Collections.singletonList("*"));
            config.setAllowedHeaders(Collections.singletonList("*"));
            source.registerCorsConfiguration("/**", config);
            FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(new CorsFilter(source));
            bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
            return bean;
        }
        
	@EnableWebSecurity
	@Configuration
	class WebSecurityConfig extends WebSecurityConfigurerAdapter {

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.csrf().disable()
				.addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
				.authorizeRequests()
				.antMatchers(HttpMethod.POST, "/login").permitAll()
                                .antMatchers(HttpMethod.GET, "/getProductos").permitAll()
                                .antMatchers(HttpMethod.GET, "/getPedidos").permitAll()
                                .antMatchers(HttpMethod.GET, "/getPedido").permitAll()
				.antMatchers(HttpMethod.POST, "/createProduct").permitAll()
                                .antMatchers(HttpMethod.GET, "/findProductById").permitAll()
                                .antMatchers(HttpMethod.POST, "/deleteProduct").permitAll()
                                .antMatchers(HttpMethod.POST, "/addProductToCart").permitAll()
                                .antMatchers(HttpMethod.GET, "/getCart").permitAll()
                                .antMatchers(HttpMethod.POST, "/deleteFromCart").permitAll()
                                .antMatchers(HttpMethod.POST, "/changeQuantity").permitAll()
                                .antMatchers(HttpMethod.POST, "/addShipping").permitAll()
                                .antMatchers(HttpMethod.POST, "/createPedido").permitAll()
				.anyRequest().authenticated();
		}
	}
}