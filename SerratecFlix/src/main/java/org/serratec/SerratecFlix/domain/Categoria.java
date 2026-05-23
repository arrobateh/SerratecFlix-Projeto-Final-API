package org.serratec.SerratecFlix.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "categoria")
public class Categoria {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome", nullable = false, length = 40)
	@NotBlank(message = "O nome da categoria é obrigatório")
	@Size(max = 40, message = "O nome da categoria deve ter no máximo 40 caracteres")
	private String nome;
	
	
	@Column(name = "descricao", nullable = false, length = 200)
	@NotBlank(message = "A descrição da categoria é obrigatória")
	@Size(max = 200, message = "A descrição da categoria deve ter no máximo 200 caracteres")
	private String descricao;
	

	@JsonManagedReference
	@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
	@Schema(description = "Lista de filmes associados à categoria")
	private List<Filme> filme;
	
	
	@JsonManagedReference
	@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
	@Schema(description = "Lista de séries associadas à categoria")
	private  List<Serie> serie;

	public Categoria() {
		super();
	}


	public Categoria(Long id,
			 String nome,
		 String descricao) {
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


	public List<Filme> getFilme() {
		return filme;
	}


	public void setFilme(List<Filme> filme) {
		this.filme = filme;
	}


	public List<Serie> getSerie() {
		return serie;
	}


	public void setSerie(List<Serie> serie) {
		this.serie = serie;
	}
	
	
}