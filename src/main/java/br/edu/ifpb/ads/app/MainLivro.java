package br.edu.ifpb.ads.app;

import java.math.BigDecimal;
import java.time.LocalDate;
import br.edu.ifpb.ads.dao.LivroDaoImpl;
import br.edu.ifpb.ads.entities.Autor;
import br.edu.ifpb.ads.entities.Livro;

public class MainLivro {

    public static void main(String[] args) {
        LivroDaoImpl livroDao = new LivroDaoImpl();
        Livro livro = null;
            
        // Criando e salvando um novo autor e livro
         try {
            livro = new Livro();
            livro.setTitulo("Aventuras Incríveis");
            livro.setAnoPublicacao(LocalDate.of(2005, 8, 28));
            livro.setNumeroPaginas(300);
            livro.setEditora("Chiado Editora");
            livro.setIsbn("ISBN-1");
            livro.setGenero("Ação");
            livro.setPreco(BigDecimal.valueOf(29.90));

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


            // Associando o autor ao livro
            livro.adicionarAutor(autorNovo);
            livro.adicionarAutor(outroAutor);

            livroDao.salvar(livro);

        } catch (Exception erro) {
            System.out.println(erro);
        } 

        
        /*  Pesquisando o livro pelo ID
        Livro livroPesquisado = livroDao.pesquisar(1);
        if (livroPesquisado != null) {
            System.out.println("Livro encontrado: " + livroPesquisado.getTitulo());

            // Obtendo os autores associados ao livro
            List<Autor> autoresDoLivro = livroPesquisado.getAutores();
            for (Autor autor : autoresDoLivro) {
                System.out.println("Autor do livro: " + autor.getNome());
            } 
        } else {
            System.out.println("Livro não encontrado!");
        }*/

        // Atualizando o livro
        //livroPesquisado.setTitulo("Novo Título Incrível");
        //livroDao.atualizar(livroPesquisado);

        // Deletando o livro
        //livroDao.deletar(livroPesquisado);
         
    }

}
