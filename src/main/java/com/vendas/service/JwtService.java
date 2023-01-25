package com.vendas.service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Service;

import com.vendas.VendasApplication;
import com.vendas.models.Usuario;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtService {
	
	@Value("${security.jwt.expiracao}")
	private String expiracao;
	
	@Value("${security.jwt.chave-assinatura}")
	private String chaveAssinatura;
	
	// Gerar token
	public String gerarToken(Usuario usuario) {
		long minutoExpiracao = Long.valueOf(expiracao);
		LocalDateTime dataHoraExpiracao = LocalDateTime.now().plusMinutes(minutoExpiracao);
		Instant instant =  dataHoraExpiracao.atZone(ZoneId.systemDefault() ).toInstant();
		Date data = Date.from( instant );
		return Jwts
					.builder()
					.setSubject(usuario.getUsername())
					.setExpiration(data)
					.signWith(SignatureAlgorithm.HS512, chaveAssinatura)
					.compact();
					
	}
	
	
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(VendasApplication.class);
		JwtService service = context.getBean(JwtService.class);
		Usuario usuario = new Usuario();
		usuario.setUsername("vicente");
		String token = service.gerarToken(usuario);
		System.out.println(token);
	}
	
}
