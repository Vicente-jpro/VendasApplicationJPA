package com.vendas.models;

import org.hibernate.annotations.GeneratorType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table( name = "CLIENTES" )
public class Cliente {
	
	@Id @GeneratedValue( strategy = GenerationType.AUTO)
	@Column( name = "ID_CLIENTE")
	private Integer idCliente;
	
	@Column( name = "NOME", length = 100 )
	private String nome;
	
	
	public Cliente(Integer idCliente, String nome) {
		this.idCliente = idCliente;
		this.nome = nome;
	}
	
	public Cliente(String nome) {
		this.nome = nome;
	}
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

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nome=" + nome + "]";
	}
	

}
