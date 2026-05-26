package org.serratec.SerratecFlix.domain;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "categoria")
public class Categoria {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome", nullable = false, length = 40, unique = true)
	@NotBlank(message = "O nome da categoria é obrigatório")
	@Size(max = 40, message = "O nome da categoria deve ter no máximo 40 caracteres")
	private String nome;
	
	
	@Column(name = "descricao", nullable = false, length = 200)
	@NotBlank(message = "A descrição da categoria é obrigatória")
	@Size(max = 200, message = "A descrição da categoria deve ter no máximo 200 caracteres")
	private String descricao;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "categorias")
	private Set<Filme> filmes = new HashSet<>();
	
	@JsonIgnore
	@ManyToMany(mappedBy = "categorias")
	private Set<Serie> series = new HashSet<>();

	public Categoria() {
		super();
	}

	public Categoria(Long id,
			 String nome,
		 String descricao, Set<Filme> filmes, Set<Serie> series) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.filmes = filmes;
		this.series = series;
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


	public Set<Filme> getFilmes() {
		return filmes;
	}


	public void setFilmes(Set<Filme> filmes) {
		this.filmes = filmes;
	}


	public Set<Serie> getSeries() {
		return series;
	}


	public void setSeries(Set<Serie> series) {
		this.series = series;
	}
}