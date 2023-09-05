package br.edu.ifpb.ads.app;

import java.text.ParseException;
import java.time.LocalDate;

import br.edu.ifpb.ads.dao.ClienteDaoImpl;
import br.edu.ifpb.ads.dao.DAO;
import br.edu.ifpb.ads.entities.Cliente;
import br.edu.ifpb.ads.entities.Endereco;

public class MainCliente {

    public static void main(String[] args) throws ParseException {


        ClienteDaoImpl clienteDao = new ClienteDaoImpl();

        System.out.println("=================== CADASTRANDO CLIENTE ===================");
        try {
            // Criando endereco
            Endereco endereco = new Endereco(
                    "Rua dos bobos",
                    "Bairro dos bobos",
                    379,
                    "Estado dos bobos",
                    "12345678", "Cidade dos bobos",
                    "PB");

            // Criando cliente
            Cliente cliente = new Cliente();
            cliente.setNome("Diogo Silva");
            cliente.setDataNascimento(LocalDate.of(1998, 7, 17));
            cliente.setEndereco(endereco);
            cliente.setEmail("diogo.silva@gmail.com");
            cliente.setTelefone("81996586205");

            clienteDao.salvar(cliente);
        } catch (Exception erro) {
            System.out.println(erro);
        } 
        
        /* Buscar pedidos de um cliente
        System.out.println("=================== BUSCANDO PEDIDOS DE UM CLIENTE ===================");
        try {
            Cliente clientePesquisado = clienteDao.pesquisar(1);
            System.out.println(clienteDao.buscarPedidosPorCliente(clientePesquisado));
        } catch (Exception erro) {
            System.out.println(erro);
        }

        // Buscar um cliente
        System.out.println("=================== BUSCANDO UM CLIENTE ===================");
        try {
            Cliente clientePesquisado = clienteDao.pesquisar(1);
            System.out.println(clientePesquisado.toString());
        } catch (Exception erro) {
            System.out.println(erro);
        }

        // Atualizar um cliente
        System.out.println("=================== ATUALIZANDO UM CLIENTE ===================");
        try {
            Cliente clientePesquisado = clienteDao.pesquisar(1);
            clientePesquisado.setNome("Diogo Silva de Oliveira");
            clienteDao.atualizar(clientePesquisado);
        } catch (Exception erro) {
            System.out.println(erro);
        }


        /* Remover um cliente
        System.out.println("=================== REMOVENDO UM CLIENTE ===================");
        try {
            Cliente clientePesquisado = clienteDao.pesquisar(1);
            clienteDao.deletar(clientePesquisado);
        } catch (Exception erro) {
            System.out.println(erro);
        }*/
    }



}
