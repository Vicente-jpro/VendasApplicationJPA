package com.vendas;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.vendas.models.Cliente;
import com.vendas.models.Pedido;
import com.vendas.repository.ClienteRepository;
import com.vendas.repository.PedidoRepository;

//@EnableJpaRepositories("com.package.base.*")
//@ComponentScan(basePackages = { "com.vendas.*" })
//@EntityScan("com.vendas.models.*") 
@SpringBootApplication
public class VendasApplication {

	@Bean
	public CommandLineRunner create(
			@Autowired ClienteRepository clienteRepository,
			@Autowired PedidoRepository pedidoRepository
			) {
		return args ->{
			
			Cliente cliente1 = new Cliente();
			cliente1.setNome("Vicente Simão");
			
			Cliente cliente2 = new Cliente();
			cliente2.setNome("Xavier Ruben");
			
			Cliente cliente3 = new Cliente();
			cliente3.setNome("Madalena Xavier");
			
			clienteRepository.save( cliente1 );
			clienteRepository.save( cliente2 );
			clienteRepository.save( cliente3 );
			
			Pedido pedido = new Pedido();
			pedido.setCliente(cliente1);
			pedido.setDataPedido(LocalDate.now());
			pedido.setTotal( BigDecimal.valueOf( 15555 ));
			
			//pedidoRepository.save(pedido);
			
			System.out.println("Encontrar o cliente com pedidos.");
			Cliente cli = clienteRepository.findClienteFetchPedidos( cliente1.getIdCliente() );
			System.out.println( cli );
			System.out.println( cli.getPedidos() );
			
			List<Cliente> clientes = clienteRepository.findAll();
			clientes.forEach(System.out::println);
			
			System.out.println("Eliminado o cliente.");
			clienteRepository.delete( cliente1 );
			
			System.out.println("Mostrando novos clientes");
			List<Cliente> clientes1 = clienteRepository.findAll();
			clientes1.forEach(System.out::println);

			System.out.println("Clientes pesquisado pelo nome");
			List<Cliente> clientes2 = clienteRepository.encontrarPorNome( "Madalena Xavier" );
			clientes2.forEach(System.out::println);
			

			System.out.println("Clientes pesquisado pelo nome ou id");
			List<Cliente> clientes3 = clienteRepository.findByNomeOrIdClienteOrderByIdCliente( "", 3 );
			clientes3.forEach(System.out::println);
			
			boolean existe = clienteRepository.existsByNome( "Madalena Xavier" );
			System.out.println("Existe um cliente com o nome de Madalena Xavier ? "+existe);
		};
	}
	
	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}

}
