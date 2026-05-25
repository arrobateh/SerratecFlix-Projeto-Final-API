package org.serratec.SerratecFlix.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import org.serratec.SerratecFlix.domain.AvaliacaoSerie;

import java.time.LocalDate;

public class AvaliacaoSerieResponseDTO {

    @Schema(description = "O ID da avaliação da série")
    private Long idSerie;
    @Schema(description = "A nota da série")
    private Double notaSerie;
    @Schema(description = "O comentário da série")
    private String comentarioSerie;
    @Schema(description = "A data de avaliação da série")
    private LocalDate dataAvaliacao;

    public AvaliacaoSerieResponseDTO(AvaliacaoSerie avaliacaoSerie) {
        this.idSerie = avaliacaoSerie.getIdSerie();
        this.notaSerie = avaliacaoSerie.getNotaSerie();
        this.comentarioSerie = avaliacaoSerie.getComentario();
        this.dataAvaliacao = avaliacaoSerie.getDataAvaliacao();
    }
}
