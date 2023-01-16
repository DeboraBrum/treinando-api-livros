package com.deborateste.gerenciadorLivros.core.adapters.repository;

import org.springframework.data.repository.CrudRepository;

import com.deborateste.gerenciadorLivros.core.domain.model.Livro;

public interface BookDAO extends CrudRepository<Livro, Integer>{
}
