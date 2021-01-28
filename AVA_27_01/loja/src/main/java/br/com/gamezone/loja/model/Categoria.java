package br.com.gamezone.loja.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

@Entity
@Table(name = "tb_categoria")
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Size(min = 3, max=255)
	private String categoriaFilme;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCriacao = new java.sql.Date(System.currentTimeMillis());
	
	@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("categoria")
	private List<Filme> filme;
	
	public List<Filme> getFilme() {
		return filme;
	}

	public void setFilme(List<Filme> filme) {
		this.filme = filme;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCategoriaFilme() {
		return categoriaFilme;
	}

	public void setCategoriaFilme(String categoriaFilme) {
		this.categoriaFilme = categoriaFilme;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
}