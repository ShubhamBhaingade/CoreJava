package com.cg.Garment.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.Garment.Exception.EmptyListException;
import com.cg.Garment.Exception.InvalidDetailsException;
import com.cg.Garment.entity.Products;

@Service
public interface IProductsService {
	
	public Products addNewProduct(Products product) throws InvalidDetailsException;
	
	public Products getProductById(long productId) throws InvalidDetailsException;
	
	public List<Products> getAllProducts(long garmentNum) throws EmptyListException ,InvalidDetailsException;
	
	public Products updateProductInfo (long proId, Products product) throws InvalidDetailsException;
	
	public String buyProducts (long pId,int quantity) throws InvalidDetailsException;
	
	public String addproducts (long pId,int quantity) throws InvalidDetailsException;
	
	
	
	
}
