package com.cg.Garment.serviceImpl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.Garment.Exception.EmptyListException;
import com.cg.Garment.Exception.InvalidDetailsException;
import com.cg.Garment.entity.Garment;
import com.cg.Garment.entity.Products;
import com.cg.Garment.repository.IGarmentRepository;
import com.cg.Garment.repository.IProductsRepository;
import com.cg.Garment.service.IProductsService;

import jakarta.transaction.Transactional;

@Service
public class ProductServiceImpl implements IProductsService {

	@Autowired
	IProductsRepository productRepository;

	@Autowired
	IGarmentRepository garmentRepository;

	@Override
	public Products addNewProduct(Products product) throws InvalidDetailsException {

		Products newProduct = productRepository.save(product);

		if (newProduct.getStocksAvaliable() > 10) {

			return newProduct;
		} else
			throw new InvalidDetailsException("Provide the Correct Details", ProductServiceImpl.class + "");
	}

	@Override
	public Products getProductById(long productId) throws InvalidDetailsException {

		Products existingProduct = productRepository.findById(productId)
				.orElseThrow(() -> new InvalidDetailsException("The Product is not avaliable for the id " + productId,
						ProductServiceImpl.class + ""));

		return existingProduct;
	}

	@Override
	public List<Products> getAllProducts(long garmentNum) throws EmptyListException, InvalidDetailsException {
		Garment exGarment = garmentRepository.findById(garmentNum)
				.orElseThrow(() -> new InvalidDetailsException("The requested id " + garmentNum + " is not found",
						GarmentServiceImpl.class + ""));

		List<Products> allProducts = exGarment.getProducts();
		if (!allProducts.isEmpty()) {
			return allProducts.stream().sorted(Comparator.comparing(Products::getStocksAvaliable))
					.collect(Collectors.toList());
		} else
			throw new EmptyListException("Currently No Products Are there in your Garment",
					ProductServiceImpl.class + "");
	}

	@Override
	@Transactional
	public Products updateProductInfo(long proId, Products product) throws InvalidDetailsException {

		Products existingProduct = productRepository.findById(proId)
				.orElseThrow(() -> new InvalidDetailsException("The Product is not avaliable for the id " + proId,
						ProductServiceImpl.class + ""));

		existingProduct.setProductCost(product.getProductCost());
		existingProduct.setStocksAvaliable(product.getStocksAvaliable());
		existingProduct.setProductName(product.getProductName());

		productRepository.save(existingProduct);

		return existingProduct;
	}

	@Override
	@Transactional
	public String buyProducts(long pId, int quantity) throws InvalidDetailsException {
		Products existingProduct = productRepository.findById(pId)
				.orElseThrow(() -> new InvalidDetailsException("The Product is not avaliable for the id " + pId,
						ProductServiceImpl.class + ""));
		if(existingProduct.getStocksAvaliable()<1) {
			throw new InvalidDetailsException("The Requested Product "+existingProduct.getProductName()+" is out of stock", ProductServiceImpl.class+"");
		}
		if(quantity> existingProduct.getStocksAvaliable()){
			throw new InvalidDetailsException("The Quantity You are Ordering is not Avaliable. Avaliable Quantity is "+existingProduct.getStocksAvaliable(), ProductServiceImpl.class+"");
		}
		else {
			existingProduct.setStocksAvaliable(existingProduct.getStocksAvaliable()-quantity);
			productRepository.save(existingProduct);
		}
		return "You've Sucessfully purchased the "+quantity +" unit of "+existingProduct.getProductName();
	}

	@Override
	@Transactional
	public String addproducts(long pId, int quantity) throws InvalidDetailsException {
		Products existingProduct = productRepository.findById(pId)
				.orElseThrow(() -> new InvalidDetailsException("The Product is not avaliable for the id " + pId,
						ProductServiceImpl.class + ""));
		
		existingProduct.setStocksAvaliable(existingProduct.getStocksAvaliable() + quantity);
		
		productRepository.save(existingProduct);
		
		double bill = quantity*existingProduct.getProductCost();
		
		return "You've SucessFully Purchased "+quantity+" units"+" Of "+existingProduct.getProductName()+"   Your Total Bill Is "+bill;
	}
	
	
	
	

}
