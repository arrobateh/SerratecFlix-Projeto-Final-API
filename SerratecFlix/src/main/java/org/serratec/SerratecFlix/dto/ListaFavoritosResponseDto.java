package org.serratec.SerratecFlix.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import org.serratec.SerratecFlix.domain.Filme;
import org.serratec.SerratecFlix.domain.ListaFavoritos;
import org.serratec.SerratecFlix.domain.Serie;

import java.time.LocalDate;
import java.util.List;

@JsonPropertyOrder({"id", "nomeLista", "privado", "dataCriacao", "filmes", "series"})
public class ListaFavoritosResponseDto {

    @Schema(description = "ID da Lista", example = "1")
    private Long id;

    @Schema(description = "Nome da lista", example = "Favoritos")
    private String nomeLista;

    @Schema(description = "Lista privada", example = "privada")
    private Boolean privado = false;

    @Schema(description = "Data de criacao da lista", example = "25-05-2026")
    private LocalDate dataCriacao;

    @Schema(description = "id Series", example = "1 id da serie")
    private List<Serie> series;

    @Schema(description = "id Filmes", example = "1 id do filme")
    private List<Filme> filmes;

    public static ListaFavoritosResponseDto from(ListaFavoritos favoritos) {
        ListaFavoritosResponseDto dto = new ListaFavoritosResponseDto();
        dto.id = favoritos.getId();
        dto.nomeLista = favoritos.getNomeLista();
        dto.privado = favoritos.getPrivado();
        dto.filmes = favoritos.getFilmes();
        dto.series = favoritos.getSeries();
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

    public List<Serie> getSeries() {
        return series;
    }

    public void setSeries(List<Serie> series) {
        this.series = series;
    }

    public List<Filme> getFilmes() {
        return filmes;
    }

    public void setFilmes(List<Filme> filmes) {
        this.filmes = filmes;
    }
}
