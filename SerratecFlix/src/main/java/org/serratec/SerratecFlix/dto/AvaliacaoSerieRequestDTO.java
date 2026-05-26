package org.serratec.SerratecFlix.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Schema(description = "Modelo de dados para cadastro de uma nova avaliacao de serie")
public class AvaliacaoSerieRequestDTO {

    @NotNull(message = "O ID da série é obrigatório")
    @Schema(description = "O ID da série", example = "1", required = true)
    private Long idSerie;

    @NotNull(message = "A nota da série é obrigatória. Valores aceitos entre 0.0 e 10.0")
    @Min(value = 0, message = "A nota da série deve ser maior ou igual a 0.0")
    @Max(value = 10, message = "A nota da série deve ser menor ou igual a 10.0")
    @Schema(description = "A nota da série", example = "8.5", required = true)
    private Double notaSerie;

    @Schema(description = "O comentário da série", example = "Muito bom!", required = true)
    private String comentarioSerie;

    public AvaliacaoSerieRequestDTO() {

    }

    public AvaliacaoSerieRequestDTO(Long idSerie, Double notaSerie, String comentarioSerie) {
        this.idSerie = idSerie;
        this.notaSerie = notaSerie;
        this.comentarioSerie = comentarioSerie;
    }

    public Double getNotaSerie() {
        return notaSerie;
    }

    public void setNotaSerie(Double notaSerie) {
        this.notaSerie = notaSerie;
    }

    public String getComentarioSerie() {
        return comentarioSerie;
    }

    public void setComentarioSerie(String comentarioSerie) {
        this.comentarioSerie = comentarioSerie;
    }

    public Long getIdSerie() {
        return idSerie;
    }

    public void setIdSerie(Long idSerie) {
        this.idSerie = idSerie;
    }
}
