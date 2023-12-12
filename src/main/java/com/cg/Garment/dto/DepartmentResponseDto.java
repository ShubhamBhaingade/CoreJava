package com.cg.Garment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class DepartmentResponseDto {
	
	private long departmentNumber;
	private String departName;
	private long maximumWorkForce;
}
