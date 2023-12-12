package com.cg.Garment.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.Garment.entity.Customer;
import com.cg.Garment.repository.ICustomerRepository;
import com.cg.Garment.service.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService {
	
	@Autowired
	ICustomerRepository customerRepository;
	
	@Override
	public Customer registerNewcCustomer(Customer customer) {
		
		Customer newCustomer = customerRepository.save(customer);
		
		return newCustomer;
	}

}
