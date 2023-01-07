package com.vendas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vendas.models.Cliente;


public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

	
	List<Cliente> findByNomeLike(Cliente cliente);

}
