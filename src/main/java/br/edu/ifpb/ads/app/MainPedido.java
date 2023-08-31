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

        /*
        try {
        	Livro outroLivro = new Livro();
        	outroLivro.setTitulo("Novo Livro");
        	outroLivro.setAnoPublicacao(LocalDate.of(2005, 8, 28));
        	outroLivro.setNumeroPaginas(300);
        	outroLivro.setEditora("Teste Editora");
        	outroLivro.setIsbn("345356");
        	outroLivro.setGenero("Romance");
        	outroLivro.setPreco(BigDecimal.valueOf(10.40));
        	
        	
        	Autor autorNovo = new Autor();
            autorNovo.setNome("Matheus Silva");
            autorNovo.setDataNascimento(LocalDate.of(1998, 7, 17));
            autorNovo.setNacionalidade("Brasil");
            autorNovo.setBiografia("Professor de Psicologia...");
            autorNovo.setGeneroLiterario("Autoajuda");
            
            
        	
            //Salvar pedido
            Livro livro = livroDao.pesquisar(1);
            outroLivro.adicionarAutor(autorNovo);
            livroDao.salvar(outroLivro);
            Cliente cliente = clienteDao.pesquisar(1);

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
            Pedido pedido3 = new Pedido();
            pedido3.setCliente(cliente);
            pedido3.setDataConclusao(LocalDateTime.of(2023, 8, 29, 15, 30, 15));
            pedido3.setTotal(BigDecimal.ZERO);


            // Associar itens de pedido ao pedido
            itemPedido.setPedido(pedido3);
            itemPedido2.setPedido(pedido3);
            
            pedido3.setItens(itensPedido);

            // Calcular o total do pedido
            pedido3.calcularTotal();

            // Adicionar referencia do pedido ao cliente
            cliente.adicionarPedido(pedido3);
            
            // Persistir pedido
            pedidoDao.salvar(pedido3); 

        } catch (Exception erro) {
            System.out.println(erro);
        } */
        
        
         
        System.out.println("================ BUSCANDO UM PEDIDO =================");
        // Pesquisar pedido pelo ID
        Pedido pedidoPesquisado = pedidoDao.buscarPorId(1);
        System.out.println("Pedido encontrado: " + pedidoPesquisado.toString());


        System.out.println("================ ATUALIZANDO STATUS DE UM PEDIDO =================");
        //Atualizar status pedido
        pedidoPesquisado.setStatus(StatusPedido.FINALIZADO);
        pedidoDao.atualizar(pedidoPesquisado); 

    }
}
