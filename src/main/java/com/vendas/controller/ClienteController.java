package com.vendas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.vendas.models.Cliente;
import com.vendas.service.ClienteService;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@ResponseBody
	@GetMapping( value = "{id_cliente}", produces = "application/json" )
	public ResponseEntity getCliente(@PathVariable("id_cliente") Integer idCliente) {
		Cliente cliente = clienteService.findByIdCliente(idCliente);
		
		if ( cliente != null )
			return ResponseEntity.ok(cliente);
		return ResponseEntity.notFound().build();
	
	}
	
	@PostMapping
	public ResponseEntity save(@RequestBody Cliente cliente) {
		Cliente clienteSalvo = clienteService.save(cliente);
		
		if (clienteSalvo != null)
			return ResponseEntity.ok(clienteSalvo);
		return ResponseEntity.badRequest().build();
	}
	
	@PatchMapping("/{id_cliente}")
	public ResponseEntity update(@PathVariable("id_cliente") Integer idCliente, 
								 @RequestBody Cliente cliente) {
		Cliente clienteAtualizado = clienteService.update(cliente, idCliente);
		if (clienteAtualizado != null)
			return ResponseEntity.ok(cliente);
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id_cliente}")
	public ResponseEntity delete(@PathVariable("id_cliente") Integer idCliente) {
		clienteService.delete(idCliente);	
		return ResponseEntity.noContent().build();

	}

	// form-data
	@GetMapping
	public ResponseEntity find(Cliente cliente) {
		List<Cliente> lista = clienteService.findAll(cliente);
		
		return ResponseEntity.ok(lista);
	}
	
	
	
	
	
}
