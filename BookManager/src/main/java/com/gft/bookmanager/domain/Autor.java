package com.gft.bookmanager.domain;

import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "autor")
public class Autor {
	
	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "autores")
	private List<Livro> livrosEscritos;
	
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
	
	public List<Livro> getLivrosEscritos() {
		return livrosEscritos;
	}

	public void setLivrosEscritos(List<Livro> livros) {
		this.livrosEscritos = livros;
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
	
	@PrePersist
	public void populaLivros() {
		if(this.livrosEscritos!=null) {
			for(Livro livro : this.livrosEscritos) {
				livro.getAutores().add(this);
			}
		}
	}
}
