package br.com.neuro.Microsservico.controller;

import br.com.neuro.Microsservico.dto.ProdutoResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @GetMapping()
    public ResponseEntity<ProdutoResponseDTO> get() {
        return ResponseEntity.ok(ProdutoResponseDTO.createMock());
    }


}
