package com.gft.bookmanager.exception;

public class AutorNotFoundException extends RuntimeException {
	
	public AutorNotFoundException(Long id) {
		super("Autor id: "+id+" não encontrado."); 
	}
}
