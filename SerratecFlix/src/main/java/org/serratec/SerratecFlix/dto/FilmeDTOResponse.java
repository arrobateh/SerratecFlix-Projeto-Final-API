package org.serratec.SerratecFlix.dto;

import java.time.LocalDate;
import java.util.Set;

import org.serratec.SerratecFlix.domain.ClassificacaoIndicativa;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.v3.oas.annotations.media.Schema;

@JsonPropertyOrder({
	"id",
	"titulo",
	"descricao",
	"duracao",
	"dataLancamento",
	"notaMedia",
	"classificacaoIndicativa",
	"categorias"
})



public class FilmeDTOResponse {
	
	@Schema(description = "ID do filme", example = "1")
	 private Long idFilme;
	 
	@Schema(description = "Título do filme", example = "O Poderoso Chefão")
	 private String titulo;
	
	@Schema(description = "Descrição do filme", example = "Um épico sobre a máfia italiana")
	 private String descricao;
	
	@Schema(description = "Duração do filme em minutos", example = "175")
	 private Integer duracao;
	
	@Schema(description = "Data de lançamento do filme", example = "1972-03-24")
	 private LocalDate dataLancamento;
	
	@Schema(description = "Nota média do filme", example = "9.2")
	 private Double notaMedia;
	
	@Schema(description = "Classificação indicativa do filme", example = "+18")
	 private ClassificacaoIndicativa classificacaoIndicativa;
	
	@Schema(description = "Categoria do filme", example = "Romance")
	 private Set<String> categorias;
	
	
	 
	public FilmeDTOResponse() {
		super();
	}
	
	
	
	public FilmeDTOResponse(Long idFilme, String titulo, String descricao, Integer duracao, LocalDate dataLancamento,
	                        Double notaMedia, ClassificacaoIndicativa classificacaoIndicativa, Set<String> categorias) {
		super();
		this.idFilme = idFilme;
		this.titulo = titulo;
		this.descricao = descricao;
		this.duracao = duracao;
		this.dataLancamento = dataLancamento;
		this.notaMedia = notaMedia;
		this.classificacaoIndicativa = classificacaoIndicativa;
		this.categorias = categorias;
	}



	public Long getIdFilme() {
		return idFilme;
	}



	public void setIdFilme(Long idFilme) {
		this.idFilme = idFilme;
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



	public Set<String> getCategorias() {
		return categorias;
	}



	public void setCategorias(Set<String> categorias) {
		this.categorias = categorias;
	}
	
}
