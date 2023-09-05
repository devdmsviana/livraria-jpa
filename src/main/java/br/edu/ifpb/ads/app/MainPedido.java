package br.edu.ifpb.ads.app;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifpb.ads.dao.ClienteDaoImpl;
import br.edu.ifpb.ads.dao.LivroDaoImpl;
import br.edu.ifpb.ads.dao.PedidoDaoImpl;
import br.edu.ifpb.ads.entities.Autor;
import br.edu.ifpb.ads.entities.Cliente;
import br.edu.ifpb.ads.entities.ItemPedido;
import br.edu.ifpb.ads.entities.Livro;
import br.edu.ifpb.ads.entities.Pedido;
import br.edu.ifpb.ads.enums.StatusPedido;

public class MainPedido {

    public static void main(String[] args) {

        PedidoDaoImpl pedidoDao = new PedidoDaoImpl();
        ClienteDaoImpl clienteDao = new ClienteDaoImpl();
        LivroDaoImpl livroDao = new LivroDaoImpl();


        System.out.println("================ SALVANDO UM PEDIDO =================");
        try {
            //Salvar pedido
            Cliente cliente = clienteDao.pesquisar(1);
            Livro livro = livroDao.pesquisar(1);
            Livro outroLivro = livroDao.pesquisar(2);

            ItemPedido itemPedido = new ItemPedido();
            itemPedido.setLivro(livro);
            itemPedido.setPrecoLivro(livro.getPreco());
            itemPedido.setQuantidade(10);
            
            ItemPedido itemPedido2 = new ItemPedido();
            itemPedido2.setLivro(outroLivro);
            itemPedido2.setPrecoLivro(outroLivro.getPreco());
            itemPedido2.setQuantidade(5);

            List<ItemPedido> itensPedido = new ArrayList<>();
            itensPedido.add(itemPedido);
            itensPedido.add(itemPedido2);

            
            //  Criar pedido e associar cliente
            Pedido pedido = new Pedido();
            pedido.setCliente(cliente);
            pedido.setTotal(BigDecimal.ZERO);


            // Associar itens de pedido ao pedido
            itemPedido.setPedido(pedido);
            itemPedido2.setPedido(pedido);
            
            pedido.setItens(itensPedido);

            // Calcular o total do pedido
            pedido.calcularTotal();

            // Adicionar referencia do pedido ao cliente
            cliente.adicionarPedido(pedido);
            
            // Persistir pedido
            pedidoDao.salvar(pedido);

        } catch (Exception erro) {
            System.out.println(erro);
        }


        // Pesquisar pedido pelo ID
        Pedido pedidoPesquisado = null;
        System.out.println("================ BUSCANDO UM PEDIDO =================");
        try {
            pedidoPesquisado = pedidoDao.buscarPorId(1);
            System.out.println("Pedido encontrado: " + pedidoPesquisado.toString());
        } catch (Exception ex){
            System.out.println(ex);
        }


        //Atualizar status pedido
        System.out.println("================ ATUALIZANDO STATUS DE UM PEDIDO =================");
        try {
            pedidoPesquisado.setStatus(StatusPedido.FINALIZADO);
            pedidoDao.atualizar(pedidoPesquisado);
            System.out.println("Pedido atualizado: " + pedidoPesquisado.toString());
        } catch (Exception ex){
            System.out.println(ex);
        }

        System.out.println("================ BUSCANDO TODOS OS PEDIDOS =================");
        try {
            List<Pedido> pedidos = pedidoDao.buscarTodos();
            for (Pedido pedido : pedidos) {
                System.out.println(pedido.toString());
            }
        } catch (Exception ex){
            System.out.println(ex);
        }

        System.out.println("================ DELETAR PEDIDO =================");
        try {
            Pedido pedido = pedidoDao.buscarPorId(1);
            pedidoDao.deletar(pedido);
        } catch (Exception ex){
            System.out.println(ex);
        }


    }
}
