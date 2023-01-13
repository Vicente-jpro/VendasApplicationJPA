package com.vendas;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.vendas.models.Cliente;
import com.vendas.repository.PedidoRepository;
import com.vendas.service.ClienteService;

@SpringBootApplication
public class VendasApplication {

	@Autowired 
	private ClienteService clienteService;
	
	@Bean
	public CommandLineRunner create(
			
			@Autowired PedidoRepository pedidoRepository
			) {
		return args ->{
			
			Cliente cliente1 = new Cliente();
			cliente1.setNome("Vicente Simão");
			
			Cliente cliente2 = new Cliente();
			cliente2.setNome("Xavier Ruben");
			
			Cliente cliente3 = new Cliente();
			cliente3.setNome("Madalena Xavier");
			
			this.clienteService.create(cliente1);
			this.clienteService.create(cliente2);
			this.clienteService.create(cliente3);
		
			System.out.println("Encontrar o cliente com pedidos.");
	
			
			Cliente clientePedidos = clienteService.findClienteFetchPedidos(4); 
			System.out.println( " "+clientePedidos.toString() );
			
		};
	}
	
	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}

}
