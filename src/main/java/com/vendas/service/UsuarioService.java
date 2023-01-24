package com.vendas.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.vendas.models.Usuario;
import com.vendas.repository.UsuarioRepository;

@Service
public class UsuarioService implements UserDetailsService{

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository
			.findByUsername(username)
			.orElseThrow( () -> new UsernameNotFoundException("Usuário não encontrado"));
		
		String[] usuarioRoles = usuario.isAdmin() ? new String[]{"ADMIN", "USER"} : new String[]{"USER"}; 
		
		return User
				.builder()
				.username(usuario.getUsername())
				.password( usuario.getSenha() )
				.roles(usuarioRoles)
				.build();
	}
	
	@Transactional
	public Usuario save(Usuario usuario) {
		return this.usuarioRepository.save(usuario);
	}

}
