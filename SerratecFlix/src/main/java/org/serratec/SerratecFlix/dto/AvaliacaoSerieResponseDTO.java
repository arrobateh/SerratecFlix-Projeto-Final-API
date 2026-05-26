package org.serratec.SerratecFlix.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import org.serratec.SerratecFlix.domain.AvaliacaoSerie;

import java.time.LocalDate;

public class AvaliacaoSerieResponseDTO {

    @Schema(description = "O ID da avaliação da série")
    private Long idAvaliacaoSerie;
    @Schema(description = "A nota da série")
    private Double notaSerie;
    @Schema(description = "O comentário da série")
    private String comentarioSerie;
    @Schema(description = "A data de avaliação da série")
    private LocalDate dataAvaliacao;
    @Schema(description = "O nome da Serie")
    private String nomeSerie;

    public AvaliacaoSerieResponseDTO(AvaliacaoSerie avaliacaoSerie) {
        this.idAvaliacaoSerie = avaliacaoSerie.getIdAvaliacaoSerie();
        this.notaSerie = avaliacaoSerie.getNotaAvaliacaoSerie();
        this.comentarioSerie = avaliacaoSerie.getComentario();
        this.dataAvaliacao = avaliacaoSerie.getDataAvaliacaoSerie();
        this.nomeSerie = avaliacaoSerie.getSerie() != null ? avaliacaoSerie.getSerie().getTituloSerie() : null;
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
}
