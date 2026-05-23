package org.serratec.SerratecFlix.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CategoriaDTORequest {
	
	@NotBlank(message = "O nome da categoria é obrigatório")
	@Size(max = 40, message = "O nome da categoria deve ter no máximo 40 caracteres")
	@Schema(description = "O nome da categoria", example = "Ação")
	private String nome;
	

	@NotBlank(message = "A descrição da categoria é obrigatória")
	@Size(max = 200, message = "A descrição da categoria deve ter no máximo 200 caracteres")
	@Schema(description = "A descrição da categoria", example = "Filmes de ação com muita aventura e emoção")
	private String descricao;
	

	
	public CategoriaDTORequest() {
		super();
	}
	
	
	public CategoriaDTORequest(String nome, String descricao) {
		super();
		this.nome = nome;
		this.descricao = descricao;
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
