package br.edu.ifpb.ads.app;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifpb.ads.dao.ClienteDaoImpl;
import br.edu.ifpb.ads.dao.LivroDaoImpl;
import br.edu.ifpb.ads.dao.PedidoDaoImpl;
import br.edu.ifpb.ads.entities.Cliente;
import br.edu.ifpb.ads.entities.ItemPedido;
import br.edu.ifpb.ads.entities.Livro;
import br.edu.ifpb.ads.entities.Pedido;

public class MainPedido {

    public static void main(String[] args) {

        PedidoDaoImpl pedidoDao = new PedidoDaoImpl();
        ClienteDaoImpl clienteDao = new ClienteDaoImpl();
        LivroDaoImpl livroDao = new LivroDaoImpl();

        try {
            Livro livro = livroDao.pesquisar(1);
            Cliente cliente = clienteDao.pesquisar(1);

            ItemPedido itemPedido = new ItemPedido();
            itemPedido.setLivro(livro);
            itemPedido.setPrecoLivro(livro.getPreco());
            itemPedido.setQuantidade(10);

            List<ItemPedido> itensPedido = new ArrayList<>();
            itensPedido.add(itemPedido);

            
            //  Criar pedido e associar cliente
            Pedido pedido = new Pedido();
            pedido.setCliente(cliente);
            pedido.setDataConclusao(LocalDateTime.of(2023, 8, 29, 15, 30, 15));
            pedido.setTotal(BigDecimal.ZERO);


            // Associar itens de pedido ao pedido
            itemPedido.setPedido(pedido);
            pedido.setItens(itensPedido);

            // Calcular o total do pedido
            pedido.calcularTotal();

            // Persistir pedido
            pedidoDao.salvar(pedido); 

            // Adicionar referencia do pedido ao cliente
            cliente.adicionarPedido(pedido);
        } catch (Exception erro) {
            System.out.println(erro);
        }
    }
}
