package com.cg.Garment.util;

import org.springframework.stereotype.Component;

import com.cg.Garment.dto.AdminRequestDto;
import com.cg.Garment.dto.AdminResponseDto;
import com.cg.Garment.entity.Admin;

@Component
public class AdminDtoMapper {

	public Admin setAdminToAdminDto(AdminRequestDto dto) {
		
		Admin a=new Admin();
		
		a.setAdminName(dto.getAdminName());
		
		a.setEmailId(dto.getEmailId());
		
		return a;
		
	}
	
	public AdminResponseDto getAdminFromDto (Admin a) {
		
		AdminResponseDto dto=new AdminResponseDto();
		
		dto.setAdminId(a.getAdminId());
		dto.setAdminName(a.getAdminName());
		dto.setEmailId(a.getEmailId());
		
		return dto;
	}
}
