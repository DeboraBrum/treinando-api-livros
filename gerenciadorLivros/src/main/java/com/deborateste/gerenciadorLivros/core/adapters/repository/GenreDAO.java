package com.deborateste.gerenciadorLivros.core.adapters.repository;

import org.springframework.data.repository.CrudRepository;

import com.deborateste.gerenciadorLivros.core.domain.model.Genero;

public interface GenreDAO extends CrudRepository<Genero, Integer>{

}
