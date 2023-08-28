package br.edu.ifpb.ads.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;

@Entity
@DiscriminatorValue("autor")
public class Autor extends Pessoa {	
	

	
	@Column(name = "biografia", nullable = false)
	private String biografia;	

	@Column(name = "nacionalidade", nullable = false)
	private String nacionalidade;
	
	@Column(name = "genero_literario", nullable = false)
	private String generoLiterario;
	
	@ManyToMany(mappedBy = "autores",cascade = CascadeType.ALL)
	private List<Livro> livros = new ArrayList<>();
	
	
	public Autor() {
		
	}

	
	public Autor(String biografia, String nacionalidade, String generoLiterario, List<Livro> livros) {
		this.biografia = biografia;
		this.nacionalidade = nacionalidade;
		this.generoLiterario = generoLiterario;
		this.livros = livros;
	}


	public String getBiografia() {
		return biografia;
	}

	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public String getGeneroLiterario() {
		return generoLiterario;
	}

	public void setGeneroLiterario(String generoLiterario) {
		this.generoLiterario = generoLiterario;
	}

	public List<Livro> getLivros() {
		return livros;
	}
	public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

	@Override
	public String toString() {
		return "Autor [id=" + getId() + ", nome=" + getNome() + ", dataNascimento=" + getDataNascimento() + ", biografia=" + biografia
				+ ", nacionalidade=" + nacionalidade + ", generoLiterario=" + generoLiterario + ", livros=" + livros
				+ "]";
	}
	
	

}
