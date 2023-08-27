package br.edu.ifpb.ads.dao;



import br.edu.ifpb.ads.entities.Livro;
import jakarta.persistence.EntityManager;

public class LivroDaoImpl extends DAO {

	public void salvar(Livro livro) {

		EntityManager manager = getEntityManager();

		try {
			manager.getTransaction().begin();
			manager.persist(livro);
			manager.getTransaction().commit();
			System.out.println("Livro salvo com sucesso!");
		} catch (Exception erro) {
			manager.getTransaction().rollback();
			System.out.println("Não foi possível salvar o livro!");
			System.out.println(erro);
		} finally {
			manager.close();
		}
	}

	public void atualizar(Livro livro) {

		EntityManager manager = getEntityManager();

		try {
			manager.getTransaction().begin();
			manager.merge(livro);
			manager.getTransaction().commit();
			System.out.println("Livro atualizado com sucesso!");
		} catch (Exception erro) {
			manager.getTransaction().rollback();
			System.out.println("Não foi possível atualizar o livro!");
		} finally {
			manager.close();
		}
	}

	public void deletar(Livro livro) {

		EntityManager manager = getEntityManager();

		try {
			manager.getTransaction().begin();
			manager.remove(manager.find(Livro.class, livro.getId()));
			manager.getTransaction().commit();
			System.out.println("Livro deletado com sucesso!");
		} catch (Exception erro) {
			manager.getTransaction().rollback();
			System.out.println("Não foi possível deletar o livro!");
		} finally {
			manager.close();
		}
	}

	public Livro pesquisar(long id) {

		EntityManager manager = getEntityManager();

		Livro livro = null;

		try {
			livro = manager.find(Livro.class, id);
		} catch (Exception erro) {
			System.out.println("Livro não encontrado!");
		} finally {
			manager.close();
		}

		return livro;

	}
}
