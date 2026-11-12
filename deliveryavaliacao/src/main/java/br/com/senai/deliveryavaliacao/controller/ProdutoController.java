package br.com.senai.deliveryavaliacao.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.deliveryavaliacao.dto.ProdutoRequest;
import br.com.senai.deliveryavaliacao.model.Produto;
import br.com.senai.deliveryavaliacao.service.ProdutoService;
import jakarta.validation.Valid;

@RestController 
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

     public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    public ResponseEntity< Produto> cadastrar(
            @Valid @RequestBody  ProdutoRequest  produtoDto) {
       
                Integer restauranteId =  produtoDto.getRestaurante();

        
        if ( restauranteId == null ) {
            return ResponseEntity.badRequest().build();
        }

        Optional<Produto> produto = produtoService.cadastrar(produtoDto);
        
        if (produto.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(produto.get());
    }

    @GetMapping
    public ResponseEntity<List<Produto>> listar() {

        List<Produto> produto = produtoService.Listar();

        return ResponseEntity.ok(produto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarPorId(
            @PathVariable Integer id) {

        Optional< Produto> produto = produtoService.buscarPorid(id);

        if (produto.isPresent()) {
            return ResponseEntity.ok(produto.get());
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizar(
            @PathVariable Integer id,
            @RequestBody Produto novosDados) {

        Optional<Produto> produtoAtualizado = produtoService.atualizar(id, novosDados);

        if (produtoAtualizado.isPresent()) {
            return ResponseEntity.ok(produtoAtualizado.get());
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(
            @PathVariable Integer id) {

        boolean excluido = produtoService.excluir(id);

        if (excluido) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

}
