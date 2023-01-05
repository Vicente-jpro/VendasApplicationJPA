package com.vendas.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.vendas.models.Cliente;

@Repository
public class ClienteRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public Cliente create(Cliente cliente) {
		String sql = "INSERT INTO clientes (nome) VALUES(?)";
		
		jdbcTemplate.update(sql, new Object[] {cliente.getNome()});
		return cliente;
	}
	
	public Cliente update(Cliente cliente) {
		String sql = "UPDATE clientes SET nome = ? WHERE id_cliente = ?";
		jdbcTemplate.update(sql, new Object[] {cliente.getNome(), cliente.getIdCliente()});
		return cliente;
	}
	
	public void delete(Cliente cliente) {
		String sql = "DELETE FROM clientes WHERE id_cliente = ?";
		jdbcTemplate.update(sql, new Object[] {cliente.getIdCliente()});
	}
	
	public List<Cliente> getAll(){
		String sql = "SELECT * FROM clientes";
		return jdbcTemplate.query(sql, new RowMapper<Cliente>() {

			@Override
			public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new Cliente(rs.getInt("id_cliente"),  rs.getString("nome"));
			}
			
		});
	}
	
	
	public List<Cliente> getByIdCliente(Cliente cliente){
		String sql = "SELECT * FROM clientes where id_cliente = "+cliente.getIdCliente();
		
		return jdbcTemplate.query(sql, new RowMapper<Cliente>() {

			@Override
			public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new Cliente(rs.getInt("id_cliente"),  rs.getString("nome"));
			}
			
		});
		
	}
	
	
}
