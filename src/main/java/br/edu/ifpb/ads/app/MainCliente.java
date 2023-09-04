package br.edu.ifpb.ads.app;

import java.text.ParseException;
import java.time.LocalDate;

import br.edu.ifpb.ads.dao.ClienteDaoImpl;
import br.edu.ifpb.ads.entities.Cliente;
import br.edu.ifpb.ads.entities.Endereco;

public class MainCliente {

    public static void main(String[] args) throws ParseException {


        ClienteDaoImpl clienteDao = new ClienteDaoImpl();

        
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
        
        // Buscar pedidos de um cliente
        Cliente clientePesquisado = clienteDao.pesquisar(1);
        System.out.println(clienteDao.buscarPedidosPorCliente(clientePesquisado));
      
    }



}
