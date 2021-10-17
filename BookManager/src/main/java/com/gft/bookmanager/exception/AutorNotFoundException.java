package com.gft.bookmanager.exception;

public class AutorNotFoundException extends RuntimeException {
	
	public AutorNotFoundException(Long id) {
		super("Autor id: "+id+" não encontrado."); 
	}
	
	public AutorNotFoundException(String nome) {
		super("Autor : "+nome+" não encontrado."); 
	}
}
