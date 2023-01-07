package com.vendas.models;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table( name = "PEDIDOS")
public class Pedido {	
	
	@Id @GeneratedValue( strategy = GenerationType.AUTO)
	@Column( name = "ID_PEDIDO")
	private Integer idPedido;
	
	@ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.REMOVE} )
	@JoinColumn( name = "CLIENTE_ID" )
    private Cliente cliente;
    
    @Column( name = "TOTAL")
    private Integer total;
	
    @Column( name = "DATA_PEDIDO")
    private LocalDate dataPedido;
	
	
	
	public Pedido() {

	}
	
	
	public Integer getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
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



	
}
