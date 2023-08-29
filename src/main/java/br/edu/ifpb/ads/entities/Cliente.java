package br.edu.ifpb.ads.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
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

    @OneToMany(mappedBy = "cliente")
    private List<Pedido> pedidos;

    public Cliente() {
        this.pedidos = new ArrayList<>();
    }

    public Cliente(String email, String telefone, Endereco endereco, List<Pedido> pedidos) {
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
        this.pedidos = pedidos != null ? pedidos : new ArrayList<Pedido>();
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

    public void adicionarPedido(Pedido pedido){
        this.pedidos.add(pedido);
    }

    public void removerPedido(Pedido pedido){
        this.pedidos.remove(pedido);
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
