package com.imcs.jdbc.service;

import javax.persistence.EntityManager;

import com.imcs.jdbc.entity.Customer;
import com.imcs.jdbc.util.JPAUtil;

public class CustomerDaoImpl implements CustomerDao{

	@Override
	public Customer addCustomer(Customer customer) {
		
		EntityManager entityManager = getEntityManager();
		try {
		entityManager.getTransaction().begin();
		entityManager.persist(customer);
		
		entityManager.getTransaction().commit();
		}
		finally {
			entityManager.close();
		}
		return customer;
		
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		EntityManager entityManager = getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.merge(customer);
		entityManager.getTransaction().commit();
		return customer;
	}

	@Override
	public boolean deleteCustomer(Long id) {
		EntityManager entityManager = getEntityManager();
		try {
		entityManager.getTransaction().begin();
		Customer customer = entityManager.find(Customer.class, id);
		entityManager.remove(customer);
		entityManager.getTransaction().commit();
		}
		finally {
			entityManager.close();
		}
		return true;
	}

	@Override
	public Customer getCustomer(Long id) {
		EntityManager entityManager = getEntityManager();
		try {
			entityManager.getTransaction().begin();
			Customer customer = entityManager.find(Customer.class, id);
			entityManager.getTransaction().commit();
			return customer;
		}
		finally {
			entityManager.close();
		}
		
	}
	
	private EntityManager getEntityManager()
	{
		return JPAUtil.getEntityManagerFactory().createEntityManager();
	}

}
