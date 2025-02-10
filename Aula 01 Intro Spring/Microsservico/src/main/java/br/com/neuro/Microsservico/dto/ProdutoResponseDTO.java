package br.com.neuro.Microsservico.dto;

public record ProdutoResponseDTO(
        Long id,
        String nome,
        String descricao,
        Double valor
) {

    public static ProdutoResponseDTO createMock() {
        return new ProdutoResponseDTO(1L, "Macaco Infinito",
                "Ele irá reescrever a história", Double.MAX_VALUE);
    }
}
