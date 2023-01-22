package com.vendas.controller;

import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.vendas.dto.ItemPedidoInfoDto;
import com.vendas.dto.PedidoDto;
import com.vendas.dto.PedidoInfoDto;
import com.vendas.exceptions.PedidoNotFoundException;
import com.vendas.models.ItemPedido;
import com.vendas.models.Pedido;
import com.vendas.service.PedidoService;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {
	
	@Autowired
	private PedidoService pedidoService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Integer save(@RequestBody PedidoDto pedidoDto) {
		Pedido pedidoRealisado = pedidoService.save(pedidoDto);
		return pedidoRealisado.getId();
	}
	
	@GetMapping("/{id_pedido}")
	@ResponseStatus(HttpStatus.FOUND)
	public PedidoInfoDto getPedidos(@PathVariable("id_pedido") Integer idPedido) {
		return pedidoService
				.obterTodosPedidos(idPedido)
				.map( p -> converterParaPedidoInfoDto(p))
				.orElseThrow( ()-> new PedidoNotFoundException("Codigo do pedido invalido"));
	} 
	
	@PatchMapping("/{id_pedido}")
	@ResponseStatus(HttpStatus.CREATED)
	public void canselarPedido(@PathVariable("id_pedido") Integer idPedido) {
		 pedidoService.update(idPedido);
	}
		
	private PedidoInfoDto converterParaPedidoInfoDto(Pedido pedido){
		return PedidoInfoDto
				.builder()
				.nomeCliente(pedido.getCliente().getNome())
				.bi(pedido.getCliente().getBi())
				.id(pedido.getId())
				.dataPedido( pedido.getDataPedido().format( DateTimeFormatter.ofPattern("dd/MM/yyyy")))
				.itens( converterParaItemPedidoInfoDto(pedido.getItens()) )				
				.build();
				
	}
	
	private List<ItemPedidoInfoDto> converterParaItemPedidoInfoDto(List<ItemPedido> itens){
		if (CollectionUtils.isEmpty(itens))
			return Collections.emptyList();
		
		return itens
				.stream()
				.map( item ->
					ItemPedidoInfoDto.builder()
						.descricaoProduto(item.getProduto().getDescricao())
						.precoUnitario( item.getProduto().getPrecoUnitario() )
						.quantidade( item.getQuantidade() )
						.build()
				 ).collect(Collectors.toList());
				
	}

}
