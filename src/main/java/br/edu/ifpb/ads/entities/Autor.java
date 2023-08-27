package br.edu.ifpb.ads.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "TB_AUTOR")
public class Autor implements Serializable {	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank
	private String nome;
	
	@Column(name = "data_nascimento", columnDefinition = "DATE", nullable = true)
	private Date data_nascimento;
	
	@Column(name = "Biografia")
	private String biografia;	

	@Column(name = "Nacionalidade")
	private String nacionalidade;
	
	@Column(name = "Genero_literario")
	private String genero_literario;
	
	@ManyToMany(mappedBy = "autores",cascade = CascadeType.ALL)
	private List<Livro>livros = new ArrayList<>();
	
	
	public Autor() {
		
	}

	public Autor(String nome,String nacionalidade,Date data_nascimento) {		
		this.nome = nome;
		this.data_nascimento = data_nascimento;		
		this.nacionalidade = nacionalidade;		
	}
	
	public long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return data_nascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.data_nascimento = dataNascimento;
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

	public String getGenero_literario() {
		return genero_literario;
	}

	public void setGeneroLiterario(String genero_literario) {
		this.genero_literario = genero_literario;
	}

	public List<Livro> getLivros() {
		return livros;
	}
	public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }	

}
