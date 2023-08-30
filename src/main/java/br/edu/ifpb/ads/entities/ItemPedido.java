package br.edu.ifpb.ads.entities;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_ITENS_PEDIDO")
public class ItemPedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "pedido_id", nullable = false)
	private Pedido pedido;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "livro_id", nullable = false)
	private Livro livro;

	@Column(name = "preco_livro", nullable = false)
	private BigDecimal precoLivro;

	@Column(name = "quantidade", nullable = false)
	private Integer quantidade;

	public ItemPedido() {
	}

	public ItemPedido(Pedido pedido, Livro livro, BigDecimal precoLivro, Integer quantidade) {
		this.pedido = pedido;
		this.livro = livro;
		this.precoLivro = precoLivro;
		this.quantidade = quantidade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public BigDecimal getPrecoLivro() {
		return precoLivro;
	}

	public void setPrecoLivro(BigDecimal precoLivro) {
		this.precoLivro = precoLivro;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public String toString() {
		return "ItemPedido [id=" + id + ", pedido=" + pedido + ", livro=" + livro + ", precoLivro=" + precoLivro
				+ ", quantidade=" + quantidade + "]";
	}

}