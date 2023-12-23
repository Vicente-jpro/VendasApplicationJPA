package com.vendas.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuarios")
public class Usuario {
	@Id
	@Column(name = "id_usuario")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "username")
	@NotEmpty(message = "{campo.username.obrigatorio}")
	private String username;

	@Column(name = "senha")
	@NotEmpty(message = "{campo.senha.obrigatorio}")
	private String senha;

	@Column(name = "email", unique = true)
	@NotEmpty(message = "Email deve existir")
	private String email;

	@Column(name = "admin")
	// @NotEmpty( message = "{campo.admin.obrigatorio}")
	private boolean admin;

	public Usuario(String username, String senha) {
		this.username = username;
		this.senha = senha;
	}
}
