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
			clienteRepository.save( new Cliente("Vicente Simão") );
			clienteRepository.save( new Cliente("Xavier Ruben") );
			clienteRepository.save( new Cliente("Madalena Xavier") );
			clienteRepository.save( new Cliente( 1, "Luísa Anibal"));
			
			List<Cliente> clientes = clienteRepository.findAll();
			clientes.forEach(System.out::println);
			
			clienteRepository.delete( new Cliente(2, null) );
			

			System.out.println("Clientes pesquisado pelo nome");
			List<Cliente> clientes2 = clienteRepository.findByNomeLike( new Cliente("Xavier") );
			clientes2.forEach(System.out::println);
			
			
		};
	}
	
	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}

}
