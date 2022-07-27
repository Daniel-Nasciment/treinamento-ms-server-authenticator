package br.com.alura.microservice.auth.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

	
	@PostMapping(value = "/user")
	public Principal user(Principal user) {
		return user;
	}

	
}
