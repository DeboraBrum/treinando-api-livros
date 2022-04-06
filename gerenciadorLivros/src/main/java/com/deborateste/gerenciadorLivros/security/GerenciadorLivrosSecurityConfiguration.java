package com.deborateste.gerenciadorLivros.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class GerenciadorLivrosSecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private GerenciadorLivrosEntryPoint entryPoint;
	
	public void configure(HttpSecurity httpSec) throws Exception{
		System.out.println("Entrando na configuracao ...");
		
		httpSec.csrf().disable().exceptionHandling().authenticationEntryPoint(entryPoint)
								.and()
								.authorizeRequests()
								.antMatchers(HttpMethod.GET, "/livros").permitAll()
								.antMatchers(HttpMethod.GET, "/reviews").permitAll()
								.antMatchers(HttpMethod.GET, "/generos").permitAll()
								.antMatchers(HttpMethod.GET, "/livroInfo*/*").permitAll()
								.anyRequest().authenticated().and().cors();
		httpSec.addFilterBefore(new GerenciadorLivrosFilter(), UsernamePasswordAuthenticationFilter.class);
	}

}
