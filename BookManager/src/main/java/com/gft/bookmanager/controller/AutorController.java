package com.gft.bookmanager.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gft.bookmanager.domain.Autor;
import com.gft.bookmanager.exception.AutorNotFoundException;
import com.gft.bookmanager.repository.AutorRepository;

@RestController
public class AutorController {
	private final AutorRepository repository;
	
	public AutorController(AutorRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping("/autores")
	List<Autor> all(){
		return repository.findAll();
	}
	
	@PostMapping("/autores")
	Autor novoAutor(@RequestBody Autor novoAutor) {
		return repository.save(novoAutor);
	}
	
	@GetMapping("/autores/{id}")
	Autor retornaUm(@PathVariable Long id) {
		return repository.findById(id).orElseThrow(() -> new AutorNotFoundException(id));
	}
	
	@PutMapping("/autores/{id}")
	Autor substituiAutor(@RequestBody Autor novoAutor, @PathVariable Long id) {
		return repository.findById(id).map(autor -> {
			autor.setNome(novoAutor.getNome());
			return repository.save(autor);
		}).orElseGet(() -> {
			novoAutor.setId(id);
			return repository.save(novoAutor);
		});
	}
	
	@DeleteMapping("/autores/{id}")
	void deletaAutor(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
