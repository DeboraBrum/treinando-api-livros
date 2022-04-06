package com.deborateste.gerenciadorLivros.dto;

import com.deborateste.gerenciadorLivros.model.Livro;
import com.deborateste.gerenciadorLivros.model.ReviewLivro;

public class LivroInfo {
	
	private String titulo;
	private String autor;
	private Integer nota;
	
	public LivroInfo(String titulo, String autor, Integer nota) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.nota = nota;
	}
	public LivroInfo(Livro l, ReviewLivro r) {
		super();
		this.titulo = l.getTitulo();
		this.autor = l.getAutor();
		this.nota = r.getNota();
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public Integer getNota() {
		return nota;
	}
	public void setNota(Integer nota) {
		this.nota = nota;
	}
}
