package br.edu.ifpb.ads.app;

import java.time.LocalDate;

import br.edu.ifpb.ads.dao.LivroDaoImpl;
import br.edu.ifpb.ads.entities.Autor;
import br.edu.ifpb.ads.entities.Livro;

public class MainLivro {

    public static void main(String[] args) {
        LivroDaoImpl livroDao = new LivroDaoImpl();
        Livro livroNovo = null;

        // Criando e salvando um novo autor e livro
        try {
            Autor autorNovo = new Autor();
            autorNovo.setNome("João Silva");
            autorNovo.setDataNascimento(LocalDate.of(1998, 7, 17));
            autorNovo.setNacionalidade("Brasil");
            autorNovo.setBiografia("Professor de Literatura...");
            autorNovo.setGeneroLiterario("Contos");

            Autor outroAutor = new Autor();
            outroAutor.setNome("Maria Souza");
            outroAutor.setDataNascimento(LocalDate.of(1990, 3, 12));
            outroAutor.setNacionalidade("Brasil");
            outroAutor.setBiografia("Professora de sociologia...");
            outroAutor.setGeneroLiterario("Romance");

            // Criando e salvando um novo livro
            livroNovo = new Livro();
            livroNovo.setTitulo("Aventuras Incríveis");
            livroNovo.setAnoPublicacao(LocalDate.of(2005, 8, 28));
            livroNovo.setNumeroPaginas(300);
            livroNovo.setEditora("Chiado Editora");
            livroNovo.setIsbn("ISBN-1");
            livroNovo.setGenero("Ação");
            livroNovo.setPreco(49.99);

            // Associando o autor ao livro
            livroNovo.adicionarAutor(autorNovo);
            livroNovo.adicionarAutor(outroAutor);

            livroDao.salvar(livroNovo);

        } catch (Exception erro) {
            System.out.println(erro);
        }

        /*
        // Pesquisando o livro pelo ID
        Livro livroPesquisado = livroDao.pesquisar(livroNovo.getId());
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

        // Atualizando o livro
        livroPesquisado.setTitulo("Novo Título Incrível");
        livroDao.atualizar(livroPesquisado);

        // Deletando o livro
        livroDao.deletar(livroPesquisado);
         */
    }

}
