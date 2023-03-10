package com.vendas.models;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table( name = "PRODUTOS" )
public class Produto {
	
	@Id @GeneratedValue( strategy = GenerationType.AUTO )
	@Column( name = "ID_PRODUTO")
    private Integer id;
	
	@Column( name = "PRECO_UNITARIO")
	@NotNull( message = "{campo.preco.obrigatorio}")
    private BigDecimal precoUnitario;
	
	@Column( name = "DESCRICAO")
	@NotEmpty(message = "{campo.descricao.obrigatorio}")
    private String descricao;    

	
}
