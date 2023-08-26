package br.edu.ifpb.ads.entities;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	
	@Column(name = "data_nascimento", columnDefinition = "DATE", nullable = false)
	private Date data_nascimento;
	
	@Column(name = "Biografia")
	private String biografia;
	
	@Column(name = "Nacionalidade")
	private String nacionalidade;
	
	@Column(name = "Genero_literario")
	private String genero_literario;
	
	public Autor() {
		
	}

	public Autor(String nome, Date data_nascimento, String biografia, String nacionalidade, String genero_literario) {		
		this.nome = nome;
		this.data_nascimento = data_nascimento;
		this.biografia = biografia;
		this.nacionalidade = nacionalidade;
		this.genero_literario = genero_literario;
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
	
	

}
