package com.vendas.service;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.vendas.exceptions.SenhaInvalidaException;
import com.vendas.models.Usuario;
import com.vendas.repository.UsuarioRepository;
import com.vendas.utils.CurrentUser;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UsuarioService implements UserDetailsService {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UsuarioRepository usuarioRepository;

	public UserDetails autenticar(Usuario usuario) {
		log.info("Autenticando o usuário...");
		UserDetails userDetails = this.loadUserByUsername(usuario.getEmail());
		// passwordEncoder.matches(senhaDigitada, senhaGravadaNoBD)
		boolean senhaCorreta = passwordEncoder.matches(usuario.getSenha(), userDetails.getPassword());

		if (senhaCorreta) {
			return userDetails;
		}
		log.info("Usuário não encontrado");
		throw new SenhaInvalidaException();
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository
				.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));

		String[] usuarioRoles = usuario.isAdmin() ? new String[] { "ADMIN", "USER" } : new String[] { "USER" };

		UserDetails user = User
				.builder()
				.username(usuario.getUsername())
				.password(usuario.getSenha())
				.roles(usuarioRoles)
				.build();

		return new CurrentUser(user, usuario);
	}

	@Transactional
	public Usuario save(Usuario usuario) {
		return this.usuarioRepository.save(usuario);
	}

}
