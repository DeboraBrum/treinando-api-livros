package com.deborateste.gerenciadorLivros.dao;

import org.springframework.data.repository.CrudRepository;

import com.deborateste.gerenciadorLivros.model.Livro;

public interface LivroDAO extends CrudRepository<Livro, Integer>{

}
