package com.vendas.exceptions;

public class ProdutoNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ProdutoNotFoundException(String errorMessage) {
		super(errorMessage);
	}
}
