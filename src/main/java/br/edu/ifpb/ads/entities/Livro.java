package br.edu.ifpb.ads.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "TB_LIVROS")
public class Livro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotBlank
	private String titulo;

	@Column(nullable = false, unique = true)
	private String isbn;

	@Column(name = "ano_publicação", columnDefinition = "DATE")
	@Temporal(TemporalType.DATE)
	private LocalDate anoPublicacao;

	private String genero;

	@Column(nullable = false)
	private String editora;

	@Column(name = "numero_paginas")
	private int numeroPaginas;

	@Column(nullable = false)
	private double preco;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "livro_autores", joinColumns = @JoinColumn(name = "livro_id"), inverseJoinColumns = @JoinColumn(name = "autor_id"))
	private List<Autor> autores = new ArrayList<Autor>();

	public Livro() {

	}

	public Livro(String titulo, String isbn, LocalDate anoPublicacao, String genero, String editora,
			int numeroPaginas, double preco) {
		super();
		this.titulo = titulo;
		this.isbn = isbn;
		this.anoPublicacao = anoPublicacao;
		this.genero = genero;
		this.editora = editora;
		this.numeroPaginas = numeroPaginas;
		this.preco = preco;
	}

	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public LocalDate getAnoPublicacao() {
		return anoPublicacao;
	}

	public void setAnoPublicacao(LocalDate anoPublicacao) {
		this.anoPublicacao = anoPublicacao;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public int getNumeroPaginas() {
		return numeroPaginas;
	}

	public void setNumeroPaginas(int numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public List<Autor> getAutores() {
		return autores;
	}

	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}

	// Metodo para adicionar um autor a lista
	public void adicionarAutor(Autor autor) {
		autores.add(autor);
	}

	@Override
	public String toString() {
		return "Livro [titulo=" + titulo + ", ano publicacao=" + anoPublicacao + ", numero paginas=" + numeroPaginas
				+ ", preco=" + preco + ", autores=" + autores + "]";
	}

}
