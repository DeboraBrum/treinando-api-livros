package com.deborateste.gerenciadorLivros.core.adapters.api.review;

import com.deborateste.gerenciadorLivros.core.domain.ports.IBookReviewService;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.deborateste.gerenciadorLivros.exceptions.DadosInvalidosException;
import com.deborateste.gerenciadorLivros.core.domain.model.ReviewLivro;
import com.deborateste.gerenciadorLivros.core.domain.ports.IBookService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.Operation;

@RestController
public class ReviewLivroController {

	@Autowired
	private IBookReviewService service;

	@Autowired
	private IBookService serviceLivro;

	@GetMapping("/reviews")
	@Operation(summary = "Recupera reviews cadastradas", description = "Este endpoint retorna todos as reviews já cadastradas", security = @SecurityRequirement(name = "bearerAuth"))
	public ResponseEntity<?> getAll(@RequestParam Optional<Integer> livro) {
		try {
			if (livro.isPresent()) {
				if (!serviceLivro.thisExists(livro.get())) {
					System.out.println("entrou aqui");
					throw new DadosInvalidosException("Livro inexistente");
				}
				List<ReviewLivro> lista = service.getAllByLivroId(livro.get());
				return ResponseEntity.ok(lista);
			}

			List<ReviewLivro> res = service.getAll();
			if (res == null) {
				return ResponseEntity.ok("");
			}
			return ResponseEntity.ok(res);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@PostMapping("/reviews")
	@Operation(summary = "Cadastra Review", description = "Este endpoint cadastra uma review referente a algum livro", security = @SecurityRequirement(name = "bearerAuth"))
	public ResponseEntity<?> addOne(@RequestBody ReviewLivro rv) {
		try {
			ReviewLivro res = service.addOne(rv);
			if (res != null) {
				return ResponseEntity.status(201).body(res);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.badRequest().build();
	}

	@PutMapping("/reviews/{id}")
	@Operation(summary = "Edita Review", description = "Este endpoint edita uma review referente a algum livro", security = @SecurityRequirement(name = "bearerAuth"))
	public ResponseEntity<?> editOne(@PathVariable Integer id, @RequestBody ReviewLivro rv) {
		try {
			ReviewLivro res = service.editOne(id, rv);
			if (res != null) {
				return ResponseEntity.ok(res);
			}
			return ResponseEntity.notFound().build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().build();
		}
	}

	@DeleteMapping("/reviews/{id}")
	@Operation(summary = "Deletar Review", description = "Este endpoint deleta uma review referente a algum livro", security = @SecurityRequirement(name = "bearerAuth"))
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
