package com.vendas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vendas.exceptions.ProdutoNotFoundException;
import com.vendas.models.Produto;
import com.vendas.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public Produto save(Produto produto) {
		return produtoRepository.save(produto);
	} 
	
	public List<Produto> findAll(){
		return produtoRepository.findAll();
	}

	public Produto findById(Integer idProduto) {
		return produtoRepository
				.findById(idProduto)
				.orElseThrow( () -> new ProdutoNotFoundException("Código do produto invalido: "+idProduto) );

	}

	public Produto update(Produto produto, Integer idProduto) {
		Produto produtoEncontrado = this.findById(idProduto);
		
		if ( produtoEncontrado != null ) {
			produto.setId(idProduto);
			return this.save(produto);
		}
		return null;
	}

	public boolean delete(Integer idProduto) {
		Produto produto = this.findById(idProduto);
		
		if ( produto != null ) {
			produtoRepository.delete(produto);
			return true;
		}
		return false;
	} 

}
