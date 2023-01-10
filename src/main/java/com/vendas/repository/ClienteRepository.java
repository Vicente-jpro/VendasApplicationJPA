package com.vendas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vendas.models.Cliente;


public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

	List<Cliente> findByNomeLike(String nome);
	
	List<Cliente> findByNomeOrIdCliente(String nome, Integer id);
	
	List<Cliente> findByNomeOrIdClienteOrderByIdCliente(String nome, Integer id);
	
	// Usada quando eu tenho apenas um unico nome para cada cliente na BD 
	Cliente findOneByNome(String nome);
	
	boolean existsByNome(String nome);

}
