package com.vendas.models;

public class ItemPedido {
	private Integer idItemPedido;
	
	private Pedido pedido;
    private Produto produto;
    
    private int quantidade;
	
	public ItemPedido(Integer idItemPedido, Pedido pedido, Produto produto, int quantidade) {
		this.idItemPedido = idItemPedido;
		this.pedido = pedido;
		this.produto = produto;
		this.quantidade = quantidade;
	}
	
	public ItemPedido(Pedido pedido, Produto produto, int quantidade) {
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
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public String toString() {
		return "ItemPedido [idTemPedido=" + idItemPedido + ", pedido=" + pedido + ", produto=" + produto
				+ ", quantidade=" + quantidade + "]";
	}
	
	

}
