package com.vendas.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table( name = "ITEM_PEDIDOS")
public class ItemPedido {
	
	@Id @GeneratedValue( strategy = GenerationType.AUTO)
	@Column( name = "ID_TEM_PEDIDO")
	private Integer id;
	
	@ManyToOne
	@JoinColumn( name = "PEDIDO_ID")
	private Pedido pedido;
	
	@ManyToOne
	@JoinColumn( name = "PRODUTO_ID" )
    private Produto produto;
    
    @Column( name = "QUANTIDADE")
    private Integer quantidade;
	

}
