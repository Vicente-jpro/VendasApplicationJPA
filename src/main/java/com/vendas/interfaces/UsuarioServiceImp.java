package com.vendas.interfaces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImp implements UserDetailsService{

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if (!username.equals("joanes")) {
			throw new UsernameNotFoundException("Usurname não encontrado");
		}
		
		return User 
				.builder()
				.username("joanes")
				.password(passwordEncoder.encode("12345"))
				.roles("USER", "ADMIN")
				.build();
	}

}
