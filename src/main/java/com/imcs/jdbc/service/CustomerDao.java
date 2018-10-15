package com.imcs.jdbc.service;

import com.imcs.jdbc.entity.Customer;

public interface CustomerDao {
	
	Customer addCustomer(Customer customer);
	
	Customer updateCustomer(Customer customer);
	
	boolean deleteCustomer(Long id);
	
	Customer getCustomer(Long id);

}
