package com.gft.bookmanager.domain;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Autor {
	
	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	
	protected Autor() {}
	
	public Autor(String nome){
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o)
			return true;
		if(!(o instanceof Autor))
			return false;
		Autor autor = (Autor) o;
		return Objects.equals(this.id, autor.id) && Objects.equals(this.nome, autor.nome);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.id, this.nome);
	}
	
	@Override
	public String toString() {
		return "Autor{"+"id="+this.id+", nome='"+this.nome+'\''+'}';
	}
}
