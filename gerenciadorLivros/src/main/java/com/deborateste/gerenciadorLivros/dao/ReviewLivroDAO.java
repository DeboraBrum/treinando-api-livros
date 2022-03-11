package com.deborateste.gerenciadorLivros.dao;

import org.springframework.data.repository.CrudRepository;

import com.deborateste.gerenciadorLivros.model.ReviewLivro;

public interface ReviewLivroDAO extends CrudRepository<ReviewLivro, Integer>{

}
