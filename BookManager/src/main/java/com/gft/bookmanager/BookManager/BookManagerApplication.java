package com.gft.bookmanager.BookManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.gft.bookmanager.domain.Assunto;
import com.gft.bookmanager.domain.Autor;
import com.gft.bookmanager.domain.Livro;
import com.gft.bookmanager.repository.AssuntoRepository;
import com.gft.bookmanager.repository.AutorRepository;
import com.gft.bookmanager.repository.LivroRepository;

@SpringBootApplication
@ComponentScan({"com.gft.bookmanager.controller"})
@ComponentScan({"com.gft.bookmanager.exception"})
@EntityScan("com.gft.bookmanager.domain")
@EnableJpaRepositories("com.gft.bookmanager.repository")
public class BookManagerApplication {
	
	private static final Logger log = LoggerFactory.getLogger(BookManagerApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BookManagerApplication.class);
	}
	
	@Bean
	CommandLineRunner initDatabase(AutorRepository repository, LivroRepository livrorepo, AssuntoRepository assuntorepo) {
		return args -> {
			log.info("Preloading "+repository.save(new Autor("Machete de Assis")));
			log.info("Preloading "+repository.save(new Autor("Orvalho de Cavalo")));
			log.info("Preloading "+livrorepo.save(new Livro("O Monte de Conde Cristo", "Buena", 1, "2020")));
			log.info("Preloading "+livrorepo.save(new Livro("Varios Carpos Quaresma", "Quadrante", 2, "1995")));
			log.info("Preloading "+assuntorepo.save(new Assunto("Ocultismo")));
			log.info("Preloading "+assuntorepo.save(new Assunto("Literatura Brasileira")));
		};
	}

}
