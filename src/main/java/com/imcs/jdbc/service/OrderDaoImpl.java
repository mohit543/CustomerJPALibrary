package com.imcs.jdbc.service;

import javax.persistence.Entity;
import javax.persistence.EntityManager;

import com.imcs.jdbc.entity.Order;
import com.imcs.jdbc.util.JPAUtil;

public class OrderDaoImpl implements OrderDao {

	@Override
	public Order addOrder(Order ord) {
		EntityManager entityManager = getEntityManager();
		
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(ord);
			entityManager.getTransaction().commit();
		}
		finally {
			entityManager.close();
		}
		return ord;
		
	}

	@Override
	public boolean deleteOrder(Long id) {
		
		EntityManager entityManager = getEntityManager();
		
		try {
			entityManager.getTransaction().begin();
			Order ord = entityManager.find(Order.class, id);
			entityManager.remove(ord);
			entityManager.getTransaction().commit();
		}
		finally {
			entityManager.close();
		}
		return true;
		
	}

	@Override
	public Order getOrder(Long id) {
		EntityManager entityManager = getEntityManager();
		try {
			entityManager.getTransaction().begin();
			Order ord = entityManager.find(Order.class, id);
			entityManager.getTransaction().commit();
			return ord;
		}
		finally {
			entityManager.close();
		}
		
	}

	@Override
	public Order updateOrder(Order ord) {
		EntityManager entityManager = getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.merge(ord);
		entityManager.getTransaction().commit();
		return ord;
	}
	
	private EntityManager getEntityManager()
	{
		return JPAUtil.getEntityManagerFactory().createEntityManager();
	}

}


