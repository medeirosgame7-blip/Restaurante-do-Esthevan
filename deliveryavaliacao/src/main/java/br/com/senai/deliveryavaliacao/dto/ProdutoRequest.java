package br.com.senai.deliveryavaliacao.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotNull;

public class ProdutoRequest {
      
    @NotNull (message = "O nome é obrigatório!!!")
    private String nome;

    @NotNull (message = "O preço é obrigatório!!!")
    private BigDecimal preco;

    @NotNull (message = "O restaurante é obrigatório!!!")
    private Integer restauranteId;

    public ProdutoRequest(){
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }
    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Integer getRestaurante() {
        return restauranteId;
    }
    public void setRestaurante(Integer restauranteId) {
        this.restauranteId = restauranteId;
    } 
}
