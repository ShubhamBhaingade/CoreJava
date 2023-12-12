package com.cg.Garment.dto;

import java.util.List;

import com.cg.Garment.entity.Products;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GarmentProductDto {

	private long garmentNumber;
	private String garmentOwner;
	private String garmentLocation;
	private String garmentName;
	
	private List<Products>products;
}
