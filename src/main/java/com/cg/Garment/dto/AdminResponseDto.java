package com.cg.Garment.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AdminResponseDto {

	private int adminId;
	private String adminName;
	private String emailId;
}
