package com.vendas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.vendas.models.Cliente;
import com.vendas.service.ClienteService;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	// Tia cati
	
	
	@GetMapping( value = "{id_cliente}", produces = "application/json" )
	public Cliente getCliente(@PathVariable("id_cliente") Integer idCliente) {
		Cliente cliente = clienteService.findByIdCliente(idCliente);
		
		if ( cliente != null )
			return cliente;
		
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado");	
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente save(@RequestBody Cliente cliente) {
	   return clienteService.save(cliente);
	}
	
	@PatchMapping("/{id_cliente}")
	public Cliente update(@PathVariable("id_cliente") Integer idCliente, 
								 @RequestBody Cliente cliente) {
		Cliente clienteAtualizado = clienteService.update(cliente, idCliente);
		if (clienteAtualizado != null)
			return clienteAtualizado;
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Este cliente não existe.");
	}
	
	@DeleteMapping("/{id_cliente}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id_cliente") Integer idCliente) {
		clienteService.delete(idCliente);	
	}

	// form-data
	@GetMapping
	public ResponseEntity find(Cliente cliente) {
		List<Cliente> lista = clienteService.findAll(cliente);
		
		return ResponseEntity.ok(lista);
	}
	
	
	
	
	
}
