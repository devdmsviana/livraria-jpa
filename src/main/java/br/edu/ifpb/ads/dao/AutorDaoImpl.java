package br.edu.ifpb.ads.dao;


import br.edu.ifpb.ads.entities.Autor;
import br.edu.ifpb.ads.entities.Livro;
import jakarta.persistence.EntityManager;

import java.util.List;

public class AutorDaoImpl extends DAO {

	public void salvar(Autor autor) {

		EntityManager manager = getEntityManager();

		try {
			manager.getTransaction().begin();
			manager.persist(autor);
			manager.getTransaction().commit();
			System.out.println("Autor salvo com sucesso!");
		} catch (Exception erro) {
			manager.getTransaction().rollback();
			System.out.println("Não foi possível salvar o autor!");
			System.out.println(erro);
		} finally {
			manager.close();
		}
	}

	public void atualizar(Autor autor) {

		EntityManager manager = getEntityManager();

		try {
			manager.getTransaction().begin();
			manager.merge(autor);
			manager.getTransaction().commit();
			System.out.println("Autor atualizado com sucesso!");
		} catch (Exception erro) {
			manager.getTransaction().rollback();
			System.out.println("Não foi possível atualizar o autor!");
		} finally {
			manager.close();
		}
	}

	public void deletar(Autor autor) {

		EntityManager manager = getEntityManager();

		try {
			manager.getTransaction().begin();
			manager.remove(manager.find(Autor.class, autor.getId()));
			manager.getTransaction().commit();
			System.out.println("Autor deletado com sucesso!");
		} catch (Exception erro) {
			manager.getTransaction().rollback();
			System.out.println("Não foi possível deletar o Autor!");
		} finally {
			manager.close();
		}
	}

	public Autor pesquisar(long id) {

		EntityManager manager = getEntityManager();

		Autor autor = null;

		try {
			autor = manager.find(Autor.class, id);
		} catch (Exception erro) {
			System.out.println("Autor não encontrado!");
		} finally {
			manager.close();
		}

		return autor;
	}

	public List<Livro> buscarLivrosPorAutor(Autor autor) {

		EntityManager manager = getEntityManager();

		List<Livro> livros = null;

		try {
			livros = manager.createQuery("SELECT l FROM Livro l JOIN l.autores a WHERE a.id = :id")
					.setParameter("id", autor.getId())
					.getResultList();
		} catch (Exception erro) {
			System.out.println("Não foi possível buscar os livros do autor!");
		} finally {
			manager.close();
		}

		return livros;
	}

}
