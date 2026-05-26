package org.serratec.SerratecFlix.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import org.serratec.SerratecFlix.domain.AvaliacaoSerie;

import java.time.LocalDate;

@JsonPropertyOrder({"idAvaliacaoSerie", "nomeSerie", "nomeUsuario", "comentarioSerie", "notaSerie", "dataAvaliacao"})
public class AvaliacaoSerieResponseDTO {

    @Schema(description = "O ID da avaliação da série")
    @JsonProperty("ID da avaliação")
    private Long idAvaliacaoSerie;
    @Schema(description = "A nota da série")
    @JsonProperty("Nota da série")
    private Double notaSerie;
    @Schema(description = "O comentário da série")
    @JsonProperty("Comentário da série")
    private String comentarioSerie;
    @Schema(description = "A data de avaliação da série")
    @JsonProperty("Data da avaliação")
    private LocalDate dataAvaliacao;
    @Schema(description = "O nome da Serie")
    @JsonProperty("Nome da série")
    private String nomeSerie;
    @Schema(description = "O nome do usuário que fez a avaliação")
    @JsonProperty("Nome do usuário")
    private String nomeUsuario;

    public AvaliacaoSerieResponseDTO(AvaliacaoSerie avaliacaoSerie) {
        this.idAvaliacaoSerie = avaliacaoSerie.getIdAvaliacaoSerie();
        this.notaSerie = avaliacaoSerie.getNotaAvaliacaoSerie();
        this.comentarioSerie = avaliacaoSerie.getComentario();
        this.dataAvaliacao = avaliacaoSerie.getDataAvaliacaoSerie();
        this.nomeSerie = avaliacaoSerie.getSerie() != null ? avaliacaoSerie.getSerie().getTituloSerie() : "Titulo da série não vinculado";
        this.nomeUsuario = avaliacaoSerie.getUsuario() != null ? avaliacaoSerie.getUsuario().getNome() : "Usuario não vinculado";
    }

    public Long getIdAvaliacaoSerie() {
        return idAvaliacaoSerie;
    }

    public void setIdAvaliacaoSerie(Long idAvaliacaoSerie) {
        this.idAvaliacaoSerie = idAvaliacaoSerie;
    }

    public Double getNotaSerie() {
        return notaSerie;
    }

    public void setNotaSerie(Double notaSerie) {
        this.notaSerie = notaSerie;
    }

    public String getComentarioSerie() {
        return comentarioSerie;
    }

    public void setComentarioSerie(String comentarioSerie) {
        this.comentarioSerie = comentarioSerie;
    }

    public LocalDate getDataAvaliacao() {
        return dataAvaliacao;
    }

    public void setDataAvaliacao(LocalDate dataAvaliacao) {
        this.dataAvaliacao = dataAvaliacao;
    }

    public String getNomeSerie() {
        return nomeSerie;
    }

    public void setNomeSerie(String nomeSerie) {
        this.nomeSerie = nomeSerie;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }
}