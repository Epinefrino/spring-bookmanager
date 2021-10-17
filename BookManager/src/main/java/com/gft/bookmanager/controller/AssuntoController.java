package com.gft.bookmanager.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gft.bookmanager.domain.Assunto;
import com.gft.bookmanager.domain.Livro;
import com.gft.bookmanager.exception.AssuntoNotFoundException;
import com.gft.bookmanager.exception.LivroNotFoundException;
import com.gft.bookmanager.repository.AssuntoRepository;
import com.gft.bookmanager.repository.LivroRepository;

@RestController
public class AssuntoController {
	
	private final AssuntoRepository repository;
	
	public AssuntoController(AssuntoRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping("/assuntos")
	List<Assunto> all(){
		return repository.findAll();
	}
	
	@PostMapping("/assuntos")
	Assunto novoAssunto(@RequestBody Assunto novoAssunto) {
		return repository.save(novoAssunto);
	}
	
	@GetMapping("/assuntos/{id}")
	Assunto retornaUm(@PathVariable Long id) {
		return repository.findById(id).orElseThrow(() -> new AssuntoNotFoundException(id));
	}
	
	@PutMapping("/assuntos/{id}")
	Assunto substituiLivro(@RequestBody Assunto novoAssunto, @PathVariable Long id) {
		return repository.findById(id).map(assunto -> {
			assunto.setDescricao(novoAssunto.getDescricao());
			return repository.save(assunto);
		}).orElseGet(() -> {
			novoAssunto.setId(id);
			return repository.save(novoAssunto);
		});
	}
	
	@DeleteMapping("/assuntos/{id}")
	void deletaLivro(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
