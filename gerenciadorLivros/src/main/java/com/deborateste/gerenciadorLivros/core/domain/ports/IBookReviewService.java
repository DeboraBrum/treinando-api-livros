package com.deborateste.gerenciadorLivros.core.domain.ports;

import java.util.ArrayList;
import java.util.List;

import com.deborateste.gerenciadorLivros.core.domain.model.ReviewLivro;

public interface IBookReviewService {
	ArrayList<ReviewLivro> getAll();
	ReviewLivro getOneByLivroId(Integer id);
	List<ReviewLivro> getAllByLivroId(Integer id);
	ReviewLivro addOne(ReviewLivro rv);
	ReviewLivro editOne(Integer id, ReviewLivro rv);
	boolean deleteOne(Integer id);
}
