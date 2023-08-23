package br.edu.ifpb.ads.dao;

import br.edu.ifpb.ads.entities.Cliente;
import jakarta.persistence.EntityManager;

public class ClienteDaoImpl extends DAO {

    public void salvar(Cliente cliente) {
		
		EntityManager manager = getEntityManager();
		
		try {
			manager.getTransaction().begin();      
			manager.persist(cliente);
			manager.getTransaction().commit();
			System.out.println("Cliente salvo com sucesso!");
		} catch(Exception erro) {
			manager.getTransaction().rollback();
			System.out.println("Não foi possível salvar o cliente!");
			System.out.println(erro);
		} finally {
			manager.close();
		}
	}
	
	public void atualizar(Cliente cliente) {
		
		EntityManager manager = getEntityManager();
		
		try {
			manager.getTransaction().begin();
			manager.merge(cliente);
			manager.getTransaction().commit();
			System.out.println("Cliente atualizado com sucesso!");
		} catch(Exception erro) {
			manager.getTransaction().rollback();
			System.out.println("Não foi possível atualizar o cliente!");
		} finally {
			manager.close();
		}
	}

	public void deletar(Cliente cliente) {
		
		EntityManager manager = getEntityManager();
		
		try {
			manager.getTransaction().begin();
			manager.remove(manager.find(Cliente.class, cliente.getEmail()));
			manager.getTransaction().commit();
			System.out.println("Cliente deletado com sucesso!");
		} catch(Exception erro) {
			manager.getTransaction().rollback();
			System.out.println("Não foi possível deletar o cliente!");
		} finally {
			manager.close();
		}	
	}
	
	public Cliente pesquisar(String email) {
		
		EntityManager manager = getEntityManager();
		
		Cliente cliente = null;
		
		try {
			cliente = manager.find(Cliente.class, email);
		} catch(Exception erro) {
			System.out.println("Cliente não encontrado!");
		} finally {
			manager.close();
		}
		
		return cliente;
	}
    
}
