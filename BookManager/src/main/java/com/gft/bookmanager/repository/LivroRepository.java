package com.gft.bookmanager.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.gft.bookmanager.domain.Livro;

public interface LivroRepository extends CrudRepository<Livro, Long>{
	
	List<Livro> findAll();
	
	List<Livro> findByTitulo(String titulo);
}
