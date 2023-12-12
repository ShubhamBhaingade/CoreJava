package com.cg.Garment.service;

import org.springframework.stereotype.Service;

import com.cg.Garment.entity.Customer;

@Service
public interface ICustomerService {
	
	public Customer registerNewcCustomer (Customer customer);
	
	
  
}
