package com.vendas.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table( name = "PEDIDOS")
public class Pedido {	
	
	@Id @GeneratedValue( strategy = GenerationType.AUTO)
	@Column( name = "ID_PEDIDO")
	private Integer id;
	
	@ManyToOne( cascade = {CascadeType.MERGE} )
	@JoinColumn( name = "CLIENTE_ID" )
    private Cliente cliente;
    
	// 1000.00 -> length = 20, precision = 2
    @Column( name = "TOTAL", precision = 20, scale = 2)
    private BigDecimal total;
	
    @Column( name = "DATA_PEDIDO")
    private LocalDate dataPedido;
	
    @OneToMany( mappedBy = "pedido")
    private List<ItemPedido> itens;
    
	
}
