package br.com.neuro.Microsservico.dto;

import br.com.neuro.Microsservico.entidades.Produto;

public record ProdutoResponseDTO(
        Long id,
        String nome,
        String descricao,
        Double valor
) {
    public ProdutoResponseDTO(Produto produto) {
        this(produto.getId(), produto.getNome(), produto.getDescricao(), produto.getValor());
    }
}
