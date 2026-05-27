package org.serratec.SerratecFlix.controller;

import java.util.List;

import org.serratec.SerratecFlix.dto.FilmeDTORequest;
import org.serratec.SerratecFlix.dto.FilmeDTOResponse;
import org.serratec.SerratecFlix.service.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    @Autowired
    private FilmeService filmeService;

    @Operation(summary = "Listar todos os filmes", description = "Retorna uma lista de todos os filmes cadastrados")
    @GetMapping
    public ResponseEntity<List<FilmeDTOResponse>> listar() {
        return ResponseEntity.ok(filmeService.findAll());
    }

    @Operation(summary = "Ranking de filmes", description = "Retorna os filmes ordenados pela nota média do maior para o menor")
    @GetMapping("/ranking")
    public ResponseEntity<List<FilmeDTOResponse>> ranking() {
        return ResponseEntity.ok(filmeService.rankingFilmes());
    }

    @Operation(summary = "Buscar filmes por categoria", description = "Retorna os filmes de uma categoria específica")
    @GetMapping("/categoria/{categoriaId}")
    public ResponseEntity<List<FilmeDTOResponse>> buscarPorCategoria(@PathVariable Long categoriaId) {
        return ResponseEntity.ok(filmeService.buscarPorCategoria(categoriaId));
    }

    @Operation(summary = "Buscar filme por ID", description = "Retorna os detalhes de um filme com base no ID fornecido")
    @GetMapping("/{id}")
    public ResponseEntity<FilmeDTOResponse> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(filmeService.buscar(id));
    }

    @Operation(summary = "Inserir um novo filme", description = "Adiciona um novo filme ao sistema com os dados fornecidos")
    @PostMapping
    public ResponseEntity<FilmeDTOResponse> inserir(@RequestBody @Valid FilmeDTORequest filmeDTORequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(filmeService.inserir(filmeDTORequest));
    }

    @Operation(summary = "Atualizar um filme existente", description = "Atualiza os dados de um filme com base no ID fornecido")
    @PutMapping("/{id}")
    public ResponseEntity<FilmeDTOResponse> atualizar(@PathVariable Long id, @RequestBody @Valid FilmeDTORequest filmeDTO) {
        return ResponseEntity.ok(filmeService.atualizar(id, filmeDTO));
    }

    @Operation(summary = "Deletar um filme", description = "Remove um filme do sistema com base no ID fornecido")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        filmeService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}