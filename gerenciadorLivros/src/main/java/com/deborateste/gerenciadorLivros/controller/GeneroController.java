package com.deborateste.gerenciadorLivros.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deborateste.gerenciadorLivros.dao.GeneroDAO;
import com.deborateste.gerenciadorLivros.model.Genero;

@RestController
public class GeneroController {
	
	@Autowired
	private GeneroDAO dao;
	
	@GetMapping("/generos")
	public ArrayList<Genero> getAll(){
		return (ArrayList<Genero>)dao.findAll();
	}

}
