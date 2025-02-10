package br.com.neuro.intro.Intro.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/saudacao")
public class HelloController {

    @GetMapping("/hello")
    public ResponseEntity<String> ola() {
        try {
            return ResponseEntity.ok("Olá, Mundo!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/salve")
    public ResponseEntity<String> salve(@RequestParam String nome) {
        try {
            return ResponseEntity.ok("Salve " + nome);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
