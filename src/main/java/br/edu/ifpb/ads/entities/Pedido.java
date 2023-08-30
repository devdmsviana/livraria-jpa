package br.edu.ifpb.ads.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
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

    @OneToMany(mappedBy = "pedido")
    private List<ItemPedido> itens;
   

    @Column(name = "data_pedido", nullable = false)
    private LocalDateTime dataPedido;

    @Column(name = "data_conclusao")
    private LocalDateTime dataConclusao;

    @Column(name = "total")
    private BigDecimal total;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private StatusPedido status;



    public Pedido() {
        this.dataPedido = LocalDateTime.now();
        this.status = StatusPedido.PENDENTE;
    }

    public void calcularTotal(){
        if(itens != null){
            total = itens.stream().map( i -> new BigDecimal(i.getQuantidade()).multiply(i.getPrecoLivro()))
            .reduce(BigDecimal.ZERO, BigDecimal::add);
        }
    }


    public void alterarStatusPedido(String status){
        this.status = StatusPedido.valueOf(status);
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
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", cliente=" + cliente +
                ", itens=" + itens +
                ", dataPedido=" + dataPedido +
                ", dataConclusao=" + dataConclusao +
                ", total=" + total +
                ", status=" + status +
                '}';
    }
}
