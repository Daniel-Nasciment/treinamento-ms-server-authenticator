package br.com.alura.microservice.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;

@Configuration
public class AuthorizationServerConfigurer extends AuthorizationServerConfigurerAdapter {

	// CONFIGURAÇÕES OAUTH
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	// NO EXEMPLO DO POSTMAN, O QUE FICA NA GUIA AUTHORIZATION SÃO AS INFORMAÇÕES (USERNAME, PASSOWRD) DA APLICAÇÃO PARA 
	// AUTENTICAR O USUÁRIO
	
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

		// CRIAÇÃO DA APLICAÇÃO QUE FARA A REQUISIÇÃO DE AUTENTICAÇÃO DO USUÁRIO EM MEMÓRIA
		
		// TESTE DE IDENTIFICAÇÃO DA APLICAÇÃO: localhost:8088/oauth/token
		
		clients.inMemory()
			.withClient("loja")
			.secret(passwordEncoder.encode("loja123"))
			.authorizedGrantTypes("password")
			.scopes("web", "mobile");
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {

		endpoints.authenticationManager(authenticationManager).userDetailsService(userDetailsService);

	}

}
