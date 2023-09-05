package br.edu.ifpb.ads.app;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import br.edu.ifpb.ads.dao.AutorDaoImpl;
import br.edu.ifpb.ads.dao.LivroDaoImpl;
import br.edu.ifpb.ads.entities.Autor;
import br.edu.ifpb.ads.entities.Livro;

public class MainLivro {

    public static void main(String[] args) {
        LivroDaoImpl livroDao = new LivroDaoImpl();
        AutorDaoImpl autorDao = new AutorDaoImpl();
        Livro livroPesquisado = null;

        // Criando livro e associando ao autor
        System.out.println("=================== CADASTRANDO LIVRO ===================");
        try {
            Livro livro = new Livro();
            livro.setTitulo("Aventuras Incríveis");
            livro.setAnoPublicacao(LocalDate.of(2005, 8, 28));
            livro.setNumeroPaginas(300);
            livro.setEditora("Chiado Editora");
            livro.setIsbn("ISBN-1");
            livro.setGenero("Ação");
            livro.setPreco(BigDecimal.valueOf(29.90));

            Livro livro2 = new Livro();
            livro2.setTitulo("Preciso te contar um segredo");
            livro2.setAnoPublicacao(LocalDate.of(2005, 8, 28));
            livro2.setNumeroPaginas(300);
            livro2.setEditora("Chiado Editora");
            livro2.setIsbn("15454321");
            livro2.setGenero("Ficção");
            livro2.setPreco(BigDecimal.valueOf(29.90));


            // Associando o autor ao livro
            Autor autor = autorDao.pesquisar(2);
            livro.adicionarAutor(autor);
            livro2.adicionarAutor(autor);
            livroDao.salvar(livro);
            livroDao.salvar(livro2);
        } catch (Exception erro) {
            System.out.println(erro);
        }


        //Pesquisando o livro pelo ID
        /*
        try {
            livroPesquisado = livroDao.pesquisar(12);
            if (livroPesquisado != null) {
                System.out.println("Livro encontrado: " + livroPesquisado.getTitulo());

                // Obtendo os autores associados ao livro
                List<Autor> autoresDoLivro = livroPesquisado.getAutores();
                for (Autor autor : autoresDoLivro) {
                    System.out.println("Autor do livro: " + autor.getNome());
                }
            } else {
                System.out.println("Livro não encontrado!");
            }
        }catch (Exception erro) {
            System.out.println(erro);
        } */


        /* Atualizando o livro
        System.out.println("=================== ATUALIZANDO LIVRO ===================");
        try {
            livroPesquisado = livroDao.pesquisar(12);
            livroPesquisado.setTitulo("Novo Título Incrível");
            livroDao.atualizar(livroPesquisado);
        }catch (Exception erro) {
            System.out.println(erro);
        }

        // Deletando o livro
        System.out.println("=================== DELETANDO LIVRO ===================");
        try{
            livroPesquisado = livroDao.pesquisar(12);
            livroDao.deletar(livroPesquisado);
        }catch (Exception erro) {
            System.out.println(erro);
        }*/

    }
}