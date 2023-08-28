package br.edu.ifpb.ads.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
@DiscriminatorValue("cliente")
public class Cliente extends Pessoa {
    

    @Column(nullable = false, unique = true)
    private String email;

    @Column(unique = true, nullable = false)
	private String telefone;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_cliente", nullable = false)
    private Endereco endereco;

    public Cliente() {
    }

    public Cliente(String email, String telefone, Endereco endereco) {
        
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + getId() +
                ", nome='" + getNome() + '\'' +
                ", dataNascimento=" + getDataNascimento() +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", endereco=" + endereco +
                '}';
    }
}
