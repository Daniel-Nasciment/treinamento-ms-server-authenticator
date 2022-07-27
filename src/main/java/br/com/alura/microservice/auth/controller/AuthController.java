package br.com.alura.microservice.auth.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

	
	@GetMapping(value = "/user")
	public Principal user(Principal user) {
		return user;
	}

	
}
