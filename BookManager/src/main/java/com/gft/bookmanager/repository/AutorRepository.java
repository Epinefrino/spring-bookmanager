package com.gft.bookmanager.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.gft.bookmanager.domain.Autor;

public interface AutorRepository extends CrudRepository<Autor, Long> {
	List<Autor> findByNome(String nome);
	
	Optional<Autor> findById(Long id);
	
}
