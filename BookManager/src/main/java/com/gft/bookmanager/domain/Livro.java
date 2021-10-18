package com.gft.bookmanager.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name = "livro")
public class Livro {
	
	@Id
	@GeneratedValue
	private Long id;
	
	String titulo;
	
	String editora;
	
	Integer edicao;
	
	String anoPublicacao;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "livro_autor", joinColumns = @JoinColumn(referencedColumnName = "id", name = "livro_id"),
	inverseJoinColumns = @JoinColumn(referencedColumnName = "id", name = "autor_id"))
	private List<Autor> autores;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "livro_assunto", joinColumns = @JoinColumn(referencedColumnName = "id", name = "livro_id"),
	inverseJoinColumns = @JoinColumn(referencedColumnName = "id", name = "assunto_id"))
	private List<Assunto> assuntos;
	
	protected Livro() {}
	
	public Livro(String titulo, String editora, Integer edicao, String anoP){
		this.titulo = titulo;
		this.editora = editora;
		this.edicao = edicao;
		this.anoPublicacao = anoP;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public Integer getEdicao() {
		return edicao;
	}

	public void setEdicao(Integer edicao) {
		this.edicao = edicao;
	}

	public String getAnoPublicacao() {
		return anoPublicacao;
	}

	public void setAnoPublicacao(String anoPublicacao) {
		this.anoPublicacao = anoPublicacao;
	}

	public List<Autor> getAutores() {
		return autores;
	}

	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Assunto> getAssuntos() {
		return assuntos;
	}

	public void setAssuntos(List<Assunto> assuntos) {
		this.assuntos = assuntos;
	}
	
	@PrePersist
	public void populaAutores() {
		if(this.autores!=null) {
			for(Autor autor : this.autores) {
				autor.getLivrosEscritos().add(this);
			}
		}
		populaAssuntos();
	}
	
	
	private void populaAssuntos() {
		if(this.assuntos!=null) {
			for(Assunto assunto : this.assuntos) {
				assunto.getLivros().add(this);
			}
		}
	}
	
}
