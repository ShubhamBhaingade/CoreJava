package com.cg.Garment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.Garment.Exception.EmptyListException;
import com.cg.Garment.Exception.InvalidDetailsException;
import com.cg.Garment.dto.CustomerRequestDto;
import com.cg.Garment.dto.CustomerResponseDto;
import com.cg.Garment.entity.Customer;
import com.cg.Garment.entity.Products;
import com.cg.Garment.enumOf.Category;
import com.cg.Garment.repository.IProductsRepository;
import com.cg.Garment.service.ICustomerService;
import com.cg.Garment.service.IProductsService;
import com.cg.Garment.util.CustomerDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/customer")
@Validated
public class CustomerRestController {

	@Autowired
	ICustomerService customerService;

	@Autowired
	CustomerDtoMapper customerMapper;

	@Autowired
	IProductsRepository productsRepository;
	
	@Autowired
	IProductsService productService;

	@PostMapping("registerCustomer")
	public ResponseEntity<CustomerResponseDto> registerNewCustomer(@Valid @RequestBody CustomerRequestDto c) {

		Customer customer = customerMapper.setCustomerFromDto(c);
		Customer newCustomer = customerService.registerNewcCustomer(customer);
		CustomerResponseDto response = customerMapper.getCustomerFromDto(newCustomer);

		return new ResponseEntity<CustomerResponseDto>(response, HttpStatus.OK);
	}

	@GetMapping("/getAllProductsAbovePriceRange")
	public ResponseEntity<List<Products>> getProductsByAmount(@RequestParam int cost, @RequestParam Category category)
			throws EmptyListException {

		List<Products> list = productsRepository.getProducts(cost, category);

		if (!list.isEmpty()) {
			return new ResponseEntity<List<Products>>(list, HttpStatus.OK);
		} else
			throw new EmptyListException("No Result is Obtained For The Given Search Query", Products.class + "");

	}
	
	@PutMapping("/buyProduct")
	public ResponseEntity<String>buyProducts(@RequestParam long pId, @RequestParam int quantity) throws InvalidDetailsException{
		
		String str = productService.buyProducts(pId, quantity);
		
		return new ResponseEntity<String>(str, HttpStatus.OK);
	}
}
