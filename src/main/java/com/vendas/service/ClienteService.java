package com.vendas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vendas.models.Cliente;
import com.vendas.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente create(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	public List<Cliente> readAll(){
		return clienteRepository.findAll();
	}

	public List<Cliente> readAll(String nome) {
		// TODO Auto-generated method stub
		return clienteRepository.findByNomeLike(nome);
	}

	public Cliente findClienteFetchPedidos(Integer idCliente) {
		return clienteRepository.findClienteFetchPedidos(idCliente);
	}
	
}
