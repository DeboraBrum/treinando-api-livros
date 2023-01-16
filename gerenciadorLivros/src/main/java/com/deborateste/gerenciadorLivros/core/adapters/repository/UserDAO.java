package com.deborateste.gerenciadorLivros.core.adapters.repository;

import org.springframework.data.repository.CrudRepository;

import com.deborateste.gerenciadorLivros.core.domain.model.Usuario;

public interface UserDAO extends CrudRepository<Usuario, Integer>{
	public Usuario findByUsername(String username);
	public Usuario findByEmail(String email);
}
