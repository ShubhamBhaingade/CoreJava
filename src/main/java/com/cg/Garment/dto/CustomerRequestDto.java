package com.cg.Garment.dto;

import jakarta.validation.constraints.Email;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CustomerRequestDto {
	
	@NotNull(message = "Customer Name Cannot be Null")
	@NotBlank(message = "Customer Name Cannot be Null")
	private String customerName;
	
	@Email(message = "Provide a valid Email Id")
	private String emailId;
	
	@Size(min = 10, max = 10, message="Mobile Number Should Not be less than 10")
	private String mobileNumber;

}
