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
	
			
			List<Cliente> clientes = clienteService.readAll(); 
			System.out.println("Existe cliente? "+clientes.isEmpty());
			for(Cliente cli: clientes  ) {
				System.out.println(""+cli.getNome());
			}
			//clientes.forEach(System.out::println);
			
//			System.out.println("Eliminado o cliente.");
//			clienteRepository.delete( cliente1 );
//			
//			System.out.println("Mostrando novos clientes");
//			List<Cliente> clientes1 = clienteRepository.findAll();
//			clientes1.forEach(System.out::println);
//
//			System.out.println("Clientes pesquisado pel
//			boolean existe = clienteRepository.existsByNome( "Madalena Xavier" );
//			System.out.println("Existe um cliente com o nome de Madalena Xavier ? "+existe);
		};
	}
	
	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}

}
