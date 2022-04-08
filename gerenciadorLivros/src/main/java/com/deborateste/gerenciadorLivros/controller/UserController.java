package com.deborateste.gerenciadorLivros.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.deborateste.gerenciadorLivros.model.Usuario;
import com.deborateste.gerenciadorLivros.modelview.UsuarioCadastrado;
import com.deborateste.gerenciadorLivros.service.IUserService;

@RestController
public class UserController {
	
	@Autowired
	private IUserService serviceUser; 
	
	@PostMapping("/user/cadastro")
	public ResponseEntity<?> cadastroUser(@RequestBody Usuario user){
		try {
			if(serviceUser.existeEmail(user.getEmail()) || serviceUser.existeUsername(user.getUsername())) {
				throw new Exception("Já existe cadastro com esse email ou username.");
			}
			Usuario usuarioCadastrado = serviceUser.cadastrarUser(user);
			if(usuarioCadastrado == null) return ResponseEntity.internalServerError().build();
			
			return ResponseEntity.status(201).body(new UsuarioCadastrado(usuarioCadastrado));
			
		}catch(Exception e) {
			return ResponseEntity.status(400).body(e.getMessage());
		}
	}

}
