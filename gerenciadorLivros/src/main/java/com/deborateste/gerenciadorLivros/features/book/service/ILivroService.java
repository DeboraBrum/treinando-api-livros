package com.deborateste.gerenciadorLivros.service;

import java.util.ArrayList;

import com.deborateste.gerenciadorLivros.model.Livro;

public interface ILivroService {

	public ArrayList<Livro> getAll();
	public Livro getOne(Integer id);
	public Livro addOne(Livro rv);
	public Livro editOne(Integer id, Livro rv);
	public boolean deleteOne(Integer id);
	public boolean thisExists(Integer id);
}
