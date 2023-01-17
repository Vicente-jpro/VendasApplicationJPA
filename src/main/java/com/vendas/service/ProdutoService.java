package com.vendas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		Optional<Produto> produto = produtoRepository.findById(idProduto);
		if (produto.isPresent())
			return produto.get();
		return null;
	} 

}
