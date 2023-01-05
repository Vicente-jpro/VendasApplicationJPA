package com.vendas.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfiguration {
	
	@Value("${application.name}")
	private String message;
	
	@Bean( name = "enviroment_test")
	public CommandLineRunner enviromentTest() {
		return args -> {
			System.out.println(message);
		};
	}
}
