package com.vendas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vendas.models.Cliente;


public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

	List<Cliente> findByNomeLike(String nome);
	
	List<Cliente> findByNomeOrIdCliente(String nome, Integer id);
	
	List<Cliente> findByNomeOrIdClienteOrderByIdCliente(String nome, Integer id);
	
	// Usada quando eu tenho apenas um unico nome para cada cliente na BD 
	Cliente findOneByNome(String nome);
	
	boolean existsByNome(String nome);
	 
	@Query( value = "select c.* from clientes c where c.nome = :nome", nativeQuery = true)
	List<Cliente> encontrarPorNome(@Param("nome") String nome);
	
	@Query("delete from cliente c where c.nome = :nome")
	@Modifying
	void deleteByNome(String nome);

	
}
