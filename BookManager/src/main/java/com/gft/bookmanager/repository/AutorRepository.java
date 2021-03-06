package com.gft.bookmanager.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.gft.bookmanager.domain.Autor;

public interface AutorRepository extends CrudRepository<Autor, Long> {
	Optional<Autor> findByNome(String nome);
	
	List<Autor> findAll();
	
	Optional<Autor> findById(Long id);
	
}
