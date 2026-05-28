package org.serratec.SerratecFlix.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class ListaFavoritosRequestDto {

    @NotNull(message = "id de usuario é obrigatório")
    private Long usuarioId;

    @NotBlank(message = "Nome é obrigatório")
    private String nomeLista;

    private Boolean privado = false;

    private List<Long> idSerie;

    private List<Long> idFilme;

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
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

    public List<Long> getIdSerie() {
        return idSerie;
    }

    public void setIdSerie(List<Long> idSerie) {
        this.idSerie = idSerie;
    }

    public List<Long> getIdFilme() {
        return idFilme;
    }

    public void setIdFilme(List<Long> idFilme) {
        this.idFilme = idFilme;
    }
}
