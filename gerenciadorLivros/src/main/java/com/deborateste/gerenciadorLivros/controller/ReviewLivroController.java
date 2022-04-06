package com.deborateste.gerenciadorLivros.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.deborateste.gerenciadorLivros.model.ReviewLivro;
import com.deborateste.gerenciadorLivros.service.IReviewLivroService;

@RestController
public class ReviewLivroController {

	@Autowired
	private IReviewLivroService service;

	@GetMapping("/reviews")
	public ResponseEntity<?> getAll() {
		try {
			List<ReviewLivro> res = service.getAll();
			if (res != null) {
				return ResponseEntity.ok(res);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@PostMapping("/reviews")
	public ResponseEntity<?> addOne(@RequestBody ReviewLivro rv){
		try {
			ReviewLivro res = service.addOne(rv);
			if(res != null) {
				return ResponseEntity.status(201).body(res);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.badRequest().build();
	}
	@PutMapping("/reviews/{id}")
	public ResponseEntity<?> editOne(@PathVariable Integer id, @RequestBody ReviewLivro rv){
		try {
			ReviewLivro res = service.editOne(id, rv);
			if(res != null) {
				return ResponseEntity.ok(res);
			}
			return ResponseEntity.notFound().build();
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().build();
		}
	}
	
	@DeleteMapping("/reviews/{id}")
	public ResponseEntity<?> deleteOne(@PathVariable Integer id){
		try {
			if(service.deleteOne(id)) {
				return ResponseEntity.status(200).build();
			}
			return ResponseEntity.badRequest().build();
			
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().build();
		}
	}
	
	
	
}
