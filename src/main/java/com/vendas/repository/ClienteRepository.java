package com.vendas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vendas.models.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
//
	List<Cliente> findByNomeLike(String nome);
//	
//	List<Cliente> findByNomeOrIdCliente(String nome, Integer id);
//	
//	List<Cliente> findByNomeOrIdClienteOrderByIdCliente(String nome, Integer id);
//	
//	// Usada quando eu tenho apenas um unico nome para cada cliente na BD 
//	Cliente findOneByNome(String nome);
//	
//	boolean existsByNome(String nome);
//	 
//	@Query( value = "select c.* from clientes c where c.nome = :nome", nativeQuery = true)
//	List<Cliente> encontrarPorNome(@Param("nome") String nome);
////	
////	@Query("delete from cliente c where c.nome = :nome")
////	@Modifying
////	void deleteByNome(String nome);
//	
	//Carregar os clientes com os seus pedidos
	@Query( value = " select * from clientes c "
			+ " left join pedidos p"
			+ " on c.id_cliente = p.cliente_id "
			+ " where c.id_cliente = :id_cliente ", nativeQuery = true)
	//@Query("select c from Clientes c left join fetch c.pedidos where c.id_cliente = :id_cliente")
	Cliente findClienteFetchPedidos(@Param("id_cliente") Integer id_cliente);

	
}
