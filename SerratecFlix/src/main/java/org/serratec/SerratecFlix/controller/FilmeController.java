package org.serratec.SerratecFlix.controller;

import java.util.List;

import org.serratec.SerratecFlix.dto.FilmeDTORequest;
import org.serratec.SerratecFlix.dto.FilmeDTOResponse;
import org.serratec.SerratecFlix.service.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    @Autowired
    private FilmeService filmeService;

    @Operation(summary = "Listar todos os filmes", description = "Retorna uma lista de todos os filmes cadastrados")
    @GetMapping
    public List<FilmeDTOResponse> listar() {
        return filmeService.findAll();
    }

    @Operation(summary = "Buscar filme por ID", description = "Retorna os detalhes de um filme com base no ID fornecido")
    @GetMapping("/{id}")
    public FilmeDTOResponse buscar(@PathVariable Long id) {
        return filmeService.buscar(id);
    }

    @Operation(summary = "Inserir um novo filme", description = "Adiciona um novo filme ao sistema com os dados fornecidos")
    @PostMapping
    public FilmeDTOResponse inserir(@RequestBody @Valid FilmeDTORequest filmeDTORequest) {
        return filmeService.inserir(filmeDTORequest);
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