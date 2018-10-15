package com.imcs.jdbc.service;

import com.imcs.jdbc.entity.Order;

public interface OrderDao {
	
	Order addOrder(Order o);
	
	boolean deleteOrder(Long id);
	
	Order getOrder(Long id);
	
	Order updateOrder(Order o);
	
	

}
