package com.vendas.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vendas.models.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class ClienteRepository {

	@Autowired
	private EntityManager entityManager;
	
	@Transactional
	public Cliente create(Cliente cliente) {
		entityManager.persist(cliente);
		return cliente;
	}
	
	@Transactional
	public Cliente update(Cliente cliente) {
		entityManager.merge( cliente );
		return cliente;
	}
	
	@Transactional
	public void delete(Cliente cliente) {
		Cliente client = findById( cliente );
		entityManager.remove(client);  
	}
	
	@Transactional(readOnly = true)
	public Cliente findById(Cliente cliente) {
		Cliente client = entityManager.find( Cliente.class, cliente.getIdCliente() );
		return client;
	}
	
	@Transactional( readOnly = true )
	public List<Cliente> findByName(Cliente cliente){
		// c -> This is a Cliente object reference
		String jpql = "SELECT c FROM clientes c WHERE c.nome like :nome";
		TypedQuery<Cliente> query =  entityManager.createQuery(jpql, Cliente.class);
		query.setParameter("nome", "%"+cliente.getNome()+"%");
		return query.getResultList();
	}
	
	@Transactional( readOnly = true )
	public List<Cliente> getAll(){
		return entityManager
				.createQuery("from clientes", Cliente.class)
				.getResultList();
	}
	
}
