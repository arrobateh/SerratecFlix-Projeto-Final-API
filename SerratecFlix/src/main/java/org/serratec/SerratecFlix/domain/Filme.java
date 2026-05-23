package org.serratec.SerratecFlix.domain;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
	private Long id;
	
	
	@Column(name = "titulo", nullable = false, length = 40)
	@NotBlank(message = "O titulo do filme é obrigatório")
	@Size(max = 100, message = "O titulo do filme deve ter no máximo 40 caracteres")
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
	@NotNull(message = "A nota média do filme é obrigatória")
	private Double notaMedia;

	@JsonBackReference
	@ManyToOne
	@Schema(description = "Categoria do filme")
	@JoinColumn(name = "categoria_id", nullable = false)
	private Categoria categoria;

	
		
	
	public Filme() {
		super();
	}


	public Filme(Long id,
			 String titulo,
			 String descricao,
			 Integer duracao,
			 LocalDate dataLancamento,
			 Double notaMedia, Categoria categoria) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.duracao = duracao;
		this.dataLancamento = dataLancamento;
		this.notaMedia = notaMedia;
		this.categoria = categoria;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
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


	public Categoria getCategoria() {
		return categoria;
	}


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
	
	
	
}