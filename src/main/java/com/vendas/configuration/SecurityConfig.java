package com.vendas.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.vendas.interfaces.UsuarioServiceImp;

@SuppressWarnings("deprecation")
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UsuarioServiceImp usuarioServiceImp;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(usuarioServiceImp)
				.passwordEncoder( passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable() // Para trabalhar no modo API
			.authorizeHttpRequests() // Autorizar o pedido
			// .antMatchers("/api/clientes/**").authenticated() Cliente deve estar autenticado para acessar API clientes
			//.antMatchers("/api/clientes/**").hasRole("USER") Cliente deve ter ROLE "USER" para acessar API
			// .antMatchers("/api/clientes/**").hasAuthority("MANTER USUARIO") Autenticado permante para acessar API
			//.antMatchers("/api/clientes/**").permitAll() Permitir todos os usuários acessarem essa rota
			.antMatchers("/api/clientes/**")
				.hasAnyRole("USER", "ADMIN")
				
			.antMatchers("/api/pedidos/**")
				.hasAnyRole("USER", "ADMIN")
			
			.antMatchers("/api/produtos/**")
				.hasRole("ADMIN")
			.and()
			// .formLogin() Fazer autenticacao via formulario html
			.httpBasic(); 
		// .httpBasic(); Utilizado para fazer autenticação via header no ato da requisição.
	}

}
