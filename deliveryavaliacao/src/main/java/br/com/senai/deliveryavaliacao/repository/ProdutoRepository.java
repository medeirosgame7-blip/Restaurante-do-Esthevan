package br.com.senai.deliveryavaliacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senai.deliveryavaliacao.model.Produto;

@Repository 
public interface ProdutoRepository 
        extends JpaRepository<Produto, Integer>{
    
}
