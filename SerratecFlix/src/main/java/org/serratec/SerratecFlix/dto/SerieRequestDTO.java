package org.serratec.SerratecFlix.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

@Schema(description = "Modelo de dados para cadastro da serie")
public class SerieRequestDTO {

    @NotBlank(message = "O título da série é obrigatório")
    @Size(max = 100, message = "O título da série deve conter até 100 caracteres")
    @Schema(description = "O título da série", example = "Stranger Things", required = true)
    private String tituloSerie;

    @NotBlank(message = "A descrição da série é obrigatória")
    @Size(max = 200, message = "A descrição da série deve conter até 100 caracteres")
    @Schema(description = "A descrição da série", example = "Série de suspense e ficção científica ambientada nos anos 80", required = true)
    private String descricaoSerie;

    @NotNull(message = "O número de temporadas da série é obrigatório")
    @Positive(message = "O número de temporadas deve ser um valor positivo")
    @Schema(description = "O número de temporadas da série", example = "4", required = true)
    private Integer temporadas;

    @NotNull(message = "O número de episódios da série é obrigatório")
    @Positive(message = "O número de episódios deve ser um valor positivo")
    @Schema(description = "O número de episódios da série", example = "34", required = true)
    private Integer episodios;

    @NotBlank(message = "A categoria da serie é obrigatória")
    @Schema(description = "A categoria da série", example = "Suspense", required = true)
    private Categoria categoria;

    @Past(message = "A data de lançamento deve ser uma data passada")
    @Schema(description = "A data de lançamento da série", example = "2016-07-15", required = true)
    private LocalDate dataLancamento;

    public SerieRequestDTO() {

    }

    public SerieRequestDTO(String tituloSerie, String descricaoSerie, Integer temporadas, Integer episodios, LocalDate dataLancamento) {
        this.tituloSerie = tituloSerie;
        this.descricaoSerie = descricaoSerie;
        this.temporadas = temporadas;
        this.episodios = episodios;
        this.dataLancamento = dataLancamento;
        this.categoria = categoria.getNome();

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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}