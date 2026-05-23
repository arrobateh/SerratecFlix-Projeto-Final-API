package org.serratec.SerratecFlix.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import org.serratec.SerratecFlix.domain.Serie;

import javax.swing.*;
import java.time.LocalDate;

@Schema(description = "Modelo de dados para resposta da série")
public class SerieResponseDTO {

    @Schema(description = "O ID da série", example = "1")
    private Long idSerie;
    @Schema(description = "O título da série")
    private String tituloSerie;
    @Schema(description = "A descrição da série")
    private String descricaoSerie;
    @Schema(description = "O número de temporadas da série")
    private Integer temporadas;
    @Schema(description = "O número de episódios da série")
    private Integer episodios;
    @Schema(description = "A data de lançamento da série")
    private LocalDate dataLancamento;
    @Schema(description = "A nota média da série")
    private Double notaMediaSerie;
    @Schema(description = "A categoria da série")
    private Categoria categoria;

    public SerieResponseDTO(Serie serie) {
        this.idSerie = serie.getIdSerie();
        this.tituloSerie = serie.getTituloSerie();
        this.descricaoSerie = serie.getDescricaoSerie();
        this.temporadas = serie.getTemporadas();
        this.episodios = serie.getEpisodios();
        this.dataLancamento = serie.getDataLancamento();
        this.notaMediaSerie = serie.getNotaMediaSerie()
        this.categoria = serie.getCategoria();
    }
}
