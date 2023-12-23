package com.vendas.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hello")
public class HelloController {

	@ResponseBody
	@GetMapping(value = { "/{nome}", "/cliente/{nome}" }, consumes = { "application/json", "application/xml" }, // It is
																												// what
																												// my
																												// API
																												// going
																												// to
																												// consume
																												// (receive)
			produces = { "application/json", "application/xml" } // It is what my API going to produce for others
																	// consume
	)
	public String hello(@PathVariable("nome") String nome) {
		return String.format("Hello %s", nome);
	}

	@GetMapping("test")
	public Object test() {
		return SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}

}
