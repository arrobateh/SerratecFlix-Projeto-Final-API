package org.serratec.SerratecFlix.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

public class AvaliacaoFilmeDTORequest {

    @NotNull(message = "A nota é obrigatória")
    @DecimalMin(value = "0.0", message = "A nota deve ser no mínimo 0")
    @DecimalMax(value = "10.0", message = "A nota deve ser no máximo 10")
    @Schema(description = "Nota da avaliação", example = "8.5")
    private Double nota;

    @Schema(description = "Comentário da avaliação", example = "Filme incrível!")
    private String comentario;

    @NotNull(message = "O id do filme é obrigatório")
    @Schema(description = "Id do filme", example = "1")
    private Long filmeId;
    
    @NotNull(message = "O id do usuário é obrigatório")
    @Schema(description = "Id do usuário", example = "1")
    private Long usuarioId;

    public AvaliacaoFilmeDTORequest() {
        super();
    }

    public AvaliacaoFilmeDTORequest(Double nota, String comentario, Long filmeId, Long usuarioId ) {
        super();
        this.nota = nota;
        this.comentario = comentario;
        this.filmeId = filmeId;
        this.usuarioId = usuarioId;
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

    public Long getFilmeId() {
        return filmeId;
    }

    public void setFilmeId(Long filmeId) {
        this.filmeId = filmeId;
    }

	public Long getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}
    
    
}
