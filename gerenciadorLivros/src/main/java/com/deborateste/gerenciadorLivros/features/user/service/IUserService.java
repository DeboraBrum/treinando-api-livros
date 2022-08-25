package com.deborateste.gerenciadorLivros.service;

import com.deborateste.gerenciadorLivros.dto.UserLoginDTO;
import com.deborateste.gerenciadorLivros.model.Usuario;
import com.deborateste.gerenciadorLivros.security.Token;

public interface IUserService {
	
	public Token gerarToken(UserLoginDTO user);
	public Usuario cadastrarUser(Usuario user);
	public boolean existeUsername(String username);
	public boolean existeEmail(String email);

}
