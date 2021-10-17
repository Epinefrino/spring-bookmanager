package com.gft.bookmanager.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.gft.bookmanager.domain.Assunto;
import com.gft.bookmanager.domain.Autor;
import com.gft.bookmanager.domain.Livro;

public interface LivroRepository extends CrudRepository<Livro, Long>{
	
	List<Livro> findAll();
	
	List<Livro> findByTitulo(String titulo);
	
	List<Livro> findByAutores(Autor autor);
	
	List<Livro> findByAssuntos(Assunto assunto);
}
