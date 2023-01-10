package com.vendas.models;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table( name = "PRODUTOS" )
public class Produto {
	
	@Id @GeneratedValue( strategy = GenerationType.AUTO )
	@Column( name = "ID_PRODUTO")
    private Integer idProduto;
	
	@Column( name = "PRECO_UNITARIO")
    private BigDecimal precoUnitario;
	
	@Column( name = "DESCRICAO")
    private String descricao;
	
    public Produto(Integer idProduto, BigDecimal precoUnitario, String descricao) {
		this.idProduto = idProduto;
		this.precoUnitario = precoUnitario;
		this.descricao = descricao;
	}
    
	public Produto(BigDecimal precoUnitario, String descricao) {
		this.precoUnitario = precoUnitario;
		this.descricao = descricao;
	}
	
	public Produto() {
	}

	public Integer getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}

	public BigDecimal getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(BigDecimal precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Produto [idProduto=" + idProduto + ", precoUnitario=" + precoUnitario + ", descricao=" + descricao
				+ "]";
	}
    
    
    
    
}
