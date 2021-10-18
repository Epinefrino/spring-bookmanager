package com.gft.bookmanager.exception;

public class AssuntoNotFoundException extends RuntimeException{

	public AssuntoNotFoundException(Long id) {
		super("Assunto id: "+id+" não encontrado."); 
	}
}
