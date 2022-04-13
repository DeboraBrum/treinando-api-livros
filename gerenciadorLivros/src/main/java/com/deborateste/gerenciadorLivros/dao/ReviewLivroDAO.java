package com.deborateste.gerenciadorLivros.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.deborateste.gerenciadorLivros.model.ReviewLivro;

public interface ReviewLivroDAO extends CrudRepository<ReviewLivro, Integer>{
	
	@Query(value="SELECT * FROM reviews "
			+ "WHERE id_livro = ?1 "
			+ "ORDER BY momento DESC "
			+ "LIMIT 1", nativeQuery=true)
	public ReviewLivro getOneByLivroId(Integer id);
	
	@Query(value="SELECT * FROM reviews "
			+ "WHERE id_livro = ?1 "
			+ "ORDER BY momento DESC", nativeQuery=true)
	public List<ReviewLivro> findAllByLivroId(Integer id);

}
