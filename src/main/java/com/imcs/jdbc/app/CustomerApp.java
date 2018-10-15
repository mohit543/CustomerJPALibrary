package com.imcs.jdbc.app;

import com.imcs.jdbc.entity.Address;
import com.imcs.jdbc.entity.Customer;
import com.imcs.jdbc.entity.State;
import com.imcs.jdbc.entity.ZipCode;
import com.imcs.jdbc.service.CustomerDao;
import com.imcs.jdbc.service.CustomerDaoImpl;

public class CustomerApp {
	CustomerDao customerDao = new CustomerDaoImpl();

	public static void main(String[] args) {

		CustomerApp app = new CustomerApp();
		app.addCustomer();
		//app.deleteCustomer(1L);
		app.updateCustomer();
		//app.getCustomer();

	}

	private void addCustomer() {
		Customer customer = new Customer(null, "Mohit", 5000.00, 2, "9541236521", null);
		Address address = new Address("2000", "xyz street", "Irving", null, null, "United States");
		address.setState(State.AR);
		address.setPostalCode(new ZipCode("75039"));
		customer.setAddress(address);

		customerDao.addCustomer(customer);
	}

	private void deleteCustomer(long id) {
		customerDao.deleteCustomer(id);
	}

	private void updateCustomer() {
		Customer customer = new Customer(1L, "Anil", 10000.00, 2, "9541236211", null);
		customerDao.updateCustomer(customer);
	}

	private void getCustomer() {
		System.out.println(customerDao.getCustomer(1L).getCustomerName());

	}
}
