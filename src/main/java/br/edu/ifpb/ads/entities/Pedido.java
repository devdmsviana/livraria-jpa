package br.edu.ifpb.ads.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import br.edu.ifpb.ads.enums.StatusPedido;
import jakarta.persistence.*;

@Entity
@Table(name = "TB_PEDIDO")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<ItemPedido> itens;

    @Column(name = "data_pedido", nullable = false)
    private LocalDateTime dataPedido;

    @Column(name = "data_conclusao")
    private LocalDateTime dataConclusao;

    @Column(name = "total")
    private BigDecimal total;

    @Column(name = "status_pedido", nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusPedido status;

    public Pedido() {
        this.dataPedido = LocalDateTime.now();
        this.status = StatusPedido.AGUARDANDO_PAGAMENTO;
    }

    public void calcularTotal() {
        if (itens != null) {
            total = itens.stream().map(i -> new BigDecimal(i.getQuantidade()).multiply(i.getPrecoLivro()))
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
        }
    }

    public Pedido(Cliente cliente, List<ItemPedido> itens, LocalDateTime dataConclusao,
            BigDecimal total) {
        this.cliente = cliente;
        this.itens = itens;
        this.dataPedido = LocalDateTime.now();
        this.dataConclusao = dataConclusao;
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }

    public LocalDateTime getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDateTime dataPedido) {
        this.dataPedido = dataPedido;
    }

    public LocalDateTime getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(LocalDateTime dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
        if(status.getDescricao().equalsIgnoreCase("Finalizado")) {
        	this.setDataConclusao(LocalDateTime.now());
        }
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", cliente=" + cliente.getNome() + 
                ", total=" + total +
                ", status=" + status +
                ", quantidadePedidos=" + (itens != null ? itens.size() : 0) +
                '}';
    }
}
