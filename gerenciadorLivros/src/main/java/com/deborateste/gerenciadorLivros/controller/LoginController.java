package com.deborateste.gerenciadorLivros.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.deborateste.gerenciadorLivros.dto.UserLoginDTO;
import com.deborateste.gerenciadorLivros.security.Token;
import com.deborateste.gerenciadorLivros.service.IUserService;

@RestController
public class LoginController {
	
	@Autowired
	private IUserService service;
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody UserLoginDTO dadosLogin){
		try {
			if(dadosLogin.getUsername() == null || dadosLogin.getSenha() == null) {
				throw new Exception("Favor informar email e senha");
			}
			
			Token token = service.gerarToken(dadosLogin);
			if(token == null) {
				return ResponseEntity.status(401).body("E-mail e/ou senha incorreto(s)");
			}
			
			return ResponseEntity.ok(token);
			
		}catch(Exception ex) {
			return ResponseEntity.badRequest().body(ex.getMessage());
		}
	}
}
