package com.cg.Garment.util;

import org.springframework.stereotype.Component;

import com.cg.Garment.dto.ProductsRequestDto;
import com.cg.Garment.dto.ProductsResponseDto;
import com.cg.Garment.entity.Products;

@Component
public class ProductsDtoMapper {
	
	public Products setProductToProductDto (ProductsRequestDto dto) {
		
		Products product=new Products();
		
		product.setProductName(dto.getProductName());
		product.setStocksAvaliable(dto.getStocksAvaliable());
		product.setCategory(dto.getCategory());
		product.setProductCost(dto.getProductCost());
		
		return product;
	}
	
	public ProductsResponseDto getProductFromDto (Products p) {
		
		ProductsResponseDto dto=new ProductsResponseDto();
		
		dto.setProductId(p.getProductId());
		dto.setProductName(p.getProductName());
		dto.setStocksAvaliable(p.getStocksAvaliable());
		dto.setCategory(p.getCategory());
		dto.setProductCost(p.getProductCost());
		
		return dto;
	}
}
