package com.gft.bookmanager.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "assunto")
public class Assunto {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String descricao;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "assuntos")
	private List<Livro> livros;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}
	
	@PrePersist
	public void populaLivros() {
		if(this.livros!=null) {
			for(Livro livro : this.livros) {
				livro.getAssuntos().add(this);
			}
		}
	}
	
	
}
