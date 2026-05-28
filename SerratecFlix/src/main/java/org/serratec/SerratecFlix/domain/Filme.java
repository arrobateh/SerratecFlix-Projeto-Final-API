package org.serratec.SerratecFlix.domain;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "filme")
public class Filme {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFilme;
	
	
	@Column(name = "titulo", nullable = false, length = 40, unique = true)
	@NotBlank(message = "O titulo do filme é obrigatório")
	@Size(max = 40, message = "O titulo do filme deve ter no máximo 40 caracteres")
	private String titulo;
	
	
	@Column(name = "descricao", nullable = false, length = 200)
	@NotBlank(message = "A descrição do filme é obrigatória")
	@Size(max = 200, message = "A descrição do filme deve ter no máximo 200 caracteres")
	private String descricao;
	
	
	
	@Column(name = "duracao", nullable = false)
	@NotNull(message = "A duração do filme é obrigatória")
	@Min(value = 1, message = "A duração do filme deve ser maior que zero")
	private Integer duracao;
	
	
	@Column(name = "data_lancamento", nullable = false)
	@NotNull(message = "A data de lançamento do filme é obrigatória")
	private LocalDate dataLancamento;
	
	@Column(name = "nota_media")
	private Double notaMedia;
	
	@Enumerated(EnumType.STRING) 
	@Column(name = "classificacao_indicativa", nullable = false)
	private ClassificacaoIndicativa classificacaoIndicativa;

	
	@ManyToMany
	@JoinTable( name = "filme_categoria", joinColumns = @JoinColumn(name = "filme_id"),
		inverseJoinColumns = @JoinColumn(name = "categoria_id"))
	private Set<Categoria> categorias = new HashSet<>();

	@ManyToMany
	@JoinTable(
	    name = "lista_favoritos_filme",
	    joinColumns = @JoinColumn(name = "id_filme"),
	    inverseJoinColumns = @JoinColumn(name = "id_lista_favoritos")
	)
	@JsonIgnore
	private Set<ListaFavoritos> listaFavoritos = new HashSet<>();
	
	public Filme() {
		super();
	}


	public Filme(Long idFilme,
			 String titulo,
			 String descricao,
			 Integer duracao,
			 LocalDate dataLancamento,
			 Double notaMedia, ClassificacaoIndicativa classificacaoIndicativa , Set<Categoria> categorias,
			 Set<ListaFavoritos> listaFavoritos) {
		super();
		this.idFilme = idFilme;
		this.titulo = titulo;
		this.descricao = descricao;
		this.duracao = duracao;
		this.dataLancamento = dataLancamento;
		this.notaMedia = notaMedia;
		this.classificacaoIndicativa =  classificacaoIndicativa;
		this.categorias = categorias;
		this.listaFavoritos = listaFavoritos;
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


	public Set<Categoria> getCategorias() {
		return categorias;
	}


	public void setCategorias(Set<Categoria> categorias) {
		this.categorias = categorias;
	}


	public Set<ListaFavoritos> getListaFavoritos() {
		return listaFavoritos;
	}


	public void setListaFavoritos(Set<ListaFavoritos> listaFavoritos) {
		this.listaFavoritos = listaFavoritos;
	}
}