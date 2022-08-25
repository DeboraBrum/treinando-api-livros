package com.deborateste.gerenciadorLivros.service;

import java.util.ArrayList;
import java.util.List;

import com.deborateste.gerenciadorLivros.model.ReviewLivro;

public interface IReviewLivroService {
	public ArrayList<ReviewLivro> getAll();
	public ReviewLivro getOneByLivroId(Integer id);
	public List<ReviewLivro> getAllByLivroId(Integer id);
	public ReviewLivro addOne(ReviewLivro rv);
	public ReviewLivro editOne(Integer id, ReviewLivro rv);
	public boolean deleteOne(Integer id);
}
