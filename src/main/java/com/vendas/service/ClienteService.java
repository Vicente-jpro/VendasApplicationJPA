package com.vendas.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vendas.models.Cliente;
import com.vendas.repository.ClienteRepository;

@Service
@Transactional
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public void create(Cliente cliente) {
		this.clienteRepository.save(cliente);
	}
	
	public List<Cliente> readAll(){
		return this.clienteRepository.findAll();
	}
	
}
