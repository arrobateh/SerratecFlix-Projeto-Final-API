package org.serratec.SerratecFlix.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;

@JsonPropertyOrder({"id", "filmeId", "filmeTitulo", "nomeUsuario", "nota", "comentario", "dataAvaliacao"})

public class AvaliacaoFilmeDTOResponse {

    @Schema(description = "ID da avaliação", example = "1")
    private Long id;

    @Schema(description = "ID do filme avaliado", example = "1")
    private Long filmeId;
    
    @Schema(description = "Título do filme avaliado", example = "Vingadores: Ultimato")
    private String filmeTitulo;
    
    @Schema(description = "Nome do usuário que avaliou", example = "João Silva")
    private String nomeUsuario;

    @Schema(description = "Nota da avaliação", example = "8.5")
    private Double nota;

    @Schema(description = "Comentário da avaliação", example = "Filme incrível!")
    private String comentario;

    @Schema(description = "Data da avaliação", example = "2024-01-01")
    private LocalDate dataAvaliacao;

    public AvaliacaoFilmeDTOResponse() {
        super();
    }

    public AvaliacaoFilmeDTOResponse(Long id, Long filmeId,  String filmeTitulo, String nomeUsuario, Double nota, String comentario, LocalDate dataAvaliacao) {
        super();
        this.id = id;
        this.filmeId = filmeId;
        this.filmeTitulo = filmeTitulo;
        this.nota = nota;
        this.nomeUsuario = nomeUsuario;
        this.comentario = comentario;
        this.dataAvaliacao = dataAvaliacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
   
    public Long getFilmeId() {
		return filmeId;
	}

	public void setFilmeId(Long filmeId) {
		this.filmeId = filmeId;
	}

	public String getFilmeTitulo() {
        return filmeTitulo;
    }

    public void setFilmeTitulo(String filmeTitulo) {
        this.filmeTitulo = filmeTitulo;
    }

    public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
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