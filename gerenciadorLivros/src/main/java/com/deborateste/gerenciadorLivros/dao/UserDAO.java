package com.deborateste.gerenciadorLivros.dao;

import org.springframework.data.repository.CrudRepository;

import com.deborateste.gerenciadorLivros.model.Usuario;

public interface UserDAO extends CrudRepository<Usuario, Integer>{
	public Usuario findByUsername(String username);
	public Usuario findByEmail(String email);
}
