package com.vendas.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table( name = "CLIENTES" )
public class Cliente {
	
	@Id @GeneratedValue( strategy = GenerationType.AUTO)
	@Column( name = "ID_CLIENTE")
	private Integer id;
	
	@Column( name = "NOME", length = 100 )
	@NotEmpty( message = "Campo nome é obrigatório")
	private String nome;
	
	@Column( name = "BI", length = 11 )
	@NotEmpty( message = "Campo bi é obrigatório")
	private String bi;
	
	//Traser apenas os clientes sem os pedidos
	@OneToMany( mappedBy = "cliente", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Pedido> pedidos ;
	 	

}
