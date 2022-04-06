package com.deborateste.gerenciadorLivros.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.deborateste.gerenciadorLivros.dao.LivroDAO;
import com.deborateste.gerenciadorLivros.model.Livro;

@Component
public class LivroServiceImpl implements ILivroService {

	@Autowired
	private LivroDAO dao;

	@Override
	public ArrayList<Livro> getAll() {
		return (ArrayList<Livro>) dao.findAll();
	}
	@Override
	public Livro getOne(Integer id) {
		return dao.findById(id).orElse(null);
	}

	@Override
	public Livro addOne(Livro l) {
		dao.save(l);
		return l;
	}

	@Override
	public Livro editOne(Integer id, Livro l) {
		Livro livroBanco = this.getOne(id);

		if (livroBanco == null)
			return null;

		l.setIdLivro(id);
		dao.save(l);
		return l;
	}

	@Override
	public boolean deleteOne(Integer id) {
		Livro l = this.getOne(id);
		
		if(l == null) return false;
		
		dao.deleteById(id);
		return true;
	}


}
