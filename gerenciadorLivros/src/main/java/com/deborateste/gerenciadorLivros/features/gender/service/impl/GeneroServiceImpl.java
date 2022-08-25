package com.deborateste.gerenciadorLivros.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.deborateste.gerenciadorLivros.dao.GeneroDAO;
import com.deborateste.gerenciadorLivros.model.Genero;

@Component
public class GeneroServiceImpl implements IGeneroService{

	@Autowired
	private GeneroDAO dao;
	
	@Override
	public List<Genero> recuperarTodos() {
		return (List<Genero>)dao.findAll();
	}

}
