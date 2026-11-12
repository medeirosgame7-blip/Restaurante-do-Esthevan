package br.com.senai.deliveryavaliacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senai.deliveryavaliacao.model.Restaurante;

@Repository 
public interface RestauranteRepository  
        extends JpaRepository<Restaurante, Integer>{
    
}
