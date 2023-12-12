package com.cg.Garment.util;

import org.springframework.stereotype.Component;

import com.cg.Garment.dto.CustomerRequestDto;
import com.cg.Garment.dto.CustomerResponseDto;
import com.cg.Garment.entity.Customer;

@Component
public class CustomerDtoMapper {
	
	public Customer setCustomerFromDto (CustomerRequestDto dto) {
		
		Customer c = new Customer();
		
		c.setCustomerName(dto.getCustomerName());
		c.setEmailId(dto.getEmailId());
		c.setMobileNumber(dto.getMobileNumber());
		
		return c;
	}
	
	public CustomerResponseDto getCustomerFromDto (Customer c) {
		
		CustomerResponseDto dto = new CustomerResponseDto();
		
		dto.setCustomerId(c.getCustomerId());
		
		dto.setCustomerName(c.getCustomerName());
		
		dto.setEmailId(c.getEmailId());
		
		return dto;
	}
}
