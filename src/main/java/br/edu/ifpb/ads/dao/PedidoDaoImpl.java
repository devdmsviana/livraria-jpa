package br.edu.ifpb.ads.dao;

import java.util.List;

import br.edu.ifpb.ads.entities.ItemPedido;
import br.edu.ifpb.ads.entities.Pedido;
import br.edu.ifpb.ads.enums.StatusPedido;
import jakarta.persistence.EntityManager;

public class PedidoDaoImpl extends DAO {


	public void salvar(Pedido pedido) {

		EntityManager manager = getEntityManager();

		try {
			manager.getTransaction().begin();
	
			manager.persist(pedido);
	
			for (ItemPedido itemPedido : pedido.getItens()) {
				manager.merge(itemPedido);
			}
	
			manager.getTransaction().commit();
			System.out.println("Pedido salvo com sucesso!");
		} catch (Exception erro) {
			manager.getTransaction().rollback();
			System.out.println("Não foi possível salvar o pedido!");
			System.out.println(erro);
		} finally {
			manager.close();
		}
	}

	public List<Pedido> buscarTodos() {

		EntityManager manager = getEntityManager();
	
		List<Pedido> pedidos = null;
	
		try {
			pedidos = manager.createQuery("SELECT p FROM Pedido p", Pedido.class).getResultList();
		} catch (Exception erro) {
			System.out.println("Erro ao buscar pedidos!");
		} finally {
			manager.close();
		}
	
		return pedidos;
	}
	
	public Pedido buscarPorId(long id) {
	
		EntityManager manager = getEntityManager();
	
		Pedido pedido = null;
	
		try {
			pedido = manager.find(Pedido.class, id);
		} catch (Exception erro) {
			System.out.println("Erro ao buscar pedido por id!");
		} finally {
			manager.close();
		}
	
		return pedido;
	}
	
	public void atualizar(Pedido pedido) {
	
		EntityManager manager = getEntityManager();
		
	
		try {
			manager.getTransaction().begin();
	
			manager.merge(pedido);
	
			manager.getTransaction().commit();
			System.out.println("Pedido atualizado com sucesso!");
		} catch (Exception erro) {
			manager.getTransaction().rollback();
			System.out.println("Não foi possível atualizar o pedido!");
		} finally {
			manager.close();
		}
	}
	
	public void deletar(Pedido pedido) {
	
		EntityManager manager = getEntityManager();
	
		try {
			manager.getTransaction().begin();
	
			manager.remove(manager.find(Pedido.class, pedido.getId()));
	
			manager.getTransaction().commit();
			System.out.println("Pedido deletado com sucesso!");
		} catch (Exception erro) {
			manager.getTransaction().rollback();
			System.out.println("Não foi possível deletar o pedido!");
		} finally {
			manager.close();
		}
	}
}

