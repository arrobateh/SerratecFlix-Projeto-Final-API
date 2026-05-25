package org.serratec.SerratecFlix.domain;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "avaliacao_serie")
public class AvaliacaoSerie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_avaliacao_serie")
    private Long idSerie;

    @Column(name = "nota")
    private Double notaSerie;

    @Column(name = "comentario")
    private String comentario;

    @Column(name = "data_avaliacao")
    private LocalDate dataAvaliacao = LocalDate.now();

    public AvaliacaoSerie(){}

    public AvaliacaoSerie(Long idSerie, Double nota, String comentario, LocalDate dataAvaliacao) {
        this.idSerie = idSerie;
        this.notaSerie = nota;
        this.comentario = comentario;
        this.dataAvaliacao = dataAvaliacao;
    }

    public Long getIdSerie() {
        return idSerie;
    }

    public void setIdSerie(Long idSerie) {
        this.idSerie = idSerie;
    }

    public Double getNotaSerie() {
        return notaSerie;
    }

    public void setNotaSerie(Double nota) {
        this.notaSerie = nota;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public LocalDate getDataAvaliacao() {
        return dataAvaliacao;
    }

    public void setDataAvaliacao(LocalDate dataAvaliacao) {
        this.dataAvaliacao = dataAvaliacao;
    }
}
