package br.com.neuro.Microsservico.service;

import br.com.neuro.Microsservico.dto.ProdutoRequestDTO;
import br.com.neuro.Microsservico.dto.ProdutoResponseDTO;
import br.com.neuro.Microsservico.entidades.Produto;
import br.com.neuro.Microsservico.repositories.ProdutoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Transactional(readOnly = true)
    public List<ProdutoResponseDTO> findAll() {
        return produtoRepository.findAll().stream().map(ProdutoResponseDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public ProdutoResponseDTO findByid(Long id) {
        return new ProdutoResponseDTO(produtoRepository.findById(id).
                orElseThrow(() -> new EntityNotFoundException("Recurso não encontrado; id: " + id)));
    }

    @Transactional
    public ProdutoResponseDTO insert(ProdutoRequestDTO request) {
        Produto produto = new Produto();

        toEntity(request, produto);
        produto = produtoRepository.save(produto);
        return new ProdutoResponseDTO(produto);
    }

    @Transactional
    public ProdutoResponseDTO update(Long id, ProdutoRequestDTO requestDTO) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entidade não encontrada id: " + id));

        toEntity(requestDTO, produto);
        produto = produtoRepository.save(produto);
        return new ProdutoResponseDTO(produto);
    }

    @Transactional
    public void delete(Long id) {
        if(!produtoRepository.existsById(id)) {
            throw new EntityNotFoundException("Entidade não encontrada id: " + id);
        }

        produtoRepository.deleteById(id);
    }


    private void toEntity(ProdutoRequestDTO dto, Produto produto) {
        produto.setNome(dto.nome());
        produto.setDescricao(dto.descricao());
        produto.setValor(dto.valor());
    }
}
