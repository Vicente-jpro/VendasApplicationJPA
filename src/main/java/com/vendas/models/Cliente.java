package com.vendas.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table( name = "CLIENTES" )
public class Cliente {
	
	@Id @GeneratedValue( strategy = GenerationType.AUTO)
	@Column( name = "ID_CLIENTE")
	private Integer id;
	
	@Column( name = "NOME", length = 100 )
	private String nome;
	
	//Traser apenas os clientes sem os pedidos
	@OneToMany( mappedBy = "cliente", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Pedido> pedidos ;
	 
	
	
	public Cliente() {
	}
	

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + "]";
	}



	

}
