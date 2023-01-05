package com.vendas.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table( name = "PEDIDOS")
public class Pedido {	
	
	@Id @GeneratedValue( strategy = GenerationType.AUTO)
	@Column( name = "ID_PEDIDO")
	private Integer idPedido;
    private Cliente cliente;
    
    @Column( name = "TOTAL")
    private Integer total;
	
    @Column( name = "DATA_PEDIDO")
    private LocalDate dataPedido;
	
	
	public Pedido(Integer idPedido, Cliente cliente, Integer total, LocalDate dataPedido) {
		this.idPedido = idPedido;
		this.cliente = cliente;
		this.total = total;
		this.dataPedido = dataPedido;
	}
	
	public Pedido(Cliente cliente, Integer total, LocalDate dataPedido) {
		this.cliente = cliente;
		this.total = total;
		this.dataPedido = dataPedido;
	}
	
	public Pedido() {

	}
	
	
	public Integer getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public LocalDate getDataPedido() {
		return dataPedido;
	}
	public void setDataPedido(LocalDate dataPedido) {
		this.dataPedido = dataPedido;
	}

	@Override
	public String toString() {
		return "Pedido [idPedido=" + idPedido + ", cliente=" + cliente + ", total=" + total + ", dataPedido="
				+ dataPedido + "]";
	}

	
}
