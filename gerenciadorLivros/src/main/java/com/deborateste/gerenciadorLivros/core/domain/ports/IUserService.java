package com.deborateste.gerenciadorLivros.core.domain.ports;

import com.deborateste.gerenciadorLivros.core.domain.model.dto.UserLoginDTO;
import com.deborateste.gerenciadorLivros.core.domain.model.Usuario;
import com.deborateste.gerenciadorLivros.security.Token;

public interface IUserService {
	
	Token gerarToken(UserLoginDTO user);
	Usuario cadastrarUser(Usuario user);
	boolean existeUsername(String username);
	boolean existeEmail(String email);

}
