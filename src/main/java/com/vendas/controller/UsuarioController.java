package com.vendas.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.vendas.models.Usuario;
import com.vendas.service.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private PasswordEncoder passwordEncoder; 
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario salve(@RequestBody @Valid Usuario usuario) {
		String senhaCriptografada = passwordEncoder.encode( usuario.getSenha());
		usuario.setSenha(senhaCriptografada);
		return this.usuarioService.save(usuario);
	}
	
}
