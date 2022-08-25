package com.deborateste.gerenciadorLivros.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.deborateste.gerenciadorLivros.dao.UserDAO;
import com.deborateste.gerenciadorLivros.dto.UserLoginDTO;
import com.deborateste.gerenciadorLivros.model.Usuario;
import com.deborateste.gerenciadorLivros.security.Cripto;
import com.deborateste.gerenciadorLivros.security.Token;
import com.deborateste.gerenciadorLivros.security.TokenUtil;

@Component
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserDAO dao;

	@Override
	public Token gerarToken(UserLoginDTO dadosLogin) {
		try {
			Usuario user = dao.findByUsername(dadosLogin.getUsername());
			
			if(user == null) throw new Exception("Não existe cadastro");
			
			String senhaLogin = Cripto.encrypt(dadosLogin.getSenha());
			
			if(!user.getSenha().equals(senhaLogin)) throw new Exception("Username ou senha incorretos");
			
			return new Token(TokenUtil.createToken(user));
			
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public Usuario cadastrarUser(Usuario user) {
		try {
			user.setId(null);

			user.setSenha(Cripto.encrypt(user.getSenha()));

			return dao.save(user);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public boolean existeUsername(String username) {
		if(dao.findByUsername(username) == null) return false;
		return true;
	}

	@Override
	public boolean existeEmail(String email) {
		if(dao.findByEmail(email) == null) return false;
		return true;
	}

}
