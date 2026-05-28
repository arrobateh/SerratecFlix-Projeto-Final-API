package org.serratec.SerratecFlix.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.serratec.SerratecFlix.dto.HistoricoRequestDTO;
import org.serratec.SerratecFlix.dto.HistoricoResponseDTO;
import org.serratec.SerratecFlix.service.HistoricoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/historico")
@Tag(name = "Historico", description = "Gerenciamento do historico de filmes e series assistidos")
public class HistoricoController {

    @Autowired
    private HistoricoService historicoService;

    @PostMapping
    @Operation(summary = "Adiciona um filme ou serie ao historico")
    public ResponseEntity<HistoricoResponseDTO> adicionar(@RequestBody HistoricoRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(historicoService.adicionar(dto));
    }

    @GetMapping("/usuario/{usuarioId}")
    @Operation(summary = "Lista o historico de um usuário")
    public ResponseEntity<List<HistoricoResponseDTO>> buscarPorUsuario(@PathVariable Long usuarioId) {
        return ResponseEntity.ok(historicoService.buscarPorUsuario(usuarioId));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "deleta um item do historico")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        historicoService.remover(id);
        return ResponseEntity.noContent().build();
    }
}
