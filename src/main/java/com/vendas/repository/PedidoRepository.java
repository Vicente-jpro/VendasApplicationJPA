package com.vendas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vendas.models.Produto;

public interface PedidoRepository extends JpaRepository<Produto, Integer>{

}
