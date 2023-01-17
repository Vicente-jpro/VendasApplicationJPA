package com.vendas.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
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
	
	public Cliente findByIdCliente(Integer idCliente) {
		try {

			Optional<Cliente> cliente = clienteRepository.findById(idCliente);
			return cliente.get();
		} catch (NoSuchElementException e) {
			System.out.println("Cliente não encontrado: \n"+e);
			return null;
		}
		
	}

	public Cliente save(Cliente cliente) {
		
		try {
			return clienteRepository.save(cliente);
		} catch (IllegalArgumentException e) {
			System.out.println("Não foi possivel salvar o cliente: "+e);
			return null;
		}
		
	}

	public void delete(Integer idCliente) {
		Cliente clienteEncontrado = this.findByIdCliente( idCliente );
		try {
			
			clienteRepository.delete(clienteEncontrado);
		} catch (IllegalArgumentException | NoSuchElementException e) {
			System.out.println("Impossivel eliminar o cliente. Cliente não existe "+e);
		}
		
	}

	public Cliente update(Cliente cliente, Integer idCliente) {
		Cliente clienteEncontrado = this.findByIdCliente(idCliente);
		if ( clienteEncontrado != null ) {
			cliente.setId(idCliente);
			return clienteRepository.save(cliente);
		}
		return null;
	}
	
	public List<Cliente> findAll(Cliente cliente){

		ExampleMatcher matcher = ExampleMatcher
									.matching()
									.withIgnoreCase()
									.withStringMatcher(  StringMatcher.CONTAINING );
		
		Example<Cliente> example = Example.of(cliente, matcher);
		
		return clienteRepository.findAll(example);
	}
	
}
