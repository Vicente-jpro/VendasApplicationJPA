package com.vendas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vendas.models.Cliente;
import com.vendas.service.ClienteService;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@ResponseBody
	@GetMapping( value = "/{id_cliente}", produces = "application/json" )
	public ResponseEntity getCliente(@PathVariable("id_cliente") Integer idCliente) {
		Cliente cliente = clienteService.findByIdCliente(idCliente);
		
		if ( cliente != null )
			return ResponseEntity.ok(cliente);
		return ResponseEntity.badRequest().build();
	
	}

}
