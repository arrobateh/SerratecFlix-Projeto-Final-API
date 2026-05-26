package org.serratec.SerratecFlix.controller;
import java.util.List;

import org.serratec.SerratecFlix.dto.CategoriaDTORequest;
import org.serratec.SerratecFlix.dto.CategoriaDTOResponse;
import org.serratec.SerratecFlix.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;
    
    @Operation(summary = "Listar todas as categorias")
    @GetMapping
    public ResponseEntity<List<CategoriaDTOResponse>> listar() {
        return ResponseEntity.ok(categoriaService.findAll());
    }

    @Operation(summary = "Buscar categoria por ID")
    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDTOResponse> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(categoriaService.buscar(id));
    }

    @Operation(summary = "Inserir nova categoria")
    @PostMapping
    public ResponseEntity<CategoriaDTOResponse> inserir(@RequestBody @Valid CategoriaDTORequest dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaService.inserir(dto));
    }

    @Operation(summary = "Atualizar categoria")
    @PutMapping("/{id}")
    public ResponseEntity<CategoriaDTOResponse> atualizar(@PathVariable Long id, @RequestBody @Valid CategoriaDTORequest dto) {
        return ResponseEntity.ok(categoriaService.atualizar(id, dto));
    }

    @Operation(summary = "Deletar categoria")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        categoriaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}