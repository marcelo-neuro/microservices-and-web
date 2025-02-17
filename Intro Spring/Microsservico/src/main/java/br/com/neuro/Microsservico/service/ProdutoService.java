package br.com.neuro.Microsservico.service;

import br.com.neuro.Microsservico.dto.ProdutoResponseDTO;
import br.com.neuro.Microsservico.repositories.ProdutoRepository;
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
}
