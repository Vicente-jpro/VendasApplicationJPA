package com.vendas.exceptions;

public class PedidoNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public PedidoNotFoundException(String errorMessage) {
		super(errorMessage);
	}

}
