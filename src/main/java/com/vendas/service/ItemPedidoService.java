package com.vendas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vendas.models.ItemPedido;
import com.vendas.repository.ItemPedidoRepository;

@Service
public class ItemPedidoService {
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	public List<ItemPedido> saveAll(List<ItemPedido> itemPedidos) {
		return this.itemPedidoRepository.saveAll(itemPedidos);
	}
}
