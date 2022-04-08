package com.deborateste.gerenciadorLivros.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deborateste.gerenciadorLivros.model.Genero;
import com.deborateste.gerenciadorLivros.service.IGeneroService;

@RestController
public class GeneroController {
	
	@Autowired
	private IGeneroService service;
	
	@GetMapping("/generos")
	public ArrayList<Genero> getAll(){
		return (ArrayList<Genero>)service.recuperarTodos();
	}

}
