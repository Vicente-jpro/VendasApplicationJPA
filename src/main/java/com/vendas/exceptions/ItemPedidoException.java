package com.vendas.exceptions;

public class ItemPedidoException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ItemPedidoException (String errorMessage) {
		super(errorMessage);
	}
}
