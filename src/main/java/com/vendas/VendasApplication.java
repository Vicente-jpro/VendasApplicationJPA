package com.vendas;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.vendas.models.Cliente;
import com.vendas.repository.ClienteRepository;

@SpringBootApplication
public class VendasApplication {

	@Bean
	public CommandLineRunner create(@Autowired ClienteRepository clienteRepository) {
		return args ->{
			clienteRepository.create( new Cliente("Vicente Simão") );
			clienteRepository.create( new Cliente("Xavier Ruben") );
			clienteRepository.create( new Cliente("Madalena Xavier") );
			clienteRepository.update( new Cliente( 1, "Luísa Anibal"));
			
			List<Cliente> clientes = clienteRepository.getAll();
			clientes.forEach(System.out::println);
			
			clienteRepository.delete( new Cliente(2, null) );
			
			List<Cliente> clientes2 = clienteRepository.getAll();
			clientes2.forEach(System.out::println);
			
			Cliente clt = clienteRepository.findById( new Cliente(1, null));
			System.out.println("Cliente pesquisado pelo ID");
			System.out.println( clt);
			
			List<Cliente> clt2 = clienteRepository.findByName( new Cliente("Luísa Anibal"));
			System.out.println("Clientes pesquisado pelo nome");
			clt2.forEach( System.out::println);
			
			
		};
	}
	
	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}

}
