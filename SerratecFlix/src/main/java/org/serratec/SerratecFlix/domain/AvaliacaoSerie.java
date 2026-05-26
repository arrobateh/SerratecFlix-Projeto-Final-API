package org.serratec.SerratecFlix.domain;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "avaliacao_serie")
public class AvaliacaoSerie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_avaliacao_serie")
    private Long idAvaliacaoSerie;

    @Column(name = "nota")
    private Double notaAvaliacaoSerie;

    @Column(name = "comentario")
    private String comentario;

    @Column(name = "data_avaliacao")
    private LocalDate dataAvaliacaoSerie = LocalDate.now();

    @ManyToOne
   @JoinColumn(name = "id_serie")
    private Serie serie;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;


    public AvaliacaoSerie(){}

    public AvaliacaoSerie(Long idSerie, Double nota, String comentario, LocalDate dataAvaliacao) {
        this.idAvaliacaoSerie = idSerie;
        this.notaAvaliacaoSerie = nota;
        this.comentario = comentario;
        this.dataAvaliacaoSerie = dataAvaliacao;
    }

    public Long getIdAvaliacaoSerie() {
        return idAvaliacaoSerie;
    }

    public void setIdAvaliacaoSerie(Long idAvaliacaoSerie) {
        this.idAvaliacaoSerie = idAvaliacaoSerie;
    }

    public Double getNotaAvaliacaoSerie() {
        return notaAvaliacaoSerie;
    }

    public void setNotaAvaliacaoSerie(Double notaAvaliacaoSerie) {
        this.notaAvaliacaoSerie = notaAvaliacaoSerie;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public LocalDate getDataAvaliacaoSerie() {
        return dataAvaliacaoSerie;
    }

    public void setDataAvaliacaoSerie(LocalDate dataAvaliacaoSerie) {
        this.dataAvaliacaoSerie = dataAvaliacaoSerie;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
