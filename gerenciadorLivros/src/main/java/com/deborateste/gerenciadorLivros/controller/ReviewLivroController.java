package com.deborateste.gerenciadorLivros.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deborateste.gerenciadorLivros.dao.ReviewLivroDAO;
import com.deborateste.gerenciadorLivros.model.ReviewLivro;

@RestController
public class ReviewLivroController {
	
	@Autowired
	private ReviewLivroDAO dao;
	
	@GetMapping("/reviews")
	public ArrayList<ReviewLivro> getAll(){
		return (ArrayList<ReviewLivro>)dao.findAll();
	}
}
