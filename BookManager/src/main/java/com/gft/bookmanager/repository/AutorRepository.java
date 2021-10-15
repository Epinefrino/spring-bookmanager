package com.gft.bookmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gft.bookmanager.domain.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long> {
	
}
