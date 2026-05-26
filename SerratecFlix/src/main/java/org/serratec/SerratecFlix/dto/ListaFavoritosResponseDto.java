package org.serratec.SerratecFlix.dto;

import org.serratec.SerratecFlix.domain.ListaFavoritos;

import java.time.LocalDate;

public class ListaFavoritosResponseDto {

    private Long id;
    private String nomeLista;
    private Boolean privado = false;
    private LocalDate dataCriacao;

    public static ListaFavoritosResponseDto from(ListaFavoritos favoritos) {
        ListaFavoritosResponseDto dto = new ListaFavoritosResponseDto();
        dto.id = favoritos.getId();
        dto.nomeLista = favoritos.getNomeLista();
        dto.privado = favoritos.getPrivado();
        dto.dataCriacao = favoritos.getDataCriacao();
        return dto;
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
}
