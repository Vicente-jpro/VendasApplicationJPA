package com.vendas.models;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table( name = "PRODUTOS" )
public class Produto {
	
	@Id @GeneratedValue( strategy = GenerationType.AUTO )
	@Column( name = "ID_PRODUTO")
    private Integer id;
	
	@Column( name = "PRECO_UNITARIO")
    private BigDecimal precoUnitario;
	
	@Column( name = "DESCRICAO")
    private String descricao;    
    
}
