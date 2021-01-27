package br.com.farmaecia.farmacia.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

@Entity
@Table(name = "Produto")
public class Produto {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private  long idProduto;
	
	@NotNull
	@Size(min = 3 , max = 50)
	private String nomeProduto;
	
	@NotNull
	@Size(min = 3 , max = 50)
	private String fabricante;
	
	@NotNull
	private double preco;
	
	@NotNull
	private int referencia;

	public long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(long idProduto) {
		this.idProduto = idProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getReferencia() {
		return referencia;
	}

	public void setReferencia(int referencia) {
		this.referencia = referencia;
	}
	
	
	
	

}
