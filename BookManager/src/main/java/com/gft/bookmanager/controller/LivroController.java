package com.gft.bookmanager.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gft.bookmanager.domain.Livro;
import com.gft.bookmanager.exception.LivroNotFoundException;
import com.gft.bookmanager.repository.LivroRepository;

@RestController
public class LivroController {
	private final LivroRepository repository;
	
	public LivroController(LivroRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping("/livros")
	List<Livro> all(){
		return repository.findAll();
	}
	
	@PostMapping("/livros")
	Livro novoLivro(@RequestBody Livro novoLivro) {
		return repository.save(novoLivro);
	}
	
	@GetMapping("/livros/{id}")
	Livro retornaUm(@PathVariable Long id) {
		return repository.findById(id).orElseThrow(() -> new LivroNotFoundException(id));
	}
	
	@PutMapping("/livros/{id}")
	Livro substituiLivro(@RequestBody Livro novoLivro, @PathVariable Long id) {
		return repository.findById(id).map(livro -> {
			livro.setTitulo(novoLivro.getTitulo());
			return repository.save(livro);
		}).orElseGet(() -> {
			novoLivro.setId(id);
			return repository.save(novoLivro);
		});
	}
	
	@DeleteMapping("/livros/{id}")
	void deletaLivro(@PathVariable Long id) {
		repository.deleteById(id);
	}

}
