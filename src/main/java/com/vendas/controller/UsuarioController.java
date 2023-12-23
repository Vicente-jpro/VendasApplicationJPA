package com.vendas.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.vendas.dto.CredenciaisDto;
import com.vendas.dto.TokenDto;
import com.vendas.exceptions.SenhaInvalidaException;
import com.vendas.models.Usuario;
import com.vendas.securityjwt.JwtService;
import com.vendas.service.UsuarioService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private JwtService jwtService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario salve(@RequestBody @Valid Usuario usuario) {
		log.info("Salvar usuário");

		String senhaCriptografada = passwordEncoder.encode(usuario.getSenha());
		usuario.setSenha(senhaCriptografada);
		return this.usuarioService.save(usuario);
	}

	@PostMapping("/auth")
	public TokenDto autenticar(@RequestBody CredenciaisDto credenciaisDto) {
		log.info("Autenticar usuário.");
		try {
			Usuario usuario = Usuario
					.builder()
					.email(credenciaisDto.getEmail())
					.senha(credenciaisDto.getSenha())
					.build();
			UserDetails usuarioAutenticado = this.usuarioService.autenticar(usuario);

			String token = jwtService.gerarToken(usuario);

			return TokenDto
					.builder()
					.email(usuario.getEmail())
					.token(token)
					.build();

		} catch (SenhaInvalidaException | UsernameNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage());
		}

	}

}
