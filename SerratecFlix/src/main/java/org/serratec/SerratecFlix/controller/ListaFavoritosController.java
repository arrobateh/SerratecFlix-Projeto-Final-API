package org.serratec.SerratecFlix.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.serratec.SerratecFlix.dto.ListaFavoritosRequestDto;
import org.serratec.SerratecFlix.dto.ListaFavoritosResponseDto;
import org.serratec.SerratecFlix.service.ListaFavoritosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/listas")
@Tag(name = "Lista de Favoritos", description = "Gerenciamento de Lista de Favoritos")
public class ListaFavoritosController {

    @Autowired
    private ListaFavoritosService listaFavoritosService;

    @GetMapping
    @Operation(summary = "Lista todos as Lista de Favoritos")
    public ResponseEntity<List<ListaFavoritosResponseDto>> findAll() {
        return ResponseEntity.ok(listaFavoritosService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca lista por ID")
    public ResponseEntity<ListaFavoritosResponseDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(listaFavoritosService.findById(id));
    }

    @PostMapping
    @Operation(summary = "Cria uma lista")
    public ResponseEntity<ListaFavoritosResponseDto> save(@Valid @RequestBody ListaFavoritosRequestDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(listaFavoritosService.criar(dto));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza dados da lista")
    public ResponseEntity<ListaFavoritosResponseDto> update(@PathVariable Long id, @Valid @RequestBody ListaFavoritosRequestDto dto) {
        return ResponseEntity.ok(listaFavoritosService.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove uma lista")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        listaFavoritosService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
