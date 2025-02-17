package br.com.neuro.Microsservico.controller;

import br.com.neuro.Microsservico.dto.ProdutoRequestDTO;
import br.com.neuro.Microsservico.dto.ProdutoResponseDTO;
import br.com.neuro.Microsservico.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping()
    public ResponseEntity<List<ProdutoResponseDTO>> findAll() {
        return ResponseEntity.ok(produtoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> findByid(@PathVariable Long id) {
        return ResponseEntity.ok(produtoService.findByid(id));
    }

    @PostMapping()
    public ResponseEntity<ProdutoResponseDTO> insert(@RequestBody ProdutoRequestDTO requestDTO) {
        ProdutoResponseDTO dto = produtoService.insert(requestDTO);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(dto.id())
                .toUri();

        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> update(@RequestBody ProdutoRequestDTO dto, @PathVariable Long id) {
        return ResponseEntity.ok(produtoService.update(id,dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        produtoService.delete(id);
        return ResponseEntity.ok().build();
    }

}
