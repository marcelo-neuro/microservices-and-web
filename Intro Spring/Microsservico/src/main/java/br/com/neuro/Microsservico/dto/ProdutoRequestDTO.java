package br.com.neuro.Microsservico.dto;

public record ProdutoRequestDTO(
        String nome,
        String descricao,
        Double valor
) {

}
