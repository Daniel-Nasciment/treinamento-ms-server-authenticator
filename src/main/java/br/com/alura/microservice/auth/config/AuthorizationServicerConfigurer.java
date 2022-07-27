package br.com.alura.microservice.auth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;

@Configuration
public class AuthorizationServicerConfigurer extends AuthorizationServerConfigurerAdapter {

	private AuthenticationManager authenticationManager;
	
	private UserDetailsService userDetailsService;
	
}
