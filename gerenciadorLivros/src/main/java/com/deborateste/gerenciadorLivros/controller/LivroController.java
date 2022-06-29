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

import com.deborateste.gerenciadorLivros.dto.LivroInfo;
import com.deborateste.gerenciadorLivros.model.Livro;
import com.deborateste.gerenciadorLivros.model.ReviewLivro;
import com.deborateste.gerenciadorLivros.service.ILivroService;
import com.deborateste.gerenciadorLivros.service.IReviewLivroService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.Operation;

@RestController
public class LivroController {

	@Autowired
	private ILivroService service;

	@Autowired
	private IReviewLivroService serviceReview;

	@GetMapping("/livros")
	@Operation(summary = "Recupera livros cadastrados", description = "Este endpoint retorna todos os livros já cadastrados", security = @SecurityRequirement(name = "bearerAuth"))
	public ResponseEntity<?> getAll() {
		try {
			List<Livro> res = service.getAll();

			if (res != null) {
				return ResponseEntity.ok(res);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@GetMapping("/livroInfo/{id}")
	@Operation(summary = "Recupera um livro cadastrado", description = "Este endpoint retorna um livro em específico", security = @SecurityRequirement(name = "bearerAuth"))
	public ResponseEntity<?> teste(@PathVariable Integer id) {
		try {
			Livro l = service.getOne(id);
			ReviewLivro rv = serviceReview.getOneByLivroId(id);

			return ResponseEntity.ok(new LivroInfo(l, rv));

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().build();
		}
	}

	@PostMapping("/livros")
	@Operation(summary = "Cadastro de livro", description = "Este endpoint cadastra um livro", security = @SecurityRequirement(name = "bearerAuth"))
	public ResponseEntity<?> addOne(@RequestBody Livro l) {
		try {
			Livro res = service.addOne(l);
			if (res != null) {
				return ResponseEntity.status(201).body(res);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.badRequest().build();
	}

	@PutMapping("/livros/{id}")
	@Operation(summary = "Edição de livro", description = "Este endpoint edita um livro", security = @SecurityRequirement(name = "bearerAuth"))
	public ResponseEntity<?> editOne(@PathVariable Integer id, @RequestBody Livro l) {
		try {
			Livro res = service.editOne(id, l);
			if (res != null) {
				return ResponseEntity.ok(res);
			}
			return ResponseEntity.notFound().build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().build();
		}
	}

	@DeleteMapping("/livros/{id}")
	@Operation(summary = "Deletar um livro", description = "Este endpoint deleta um livro", security = @SecurityRequirement(name = "bearerAuth"))
	public ResponseEntity<?> deleteOne(@PathVariable Integer id) {
		try {
			if (service.deleteOne(id)) {
				return ResponseEntity.status(200).build();
			}
			return ResponseEntity.badRequest().build();

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().build();
		}
	}

}
