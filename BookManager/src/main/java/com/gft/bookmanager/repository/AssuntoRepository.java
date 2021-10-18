package com.gft.bookmanager.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.gft.bookmanager.domain.Assunto;

public interface AssuntoRepository extends CrudRepository<Assunto, Long>{

	List<Assunto> findAll();
}
