package com.deborateste.gerenciadorLivros.core.domain.ports;

import java.util.List;

import com.deborateste.gerenciadorLivros.core.domain.model.Genero;

public interface IGenreService {
	List<Genero> recuperarTodos();
}
