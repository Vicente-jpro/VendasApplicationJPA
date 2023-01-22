package com.vendas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.vendas.models.Produto;
import com.vendas.service.ProdutoService;

@RestController
@RequestMapping("/api/produtos")
class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Produto save(@RequestBody @Valid Produto produto) {
		return produtoService.save(produto);
	}
	
	
	@PatchMapping("/{id_produto}")
	public Produto update(@RequestBody @Valid Produto produto, @PathVariable("id_produto") Integer idProduto) {
		Produto produtoAtualizado = produtoService.update(produto, idProduto); 
		if ( produtoAtualizado != null )
			return produtoAtualizado;
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado.");
	}
	
	@DeleteMapping("/{id_produto}")
	public void delete(@PathVariable("id_produto") Integer idProduto) {
		
		boolean produtoEliminado = produtoService.delete(idProduto);		
		if (!produtoEliminado)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado.");
		throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Produto eliminado");
	}
	
	
	@GetMapping("/{id_produto}")
	public Produto findById(@PathVariable("id_produto") Integer idProduto) {
		Produto produto = produtoService.findById(idProduto); 
		if ( produto != null )
			return produto;
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado");
	}
	
	
	@GetMapping
	@ResponseStatus(HttpStatus.FOUND)
	public List<Produto> findAll() {
		return produtoService.findAll();
	}
	
	
	
}
