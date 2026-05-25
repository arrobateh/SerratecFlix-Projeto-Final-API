package org.serratec.SerratecFlix.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.serratec.SerratecFlix.dto.SerieRequestDTO;
import org.serratec.SerratecFlix.dto.SerieResponseDTO;
import org.serratec.SerratecFlix.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Series", description = "Endpoints para gerenciar as séries")
@RestController
@RequestMapping("/serie")
public class SerieController {

    @Autowired
    private SerieService serieService;

    // 1. Listar todas as séries
    @Operation(
            summary = "Listar todas as séries",
            description = "Retorna uma lista de todas as séries"
    )
    @GetMapping
    public ResponseEntity<List<SerieResponseDTO>> listarTodos() {
        List<SerieResponseDTO> series = serieService.listarTodos();
        return ResponseEntity.ok(series);
    }

    // 2. Buscar série por ID
    @Operation(
            summary = "Buscar série por ID",
            description = "Retorna uma série pelo ID"
    )
    @GetMapping("/{id}")
    public ResponseEntity<SerieResponseDTO> buscarPorId(@PathVariable Long id) {
        if(serieService.buscarPorId(id) == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(serieService.buscarPorId(id));
    }

    // 3. Cadastrar série
    @Operation(
            summary = "Cadastrar série",
            description = "Cadastra uma nova série"
    )
    @PostMapping
    public ResponseEntity<SerieResponseDTO> cadastrar (@Valid @RequestBody SerieRequestDTO serieRequest) {
        SerieResponseDTO serieResponse = serieService.cadastrarSerie(serieRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(serieResponse);
    }

    // 4. Atualizar série
    @Operation(
            summary = "Atualizar série",
            description = "Atualiza uma série pelo ID"
    )
    @PutMapping("/{id}")
    public ResponseEntity<SerieResponseDTO> atualizar(@PathVariable Long id, @Valid @RequestBody SerieRequestDTO serieRequest){
        if(serieService.buscarPorId(id) == null) {
            return ResponseEntity.notFound().build();
        }
        serieService.atualizarSerie(id, serieRequest);

        SerieResponseDTO atualizar = serieService.atualizarSerie(id, serieRequest);
        return ResponseEntity.ok(atualizar);
    }

    // 5. Remover série
    @Operation(
            summary = "Remover série",
            description = "Remove uma série pelo ID"
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover (@PathVariable Long id) {
        if(serieService.buscarPorId(id) == null) {
            return ResponseEntity.notFound().build();
        }
        serieService.removerSerie(id);
        return ResponseEntity.noContent().build();
    }
}
