package com.gft.bookmanager.exception;

public class LivroNotFoundException extends RuntimeException{
	
	public LivroNotFoundException(Long id) {
		super("Livro id: "+id+" não encontrado."); 
	}
}
