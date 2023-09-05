package br.edu.ifpb.ads.app;

import br.edu.ifpb.ads.dao.AutorDaoImpl;
import br.edu.ifpb.ads.entities.Autor;

import java.time.LocalDate;

public class MainAutor {

    public static void main(String[] args) {

        AutorDaoImpl autorDao = new AutorDaoImpl();


        System.out.println("=================== CADASTRANDO AUTOR ===================");
        try {
            Autor autor = new Autor();
            autor.setNome("Matheus S. Alves");
            autor.setDataNascimento(LocalDate.of(1998,7,13));
            autor.setBiografia("Psicóloco pela UFPB...");
            autor.setGeneroLiterario("Ficção");
            autor.setNacionalidade("Brasileiro");

            autorDao.salvar(autor);
        } catch (Exception erro) {
            System.out.println(erro);
        }
        /*
        System.out.println("=================== ATUALIZANDO AUTOR ===================");
        try {
            Autor autor = autorDao.pesquisar(5);
            autor.setNacionalidade("Britânico");
            autorDao.atualizar(autor);
        } catch (Exception erro) {
            System.out.println(erro);
        }


        System.out.println("=================== BUSCANDO AUTOR ===================");
        try {
            Autor autor = autorDao.pesquisar(5);
            System.out.println(autor.toString());
        } catch (Exception erro) {
            System.out.println(erro);
        }

        System.out.println("=================== BUSCANDO LIVROS DE UM AUTOR ===================");
        try {
            Autor autor = autorDao.pesquisar(5);
            System.out.println(autorDao.buscarLivrosPorAutor(autor));
        } catch (Exception erro) {
            System.out.println(erro);
        }


        System.out.println("=================== DELETANDO AUTOR ===================");
        try {
            Autor autor = autorDao.pesquisar(5);
            autorDao.deletar(autor);
        } catch (Exception erro) {
            System.out.println(erro);
        } */

    }
}
