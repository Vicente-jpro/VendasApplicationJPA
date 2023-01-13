package com.vendas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vendas.models.Cliente;
import com.vendas.models.Pedido;
import com.vendas.repository.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	public Pedido create(Pedido pedido) {
		return this.pedidoRepository.save(pedido);
	}
	
	public List<Pedido> findByCliente(Cliente cliente){
		return this.pedidoRepository.findByCliente(cliente);
	}
	
}
