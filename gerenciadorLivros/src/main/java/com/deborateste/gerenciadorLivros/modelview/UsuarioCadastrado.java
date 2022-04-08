package com.deborateste.gerenciadorLivros.modelview;

import com.deborateste.gerenciadorLivros.model.Usuario;

public class UsuarioCadastrado {
	
	private String nome;
	private String username;
	
	public UsuarioCadastrado(Usuario user) {
		super();
		this.nome = user.getNome();
		this.username = user.getUsername();
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

}
