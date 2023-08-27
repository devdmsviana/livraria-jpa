package br.edu.ifpb.ads.dao;


import br.edu.ifpb.ads.entities.Autor;
import jakarta.persistence.EntityManager;

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

}
