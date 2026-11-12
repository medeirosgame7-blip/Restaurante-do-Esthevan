package br.com.senai.deliveryavaliacao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.senai.deliveryavaliacao.dto.ProdutoRequest;
import br.com.senai.deliveryavaliacao.model.Produto;
import br.com.senai.deliveryavaliacao.model.Restaurante;
import br.com.senai.deliveryavaliacao.repository.ProdutoRepository;
import br.com.senai.deliveryavaliacao.repository.RestauranteRepository;

@Service 
public class ProdutoService {
    
    private final ProdutoRepository produtoRepository;
    private final RestauranteRepository restauranteRepository;

      public ProdutoService(ProdutoRepository produtoRepository, RestauranteRepository restauranteRepository) {
        this.produtoRepository = produtoRepository;
        this.restauranteRepository = restauranteRepository;
    }

     public Optional<Produto> cadastrar (ProdutoRequest dadosProduto) {
        Optional<Restaurante> restauranteEncontrado = restauranteRepository.findById(dadosProduto.getRestaurante());        
           
        
        if(restauranteEncontrado.isEmpty()) {
            return Optional.empty();
        }

        Produto produto = new Produto();

       
        produto.setNome(dadosProduto.getNome());
        produto.setPreco(dadosProduto.getPreco());
        produto.setRestaurante(restauranteEncontrado.get());
            
        return Optional.of(produtoRepository.save(produto));
    }

    
    public List<Produto> Listar() {
        return produtoRepository.findAll();
    }
    public Optional<Produto> buscarPorid(Integer id) {
        return produtoRepository.findById(id);
    } 
    public Optional<Produto> atualizar(
        Integer id, Produto novosDados) {
      
      Optional<Produto> produtoEncontrado = produtoRepository.findById(id);      
      
      if (produtoEncontrado.isEmpty()){
        return Optional.empty();
      }

       Produto produto = produtoEncontrado.get();
       
       produto.setNome(novosDados.getNome());
       produto.setPreco(novosDados.getPreco());
       produto.setRestaurante(novosDados.getRestaurante());
    
      return Optional.of(produtoRepository.save(produto));    
    }

    public boolean excluir(Integer id)  {
      
        if (!produtoRepository.existsById(id)) {
            return false;
        }

        produtoRepository.deleteById(id);
        return true;
    }
}
