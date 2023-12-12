package com.cg.Garment.util;

import org.springframework.stereotype.Component;

import com.cg.Garment.dto.GarmentProductDto;
import com.cg.Garment.entity.Garment;


@Component
public class GarmentProductDtoMapper {
	
	public GarmentProductDto getDetailsFromDto(Garment g) {
		
		GarmentProductDto dto=new GarmentProductDto();
		
		dto.setGarmentName(g.getGarmentName());
		dto.setGarmentLocation(g.getGarmentLocation());
		dto.setGarmentNumber(g.getGarmentNumber());
		dto.setGarmentOwner(g.getGarmentOwner());
		dto.setProducts(g.getProducts());
		
	
		
		return dto;
	}
}
