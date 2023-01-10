package com.vendas.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table( name = "ITEM_PEDIDOS")
public class ItemPedido {
	
	@Id @GeneratedValue( strategy = GenerationType.AUTO)
	@Column( name = "ID_TEM_PEDIDO")
	private Integer idItemPedido;
	
	@ManyToOne
	@JoinColumn( name = "PEDIDO_ID")
	private Pedido pedido;
	
	@ManyToOne
	@JoinColumn( name = "PRODUTO_ID" )
    private Produto produto;
    
    @Column( name = "QUANTIDADE")
    private Integer quantidade;
	
	public ItemPedido(Integer idItemPedido, Pedido pedido, Produto produto, Integer quantidade) {
		this.idItemPedido = idItemPedido;
		this.pedido = pedido;
		this.produto = produto;
		this.quantidade = quantidade;
	}
	
	public ItemPedido(Pedido pedido, Produto produto, Integer quantidade) {
		this.pedido = pedido;
		this.produto = produto;
		this.quantidade = quantidade;
	}
	
	public ItemPedido() {
	}
	
	public Integer getIdTemPedido() {
		return idItemPedido;
	}
	public void setIdTemPedido(Integer idItemPedido) {
		this.idItemPedido = idItemPedido;
	}
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public String toString() {
		return "ItemPedido [idTemPedido=" + idItemPedido + ", pedido=" + pedido + ", produto=" + produto
				+ ", quantidade=" + quantidade + "]";
	}
	
	

}
