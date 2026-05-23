package org.serratec.SerratecFlix.dto;

import jakarta.validation.constraints.NotBlank;

public class ListaFavoritosRequestDto {

    @NotBlank(message = "id de usuario é obrigatório")
    private Long usuarioId;

    @NotBlank(message = "Nome é obrigatório")
    private String nomeLista;

    private Boolean privado = false;

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
}
