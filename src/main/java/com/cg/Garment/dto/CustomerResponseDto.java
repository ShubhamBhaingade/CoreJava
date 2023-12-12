package com.cg.Garment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponseDto {
	
	private long customerId;
	
	private String customerName;

	private String emailId;

	
}
