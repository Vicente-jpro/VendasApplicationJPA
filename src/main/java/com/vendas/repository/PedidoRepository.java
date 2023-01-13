package com.vendas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vendas.models.Cliente;
import com.vendas.models.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer>{
	
	List<Pedido> findByCliente(Cliente cliente);

}
