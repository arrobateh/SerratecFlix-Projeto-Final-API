package org.serratec.SerratecFlix.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "lista_favoritos")
public class ListaFavoritos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome dever ser preenchido")
    private String nomeLista;

    @Column(name = "privado")
    private Boolean privado = false;

    @Column(name = "data_criacao")
    private LocalDate dataCriacao;

    @ManyToOne
    @JoinColumn(name = "id_usario")
    @JsonBackReference("usario-lista_favoritos")
    private Usuario usuario;

    @ManyToMany
    @JoinTable(name = "lista_series", joinColumns = @JoinColumn(name = "id_lista_favoritos"), inverseJoinColumns = @JoinColumn(name = "id_series"))
    private List<Serie> series;

    public ListaFavoritos() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeLista() {
        return nomeLista;
    }

    public void setNomeLista(String nomeLista) {
        this.nomeLista = nomeLista;
    }

    public Boolean getPrivado() {
        return privado;
    }

    public void setPrivado(Boolean privado) {
        this.privado = privado;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Serie> getSeries() {
        return series;
    }

    public void setSeries(List<Serie> series) {
        this.series = series;
    }
}
