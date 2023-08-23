package br.edu.ifpb.ads.app;

import java.time.LocalDate;

import br.edu.ifpb.ads.dao.ClienteDaoImpl;
import br.edu.ifpb.ads.entities.Cliente;
import br.edu.ifpb.ads.entities.Endereco;


public class MainCliente {

    public static void main(String[] args) {
        ClienteDaoImpl clienteDao = new ClienteDaoImpl();


        try {
            Endereco endereco = new Endereco(
                    "Rua dos bobos",
                    "Bairro dos bobos",
                    379,
                    "Estado dos bobos",
                    "12345678", "Cidade dos bobos",
                    "PB"
            );
            Cliente cliente = new Cliente("Diogo Marcelo", LocalDate.of(1998, 7, 17), "diogo@gmail.com", "83996586204", endereco);
            clienteDao.salvar(cliente);
        } catch (Exception erro) {
            System.out.println(erro);
        }
    }

}
