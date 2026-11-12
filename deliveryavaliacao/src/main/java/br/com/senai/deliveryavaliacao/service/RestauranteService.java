package br.com.senai.deliveryavaliacao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.senai.deliveryavaliacao.model.Restaurante;
import br.com.senai.deliveryavaliacao.repository.RestauranteRepository;

@Service 
public class RestauranteService {
    
    private final RestauranteRepository restauranteRepository;

     public RestauranteService(RestauranteRepository restauranteRepository) {
        this.restauranteRepository = restauranteRepository;
    }

      public Restaurante cadastrar (Restaurante restaurante) {
        return restauranteRepository.save(restaurante);
    }

    public List<Restaurante> Listar() {
        return restauranteRepository.findAll();
    }
    public Optional<Restaurante> buscarPorid(Integer id) {
        return restauranteRepository.findById(id);
    }
    public Optional<Restaurante> atualizar(
        Integer id, Restaurante novosDados) {
      
      Optional<Restaurante> restauranteEncontrado = restauranteRepository.findById(id);      
      
      if (restauranteEncontrado.isEmpty()){
        return Optional.empty();
      }

       Restaurante restaurante = restauranteEncontrado.get();
       
       restaurante.setNome(novosDados.getNome());
    
      return Optional.of(restauranteRepository.save(restaurante));    
    }

    public boolean excluir(Integer id)  {
      
        if (!restauranteRepository.existsById(id)) {
            return false;
        }

        restauranteRepository.deleteById(id);
        return true;
    }
}
