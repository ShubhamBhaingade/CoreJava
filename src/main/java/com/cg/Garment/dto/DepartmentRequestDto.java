package com.cg.Garment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DepartmentRequestDto {
	
	private String departName;
	private long maximumWorkForce;

}
