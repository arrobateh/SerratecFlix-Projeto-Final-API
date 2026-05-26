package org.serratec.SerratecFlix.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.serratec.SerratecFlix.dto.EnderecoRequestDto;
import org.serratec.SerratecFlix.dto.EnderecoResponseDto;
import org.serratec.SerratecFlix.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enderecos")
@Tag(name = "Endereços", description = "Gerenciamento de endereços das pessoas")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping
    @Operation(summary = "Lista todos os endereços")
    public ResponseEntity<List<EnderecoResponseDto>> findAll() {
        return ResponseEntity.ok(enderecoService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca endereço por ID")
    public ResponseEntity<EnderecoResponseDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(enderecoService.findById(id));
    }

    @PostMapping
    @Operation(summary = "Cadastra um novo endereço")
    public ResponseEntity<EnderecoResponseDto> save(@Valid @RequestBody EnderecoRequestDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(enderecoService.salvar(dto));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza um endereço")
    public ResponseEntity<EnderecoResponseDto> update(@PathVariable Long id, @Valid @RequestBody EnderecoRequestDto dto) {
        return ResponseEntity.ok(enderecoService.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove um endereço")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        enderecoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
