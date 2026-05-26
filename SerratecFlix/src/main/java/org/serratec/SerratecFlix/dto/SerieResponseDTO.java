package org.serratec.SerratecFlix.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import org.serratec.SerratecFlix.domain.Serie;

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
    private String nomeCategoria;

    public SerieResponseDTO(Serie serie) {
        this.idSerie = serie.getIdSerie();
        this.tituloSerie = serie.getTituloSerie();
        this.descricaoSerie = serie.getDescricaoSerie();
        this.temporadas = serie.getTemporadas();
        this.episodios = serie.getEpisodios();
        this.dataLancamento = serie.getDataLancamento();
        this.notaMediaSerie = serie.getNotaMediaSerie();
//        this.nomeCategoria = serie.getCategoria() != null ? serie.getCategoria().getNome() : "Sem categoria vinculada";
    }

    public Long getIdSerie() {
        return idSerie;
    }

    public void setIdSerie(Long idSerie) {
        this.idSerie = idSerie;
    }

    public String getTituloSerie() {
        return tituloSerie;
    }

    public void setTituloSerie(String tituloSerie) {
        this.tituloSerie = tituloSerie;
    }

    public String getDescricaoSerie() {
        return descricaoSerie;
    }

    public void setDescricaoSerie(String descricaoSerie) {
        this.descricaoSerie = descricaoSerie;
    }

    public Integer getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(Integer temporadas) {
        this.temporadas = temporadas;
    }

    public Integer getEpisodios() {
        return episodios;
    }

    public void setEpisodios(Integer episodios) {
        this.episodios = episodios;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public Double getNotaMediaSerie() {
        return notaMediaSerie;
    }

    public void setNotaMediaSerie(Double notaMediaSerie) {
        this.notaMediaSerie = notaMediaSerie;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }
}