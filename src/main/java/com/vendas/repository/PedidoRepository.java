package com.vendas.repository;

import java.util.List;
import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vendas.models.Cliente;
import com.vendas.models.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer>{
	
	List<Pedido> findByCliente(Cliente cliente);
	
	@Query( value = "SELECT * FROM pedidos pd "
			+ "	LEFT JOIN item_pedidos ip "
			+ "	ON ip.pedido_id = pd.id_pedido "
			+ "	WHERE pd.id_pedido = :id_pedido ",
			nativeQuery = true)
	Optional<Pedido> findByIdFetchItens(@Param("id_pedido") Integer idPedido);

}
