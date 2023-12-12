package com.cg.Garment.entity;

import com.cg.Garment.enumOf.Category;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Products {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long productId;
	private String productName;
	private int productCost;
	
	@Enumerated(EnumType.STRING)
	private Category category;
	
	private int stocksAvaliable;
	
	
}
  