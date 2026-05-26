package org.serratec.SerratecFlix.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import org.serratec.SerratecFlix.domain.Serie;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Schema(description = "Modelo de dados para resposta da série")
@JsonPropertyOrder({"idSerie", "tituloSerie", "descricaoSerie", "temporadas", "episodios", "dataLancamento", "notaMediaSerie", "nomeCategoria", "avaliacoes"})
public class SerieResponseDTO {

    @Schema(description = "O ID da série", example = "1")
    @JsonProperty("Serie")
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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "0.0")
    private Double notaMediaSerie;
    @Schema(description = "A categoria da série")
    private String nomeCategoria;
    @Schema(description = "As avaliações da série")
    private List<String> avaliacoes;

    public SerieResponseDTO(Serie serie) {
        this.idSerie = serie.getIdSerie();
        this.tituloSerie = serie.getTituloSerie();
        this.descricaoSerie = serie.getDescricaoSerie();
        this.temporadas = serie.getTemporadas();
        this.episodios = serie.getEpisodios();
        this.dataLancamento = serie.getDataLancamento();
        this.nomeCategoria = serie.getCategoria() != null ? serie.getCategoria().getNome() : "Sem categoria vinculada";

        if (serie.getNotaMediaSerie() != null) {
            this.notaMediaSerie = BigDecimal.valueOf(serie.getNotaMediaSerie())
                    .setScale(1, RoundingMode.HALF_UP)
                    .doubleValue();
        } else {
            this.notaMediaSerie = 0.0;
        }

        if(serie.getAvaliacoes() != null) {
            this.avaliacoes = serie.getAvaliacoes().stream()
                    .map(a -> a.getIdAvaliacaoSerie() + " - " + a.getComentario())
                    .collect(Collectors.toList());
        }
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

    public List<String> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(List<String> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }
}