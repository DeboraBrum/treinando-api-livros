package com.deborateste.gerenciadorLivros.core.domain.ports;

import java.util.ArrayList;

import com.deborateste.gerenciadorLivros.core.domain.model.Livro;

public interface IBookService {

	ArrayList<Livro> getAll();
	Livro getOne(Integer id);
	Livro addOne(Livro rv);
	Livro editOne(Integer id, Livro rv);
	boolean deleteOne(Integer id);
	boolean thisExists(Integer id);
}
