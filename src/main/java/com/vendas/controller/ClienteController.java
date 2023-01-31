package com.vendas.controller;

import java.util.List;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.vendas.models.Cliente;
import com.vendas.service.ClienteService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/clientes")
@Api("Api Clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	// Tia cati
	
	
	@GetMapping( value = "{id_cliente}", produces = "application/json" )
	@ApiOperation("Obter detalhes de um cliente.")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Cliente encontrado"),
		@ApiResponse(code = 404, message = "Cliente não encontrado para o Id informado")
	})
	public Cliente getCliente(@PathVariable("id_cliente") Integer idCliente) {
		Cliente cliente = clienteService.findByIdCliente(idCliente);
		
		if ( cliente != null )
			return cliente;
		
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado");	
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation("Salvar cliente.")
	@ApiResponses({
		@ApiResponse(code = 201, message = "Cliente salvo com sucesso."),
		@ApiResponse(code = 400, message = "Erro de validação.")
	})
	public Cliente save(@RequestBody @Valid Cliente cliente) {
	   return clienteService.save(cliente);
	}
	
	@PatchMapping("/{id_cliente}")
	@ApiOperation("Atualizar cliente")
	@ApiResponses({
		@ApiResponse(code = 201, message = "Cliente atualizado com sucesso."),
		@ApiResponse(code = 404, message = "Cliente não encontrado. Id invalido")
	})
	public Cliente update(@PathVariable("id_cliente") Integer idCliente, 
								 @RequestBody @Valid Cliente cliente) {
		Cliente clienteAtualizado = clienteService.update(cliente, idCliente);
		if (clienteAtualizado != null)
			return clienteAtualizado;
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Este cliente não existe.");
	}
	
	@DeleteMapping("/{id_cliente}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation("Eliminar clientes")
	@ApiResponses({
		@ApiResponse(code = 204, message = "Cliente eliminado com successo"),
		@ApiResponse(code = 404, message = "Cliente não encontrado para ser eliminado. Id invalido.")
	})
	public void delete(@PathVariable("id_cliente") Integer idCliente) {
		clienteService.delete(idCliente);	
	}

	// form-data
	@GetMapping
	@ApiOperation("Listar clientes")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Clientes listados com sucesso")
	})
	public ResponseEntity find(Cliente cliente) {
		List<Cliente> lista = clienteService.findAll(cliente);
		
		return ResponseEntity.ok(lista);
	}
	
	
	
	
	
}
