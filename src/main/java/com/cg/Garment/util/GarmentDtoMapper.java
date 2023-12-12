package com.cg.Garment.util;

import org.springframework.stereotype.Component;

import com.cg.Garment.dto.GarmentRequestDto;
import com.cg.Garment.dto.GarmentResponseDto;
import com.cg.Garment.entity.Garment;
@Component
public class GarmentDtoMapper {

	public Garment setGarmentToGarmnetDto(GarmentRequestDto dto) {
		Garment g = new Garment();
		g.setGarmentOwner(dto.getGarmentOwner());
		g.setGarmentLocation(dto.getGarmentLocation());
		g.setGarmentName(dto.getGarmentName());

		return g;
	}

	public GarmentResponseDto getGarmentDtoByGarment(Garment garment) {
		GarmentResponseDto dto = new GarmentResponseDto();
		dto.setGarmentNumber(garment.getGarmentNumber());
		dto.setGarmentOwner(garment.getGarmentOwner());
		dto.setGarmentLocation(garment.getGarmentLocation());
		dto.setGarmentName(garment.getGarmentName());

		return dto;
	}
}
