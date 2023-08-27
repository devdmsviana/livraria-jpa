package br.edu.ifpb.ads.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "livros")
public class Livro implements Serializable {
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
    @NotBlank
	private String titulo;
	
    private String ISBN;
    
    @Column(name = "ano_publicação")
    private int ano_publicacao;
    
    private String genero;
    
    private String editora;
    
    @Column(name = "numero_paginas")
    private int numero_paginas;
    
    private double preco;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "livro_autores",
        joinColumns = @JoinColumn(name = "livro_id"),
        inverseJoinColumns = @JoinColumn(name = "autor_id"))      
    private List<Autor> autores = new ArrayList<Autor>();

	public Livro() {
		
	}
	
    public Livro(@NotBlank String titulo, int ano_publicacao, int numero_paginas, double preco) {
		this.titulo = titulo;
		this.ano_publicacao = ano_publicacao;
		this.numero_paginas = numero_paginas;
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

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public int getAno_publicacao() {
		return ano_publicacao;
	}

	public void setAno_publicacao(int ano_publicacao) {
		this.ano_publicacao = ano_publicacao;
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

	public int getNumero_paginas() {
		return numero_paginas;
	}

	public void setNumero_paginas(int numero_paginas) {
		this.numero_paginas = numero_paginas;
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
    
	//Metodo para adicionar um autor a lista 
	public void adicionarAutor(Autor autor) {
        autores.add(autor);
    }

	@Override
	public String toString() {
		return "Livro [titulo=" + titulo + ", ano_publicacao=" + ano_publicacao + ", numero_paginas=" + numero_paginas
				+ ", preco=" + preco + ", autores=" + autores + "]";
	}

	
}
