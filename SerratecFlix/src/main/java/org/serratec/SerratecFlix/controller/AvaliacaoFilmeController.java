package org.serratec.SerratecFlix.controller;

import java.util.List;

import org.serratec.SerratecFlix.dto.AvaliacaoFilmeDTORequest;
import org.serratec.SerratecFlix.dto.AvaliacaoFilmeDTOResponse;
import org.serratec.SerratecFlix.service.AvaliacaoFilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/avaliacoes-filmes")
public class AvaliacaoFilmeController {

    @Autowired
    private AvaliacaoFilmeService avaliacaoFilmeService;

    @Operation(summary = "Listar todas as avaliações de filmes")
    @GetMapping
    public ResponseEntity<List<AvaliacaoFilmeDTOResponse>> listar() {
        return ResponseEntity.ok(avaliacaoFilmeService.findAll());
    }

    @Operation(summary = "Listar avaliações por filme")
    @GetMapping("/filme/{filmeId}")
    public ResponseEntity<List<AvaliacaoFilmeDTOResponse>> listarPorFilme(@PathVariable Long filmeId) {
        return ResponseEntity.ok(avaliacaoFilmeService.findByFilmeIdFilme(filmeId));
    }

    @Operation(summary = "Inserir nova avaliação de filme")
    @PostMapping
    public ResponseEntity<AvaliacaoFilmeDTOResponse> inserir(@RequestBody @Valid AvaliacaoFilmeDTORequest dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(avaliacaoFilmeService.inserir(dto));
    }

    
    @Operation(summary = "Atualizar avaliação de filme")
    @PutMapping("/{id}")
    public ResponseEntity<AvaliacaoFilmeDTOResponse> atualizar(@PathVariable Long id, @RequestBody @Valid AvaliacaoFilmeDTORequest dto) {
        return ResponseEntity.ok(avaliacaoFilmeService.atualizar(id, dto));
    }
    
    
    @Operation(summary = "Deletar avaliação de filme")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        avaliacaoFilmeService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}