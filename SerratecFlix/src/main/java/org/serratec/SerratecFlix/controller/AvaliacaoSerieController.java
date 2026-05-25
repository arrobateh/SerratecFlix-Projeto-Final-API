package org.serratec.SerratecFlix.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.serratec.SerratecFlix.dto.AvaliacaoSerieRequestDTO;
import org.serratec.SerratecFlix.dto.AvaliacaoSerieResponseDTO;
import org.serratec.SerratecFlix.service.AvaliacaoSerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Avaliação de Série", description = "Endpoints para gerenciar as avaliações de séries")
@RestController
@RequestMapping("/avaliacao-serie")
public class AvaliacaoSerieController {

    @Autowired
    private AvaliacaoSerieService avaliacaoSerieService;

    // 1. Listar todas as avaliações
    @Operation(
            summary = "Listar todas as avaliações",
            description = "Retorna uma lista de todas as avaliações de séries"
    )
    @GetMapping
    public ResponseEntity<List<AvaliacaoSerieResponseDTO>> listarTodos() {
        List<AvaliacaoSerieResponseDTO> avaliacoes = avaliacaoSerieService.listarTodas();
        return ResponseEntity.ok(avaliacoes);
    }

    // 2. Buscar avaliação por ID
    @Operation(
            summary = "Buscar avaliação por ID",
            description = "Retorna uma avaliação de série pelo ID"
    )
    @GetMapping("/{id}")
    public ResponseEntity<AvaliacaoSerieResponseDTO> buscarPorId(@PathVariable Long id) {
        if(avaliacaoSerieService.buscarPorId(id) == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(avaliacaoSerieService.buscarPorId(id));
    }

    // 3. Cadastrar avaliação
    @Operation(
            summary = "Cadastrar avaliação",
            description = "Cadastra uma nova avaliação de série"
    )
    @PostMapping
    public ResponseEntity<AvaliacaoSerieResponseDTO> cadastrar (@Valid @RequestBody AvaliacaoSerieRequestDTO avaliacaoSerieRequest) {
        AvaliacaoSerieResponseDTO avaliacaoSerieResponse = avaliacaoSerieService.cadastrarAvaliacao(avaliacaoSerieRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(avaliacaoSerieResponse);
    }

    // 4. Remover avaliação
    @Operation(
            summary = "Remover avaliação",
            description = "Remove uma avaliação de série pelo ID"
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover (@PathVariable Long id) {
        if(avaliacaoSerieService.buscarPorId(id) == null) {
            return ResponseEntity.notFound().build();
        }
        avaliacaoSerieService.removerAvaliacao(id);
        return ResponseEntity.noContent().build();
    }
}
