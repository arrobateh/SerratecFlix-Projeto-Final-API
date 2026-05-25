package org.serratec.SerratecFlix.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "serie")
public class Serie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_serie")
    private Long idSerie;

    @NotBlank(message = "O título da série é obrigatório")
    @Size(max = 100, message = "O título da série deve conter até 100 caracteres")
    @Column(name = "titulo_serie")
    private String tituloSerie;

    @NotBlank(message = "A descrição da série é obrigatória")
    @Size(max = 200, message = "A descrição da série deve conter até 100 caracteres")
    @Column(name = "descricao_serie")
    private String descricaoSerie;

    @NotNull(message = "O número de temporadas da série é obrigatório")
    @Positive(message = "O número de temporadas deve ser um valor positivo")
    @Column(name = "temporadas")
    private Integer temporadas;

    @NotNull(message = "O número de episódios da série é obrigatório")
    @Positive(message = "O número de episódios deve ser um valor positivo")
    @Column(name = "episodios")
    private Integer episodios;

    @Past(message = "A data de lançamento deve ser uma data passada")
    @Column(name = "data_lancamento")
    private LocalDate dataLancamento;

    @NotNull(message = "A nota média da série é obrigatória")
    @DecimalMin(value = "5.0", inclusive = true, message = "A nota média deve ser no mínimo 5.0")
    @DecimalMax(value = "10.0", inclusive = true, message = "A nota média deve ser no máximo 10.0")
    @Column(name = "nota_media_serie")
    private Double notaMediaSerie;

    @NotNull(message = "A categoria da serie é obrigatória")
    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    @OneToMany(mappedBy = "serie")
    private List<AvaliacaoSerie> avaliacoes;

    public Serie () {

    }
    public Serie(Long idSerie,
                 String tituloSerie,
                 String descricaoSerie,
                 Integer temporadas,
                 Integer episodios,
                 LocalDate dataLancamento,
                 Double notaMediaSerie,
                 Categoria categoria) {

        this.idSerie = idSerie;
        this.tituloSerie = tituloSerie;
        this.descricaoSerie = descricaoSerie;
        this.temporadas = temporadas;
        this.episodios = episodios;
        this.dataLancamento = dataLancamento;
        this.notaMediaSerie = notaMediaSerie;
        this.categoria = categoria;
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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<AvaliacaoSerie> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(List<AvaliacaoSerie> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }
}
