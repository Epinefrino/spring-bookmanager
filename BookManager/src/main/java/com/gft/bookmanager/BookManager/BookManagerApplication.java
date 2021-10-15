package com.gft.bookmanager.BookManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.gft.bookmanager.domain.Autor;
import com.gft.bookmanager.repository.AutorRepository;

@SpringBootApplication
@EntityScan("com.gft.bookmanager.domain")
@EnableJpaRepositories("com.gft.bookmanager.repository")
public class BookManagerApplication {
	
	private static final Logger log = LoggerFactory.getLogger(BookManagerApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BookManagerApplication.class);
	}
	
	@Bean
	CommandLineRunner initDatabase(AutorRepository repository) {
		return args -> {
			log.info("Preloading "+repository.save(new Autor("Machete de Assis")));
			log.info("Preloading "+repository.save(new Autor("Orvalho de Cavalo")));
		};
	}

}
