package com.imcs.jdbc.app;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.imcs.jdbc.entity.Customer;
import com.imcs.jdbc.entity.Order;
import com.imcs.jdbc.entity.OrderLineItem;
import com.imcs.jdbc.service.OrderDao;
import com.imcs.jdbc.service.OrderDaoImpl;

public class OrderApp {
	OrderDao orderDao = new OrderDaoImpl();
	public static void main(String[] args) {
		OrderApp app = new OrderApp();
		//app.addOrder();
		//app.deleteOrder(4L);
		//app.updateOrder();
		app.getOrder();
		

	}
	private void addOrder()
	{
		Customer customer = new Customer(1L, "Anil", 10000.00, 2, "9541236211", null);
		Order order = new Order(null,LocalDate.now() , LocalDate.of(2018, 10, 28),LocalDate.of(2018, 10, 18) ,"In Process", "Ready t Order", null, null);
		order.setCustomer(customer);
		
		OrderLineItem orderLineItem = new OrderLineItem(null, 101, "Description", "Product Description", 10, 20.00, null);
		orderLineItem.setOrder(order);
		List<OrderLineItem>oli = new ArrayList<OrderLineItem>();
		oli.add(orderLineItem);
		order.setProducts(oli);
		orderDao.addOrder(order);
		
	}
	private void deleteOrder(Long id)
	{
		orderDao.deleteOrder(id);
		
	}
	private void updateOrder()
	{
		Order order = new Order(6L,LocalDate.now() , LocalDate.of(2018, 10, 30),LocalDate.of(2018, 10, 18) ,"In Process", "Ready t Order", null, null);
		Customer customer = new Customer(1L, "Anil", 10000.00, 2, "9541236211", null);
		order.setCustomer(customer);
		orderDao.updateOrder(order);
		
	}
	private void getOrder()
	{
		System.out.println(orderDao.getOrder(6L).getOrderID());
	}

}
