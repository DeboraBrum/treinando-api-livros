package com.deborateste.gerenciadorLivros.core.domain.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="reviews")
public class ReviewLivro {
	
	@Id
	@Column(name="id", nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idReview;
	
	@OneToOne
	@JoinColumn(name="id_livro")
	private Livro livro;
	
	@Column(name="review", nullable=false, columnDefinition="TEXT")
	private String review;
	
	@Column(name="nota", nullable=false)
	private Integer nota;
	
	@Column(name="momento", nullable=false)
	private Timestamp momento;
	
	public Timestamp getMomento() {
		return momento;
	}
	public void setMomento(Timestamp momento) {
		this.momento = momento;
	}
	public Integer getIdReview() {
		return idReview;
	}
	public void setIdReview(Integer idReview) {
		this.idReview = idReview;
	}
	public Livro getLivro() {
		return livro;
	}
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public Integer getNota() {
		return nota;
	}
	public void setNota(Integer nota) {
		this.nota = nota;
	}

}
