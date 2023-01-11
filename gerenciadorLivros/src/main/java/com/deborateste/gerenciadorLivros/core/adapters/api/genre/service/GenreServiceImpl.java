package com.deborateste.gerenciadorLivros.core.adapters.api.genre.service;

import com.deborateste.gerenciadorLivros.core.domain.ports.IGenreService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.deborateste.gerenciadorLivros.core.adapters.repository.GenreDAO;
import com.deborateste.gerenciadorLivros.core.domain.model.Genero;

@Component
public class GenreServiceImpl implements IGenreService {

	@Autowired
	private GenreDAO dao;
	
	@Override
	public List<Genero> recuperarTodos() {
		return (List<Genero>)dao.findAll();
	}

}
