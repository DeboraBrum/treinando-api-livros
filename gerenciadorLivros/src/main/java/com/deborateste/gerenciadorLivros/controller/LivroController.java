package com.deborateste.gerenciadorLivros.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deborateste.gerenciadorLivros.dao.LivroDAO;
import com.deborateste.gerenciadorLivros.model.Livro;

@RestController
public class LivroController {
	
	@Autowired
	private LivroDAO dao;
	
	@GetMapping("/livros")
	public ArrayList<Livro> getAll(){
		return (ArrayList<Livro>)dao.findAll();
	}

}
