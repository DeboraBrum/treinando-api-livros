package com.deborateste.gerenciadorLivros.core.adapters.api.review.service;

import com.deborateste.gerenciadorLivros.core.adapters.repository.BookReviewDAO;
import com.deborateste.gerenciadorLivros.core.domain.ports.IBookReviewService;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.deborateste.gerenciadorLivros.core.domain.model.ReviewLivro;

@Component
public class BookReviewServiceImpl implements IBookReviewService {
	
	@Autowired
	private BookReviewDAO dao;
	
	@Override
	public ArrayList<ReviewLivro> getAll(){
		return (ArrayList<ReviewLivro>)dao.findAll();
	}
	
	@Override
	public ReviewLivro addOne(ReviewLivro rv) {
		dao.save(rv);
		return rv;
	}
	
	@Override
	public ReviewLivro editOne(Integer id, ReviewLivro rv) {
		ReviewLivro reviewBanco = dao.findById(id).orElse(null);
		
		if(reviewBanco == null) return null;
		
		rv.setIdReview(id);
		dao.save(rv);
		return rv;
	}

	@Override
	public boolean deleteOne(Integer id) {
		ReviewLivro rv = dao.findById(id).orElse(null);
		if(rv == null) return false;
		
		dao.deleteById(id);
		return true;
	}

	@Override
	public ReviewLivro getOneByLivroId(Integer id) {
		return dao.getOneByLivroId(id);
	}

	@Override
	public List<ReviewLivro> getAllByLivroId(Integer id) {
		return dao.findAllByLivroId(id);
	}
}
