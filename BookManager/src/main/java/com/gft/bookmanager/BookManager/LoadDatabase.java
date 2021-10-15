package com.gft.bookmanager.BookManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gft.bookmanager.domain.Autor;
import com.gft.bookmanager.repository.AutorRepository;

@Configuration
public class LoadDatabase {
	
	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
	
	@Autowired
	AutorRepository repository;
	
	@Bean
	CommandLineRunner initDatabase(AutorRepository repository) {
		return args -> {
			log.info("Preloading "+repository.save(new Autor("Machete de Assis")));
			log.info("Preloading "+repository.save(new Autor("Orvalho de Cavalo")));
		};
	}

}
