package com.cg.Garment.dto;

import com.cg.Garment.enumOf.Category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductsResponseDto {
	
	
	private long productId;
	private String productName;
	private int productCost;
	
	
	private Category category;
	
	private int stocksAvaliable;

}
