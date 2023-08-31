package br.edu.ifpb.ads.dao;

import java.util.List;

import br.edu.ifpb.ads.entities.Cliente;
import br.edu.ifpb.ads.entities.Pedido;
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
			manager.remove(manager.find(Cliente.class, cliente.getId()));
			manager.getTransaction().commit();
			System.out.println("Cliente deletado com sucesso!");
		} catch(Exception erro) {
			manager.getTransaction().rollback();
			System.out.println("Não foi possível deletar o cliente!");
		} finally {
			manager.close();
		}	
	}
	
	public Cliente pesquisar(long id) {
		
		EntityManager manager = getEntityManager();
		
		Cliente cliente = null;
		
		try {
			cliente = manager.find(Cliente.class, id);
		} catch(Exception erro) {
			System.out.println("Cliente não encontrado!");
		} finally {
			manager.close();
		}
		
		return cliente;
	}
	
	public List<Pedido> buscarPedidosPorCliente(Cliente cliente) {
	    EntityManager manager = getEntityManager();

	    try {
	        String jpql = "SELECT p FROM Pedido p WHERE p.cliente = :cliente";
	        return manager.createQuery(jpql, Pedido.class)
	                      .setParameter("cliente", cliente)
	                      .getResultList();
	    } finally {
	        manager.close();
	    }
	}

    
}
