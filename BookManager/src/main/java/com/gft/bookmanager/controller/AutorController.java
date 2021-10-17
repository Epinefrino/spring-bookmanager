package com.gft.bookmanager.controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gft.bookmanager.domain.Autor;
import com.gft.bookmanager.domain.Livro;
import com.gft.bookmanager.exception.AutorNotFoundException;
import com.gft.bookmanager.exception.LivroNotFoundException;
import com.gft.bookmanager.repository.AutorRepository;
import com.gft.bookmanager.repository.LivroRepository;

@RestController
public class AutorController {
	private final AutorRepository repository;
	private final LivroRepository livroRepository;
	
	public AutorController(AutorRepository repository, LivroRepository livroRepository) {
		this.repository = repository;
		this.livroRepository = livroRepository;
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
	
	@GetMapping("/autores/nome/{nome}")
	Autor retornaUmPorNome(@PathVariable String nome) {
		return repository.findByNome(nome).orElseThrow(() -> new AutorNotFoundException(nome));
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
	
	@GetMapping("/autores/{id}/relaciona/{livroId}")
	Autor associa(@PathVariable Long id, @PathVariable Long livroId) {
		Autor a = repository.findById(id).orElseThrow(() -> new AutorNotFoundException(id));
		Livro l = livroRepository.findById(livroId).orElseThrow(() -> new LivroNotFoundException(livroId));
		List<Livro> lis = a.getLivrosEscritos();
		lis.add(l);
		a.setLivrosEscritos(lis);
		return repository.save(a);
	}
}
