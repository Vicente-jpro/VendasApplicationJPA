package com.vendas.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SuppressWarnings("deprecation")
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
				.passwordEncoder( passwordEncoder())
				.withUser("vicente")
				.password( passwordEncoder().encode("vicente0301"))
				.roles("USER");
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
			.antMatchers("/api/clientes/**").permitAll()
			.and()
			.formLogin();
	}

}
