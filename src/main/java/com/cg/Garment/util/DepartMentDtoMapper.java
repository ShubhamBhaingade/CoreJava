package com.cg.Garment.util;

import org.springframework.stereotype.Component;

import com.cg.Garment.dto.DepartmentRequestDto;
import com.cg.Garment.dto.DepartmentResponseDto;
import com.cg.Garment.entity.Department;

@Component
public class DepartMentDtoMapper {

	public Department setDepartmentToDto(DepartmentRequestDto dto) {
		Department d = new Department();
		d.setDepartName(dto.getDepartName());
		d.setMaximumWorkForce(dto.getMaximumWorkForce());
		return d;

	}

	public DepartmentResponseDto getDeparmentFromDto(Department d) {
		DepartmentResponseDto dto = new DepartmentResponseDto();
		dto.setDepartmentNumber(d.getDepartmentNumber());
		dto.setDepartName(d.getDepartName());
		dto.setMaximumWorkForce(d.getMaximumWorkForce());

		return dto;
	}

}
