package org.serratec.SerratecFlix.dto;

import java.time.LocalDate;
import java.util.Set;

import org.serratec.SerratecFlix.domain.ClassificacaoIndicativa;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public class FilmeDTORequest {
	
	
	@NotBlank(message = "O titulo do filme é obrigatório")
	@Size(max = 40, message = "O titulo do filme deve ter no máximo 40 caracteres")
	@Schema(description = "Titulo do filme", example = "Vingadores: Ultimato")
	private String titulo;
	
	
	@NotBlank(message = "A descrição do filme é obrigatória")
	@Size(max = 200, message = "A descrição do filme deve ter no máximo 200 caracteres")
	@Schema(description = "Descrição do filme", example = "Um filme de ação e aventura")
	private String descricao;
	
	
	
	@NotNull(message = "A duração do filme é obrigatória")
	@Min(value = 1, message = "A duração do filme deve ser maior que zero")
	@Schema(description = "Duração do filme em minutos", example = "120")
	private Integer duracao;
	
	
	@NotNull(message = "A data de lançamento do filme é obrigatória")
	@Schema(description = "Data de lançamento do filme", example = "2020-01-01")
	@Past(message = "A data de lançamento deve estar no passado")
	private LocalDate dataLancamento;
	
	
	@Schema(description = "Nota média do filme")
	private Double notaMedia;
    
	@NotNull(message = "A classificação indicativa do filme é obrigatória")
	@Schema(description = "Classificação indicativa do filme", example = "MAIORES_16")
	private ClassificacaoIndicativa classificacaoIndicativa;

	@NotEmpty(message = "Pelo menos uma categoria é obrigatória")
	@Schema(description = "Id da categoria do filme", example = "1")
	private Set<Long> categoriaIds;
	
	
	public FilmeDTORequest() {
		super();
	}


	public FilmeDTORequest(String titulo, String descricao, Integer duracao, LocalDate dataLancamento, Double notaMedia,
			ClassificacaoIndicativa classificacaoIndicativa, Set<Long> categoriaIds) {
		super();
		this.titulo = titulo;
		this.descricao = descricao;
		this.duracao = duracao;
		this.dataLancamento = dataLancamento;
		this.notaMedia = notaMedia;
		this.classificacaoIndicativa = classificacaoIndicativa;
		this.categoriaIds = categoriaIds;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public Integer getDuracao() {
		return duracao;
	}


	public void setDuracao(Integer duracao) {
		this.duracao = duracao;
	}


	public LocalDate getDataLancamento() {
		return dataLancamento;
	}


	public void setDataLancamento(LocalDate dataLancamento) {
		this.dataLancamento = dataLancamento;
	}


	public Double getNotaMedia() {
		return notaMedia;
	}


	public void setNotaMedia(Double notaMedia) {
		this.notaMedia = notaMedia;
	}


	public ClassificacaoIndicativa getClassificacaoIndicativa() {
		return classificacaoIndicativa;
	}


	public void setClassificacaoIndicativa(ClassificacaoIndicativa classificacaoIndicativa) {
		this.classificacaoIndicativa = classificacaoIndicativa;
	}


	public Set<Long> getCategoriaIds() {
		return categoriaIds;
	}


	public void setCategoriaIds(Set<Long> categoriaIds) {
		this.categoriaIds = categoriaIds;
	}

}


