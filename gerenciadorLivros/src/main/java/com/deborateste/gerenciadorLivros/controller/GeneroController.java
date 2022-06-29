package com.deborateste.gerenciadorLivros.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deborateste.gerenciadorLivros.model.Genero;
import com.deborateste.gerenciadorLivros.service.IGeneroService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
public class GeneroController {

	@Autowired
	private IGeneroService service;

	@GetMapping("/generos")
	@Operation(summary = "Recupera gêneros cadastrados", description = "Este endpoint retorna todos os gêneros já cadastrados", security = @SecurityRequirement(name = "bearerAuth"))
	public ArrayList<Genero> getAll() {
		return (ArrayList<Genero>) service.recuperarTodos();
	}

}
