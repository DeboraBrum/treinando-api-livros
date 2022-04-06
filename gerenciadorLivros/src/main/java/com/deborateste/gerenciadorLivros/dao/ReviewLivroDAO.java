package com.deborateste.gerenciadorLivros.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.deborateste.gerenciadorLivros.model.ReviewLivro;

public interface ReviewLivroDAO extends CrudRepository<ReviewLivro, Integer>{
	
	@Query(value="SELECT * FROM reviews "
			+ "WHERE id_livro = ?1 "
			+ "LIMIT 1", nativeQuery=true)
	public ReviewLivro getOneByLivroId(Integer id);

}
