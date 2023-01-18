package com.vendas.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vendas.dto.ItemPedidoDto;
import com.vendas.dto.PedidoDto;
import com.vendas.exceptions.ItemPedidoException;
import com.vendas.models.Cliente;
import com.vendas.models.ItemPedido;
import com.vendas.models.Pedido;
import com.vendas.models.Produto;
import com.vendas.repository.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	

	@Autowired
	private ItemPedidoService itemPedidoService;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private ProdutoService produtoService;
	
	
	public List<Pedido> findByCliente(Cliente cliente){
		return this.pedidoRepository.findByCliente(cliente);
	}

	@Transactional
	public Pedido save(PedidoDto pedidoDto) {
		Integer idCliente = pedidoDto.getCliente();
		Cliente cliente = clienteService.findByIdCliente( idCliente );
		
		Pedido pedido = new Pedido();
		pedido.setTotal( pedidoDto.getTotal() );
		pedido.setDataPedido( LocalDate.now() );
		pedido.setCliente(cliente);
		
		List<ItemPedido> itemPedidos = this.converterItens(pedido, pedidoDto.getItens());
		pedidoRepository.save(pedido);
		itemPedidoService.saveAll(itemPedidos);
		pedido.setItens(itemPedidos);		
		return pedido;
	}
	
	// Responsal por converter os itemPedidoDto para ItemPedido 
	private List<ItemPedido> converterItens(Pedido pedido, List<ItemPedidoDto> itemPedidoDto) {
		
		if (itemPedidoDto.isEmpty())
			throw new ItemPedidoException("Não é possível realizar um pedido sem Item");
		
		return itemPedidoDto
			.stream()
			.map( dto -> {
				Integer idProduto = dto.getProduto();
				Produto produto = produtoService.findById(idProduto);
					
				ItemPedido itemPedido = new ItemPedido();
				itemPedido.setQuantidade( dto.getQuantidade() );
				itemPedido.setProduto(produto);
				itemPedido.setPedido( pedido );
					
				return itemPedido;
				
		}).collect(Collectors.toList() ); // Convert to list
	}
	
}
