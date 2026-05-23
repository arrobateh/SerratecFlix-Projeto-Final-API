package org.serratec.SerratecFlix.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.v3.oas.annotations.media.Schema;

@JsonPropertyOrder({"id", "nome", "descricao"})


public class CategoriaDTOResponse {
	
	@Schema(description = "Identificador único da categoria", example = "1")
	private Long id;
	
	@Schema(description = "Nome da categoria", example = "Ação")
	private String nome;
	
	@Schema(description = "Descrição da categoria", example = "Filmes de ação com muita aventura e emoção")
	private String descricao;
	
	
	public CategoriaDTOResponse() {
		super();
	}
	
	public CategoriaDTOResponse(Long id, String nome, String descricao) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	

}
