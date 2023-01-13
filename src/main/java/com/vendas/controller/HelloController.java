package com.vendas.controller;

import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hello")
public class HelloController {

	@ResponseBody
	@GetMapping( value = "/{nome}")
	public String hello(@PathVariable  String nome ) {
		return String.format( "Hello %s", nome);
	}
	
	
	
}
