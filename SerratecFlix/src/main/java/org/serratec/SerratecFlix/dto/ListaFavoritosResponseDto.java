package org.serratec.SerratecFlix.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import org.serratec.SerratecFlix.domain.ListaFavoritos;

import java.time.LocalDate;

public class ListaFavoritosResponseDto {

    @Schema(description = "ID da Lista", example = "1")
    private Long id;

    @Schema(description = "Nome da lista", example = "Filmes e series para assistir com a namorada")
    private String nomeLista;

    @Schema(description = "Lista privada", example = "privada")
    private Boolean privado = false;

    @Schema(description = "Data de criacao da lista", example = "25-05-2026")
    private LocalDate dataCriacao;

    public static ListaFavoritosResponseDto from(ListaFavoritos favoritos) {
        ListaFavoritosResponseDto dto = new ListaFavoritosResponseDto();
        dto.id = favoritos.getId();
        dto.nomeLista = favoritos.getNomeLista();
        dto.privado = favoritos.getPrivado();
        dto.dataCriacao = favoritos.getDataCriacao();
        return dto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeLista() {
        return nomeLista;
    }

    public void setNomeLista(String nomeLista) {
        this.nomeLista = nomeLista;
    }

    public Boolean getPrivado() {
        return privado;
    }

    public void setPrivado(Boolean privado) {
        this.privado = privado;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
}
