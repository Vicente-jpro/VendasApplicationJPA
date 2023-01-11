package com.vendas.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table( name = "CLIENTES" )
public class Cliente {
	
	@Id @GeneratedValue( strategy = GenerationType.AUTO)
	@Column( name = "ID_CLIENTE")
	private Integer idCliente;
	
	@Column( name = "NOME", length = 100 )
	private String nome;
	
	//Traser apenas os clientes sem os pedidos
	@OneToMany( mappedBy = "cliente", fetch = FetchType.LAZY )
	private Set<Pedido> pedidos ;
	 
	
//	public Cliente(Integer idCliente, String nome) {
//		this.idCliente = idCliente;
//		this.nome = nome;
//	}
//	
//	public Cliente(String nome) {
//		this.nome = nome;
//	}
	public Cliente() {
	}
	
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(Set<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nome=" + nome + ", pedidos=" + pedidos + "]";
	}


	

}
