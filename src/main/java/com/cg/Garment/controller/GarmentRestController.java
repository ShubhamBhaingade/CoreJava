package com.cg.Garment.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.Garment.Exception.EmptyListException;
import com.cg.Garment.Exception.InvalidDetailsException;
import com.cg.Garment.dto.GarmentProductDto;
import com.cg.Garment.dto.GarmentRequestDto;
import com.cg.Garment.dto.GarmentResponseDto;
import com.cg.Garment.dto.ProductsRequestDto;
import com.cg.Garment.dto.ProductsResponseDto;
import com.cg.Garment.dto.StringResponseDto;
import com.cg.Garment.entity.Garment;
import com.cg.Garment.entity.Products;
import com.cg.Garment.enumOf.Category;
import com.cg.Garment.repository.IProductsRepository;
import com.cg.Garment.service.IGarmentService;
import com.cg.Garment.service.IProductsService;
import com.cg.Garment.util.GarmentDtoMapper;
import com.cg.Garment.util.GarmentProductDtoMapper;
import com.cg.Garment.util.ProductsDtoMapper;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/garment")
public class GarmentRestController {
	@Autowired
	IGarmentService garmentService;

	@Autowired
	GarmentDtoMapper garmentDTOMapper;

	@Autowired
	IProductsService productService;

	@Autowired
	ProductsDtoMapper productMapper;

	@Autowired
	GarmentProductDtoMapper grProductDtoMapper;
	
	@Autowired
	IProductsRepository productsRepository;
	
	@Autowired
	StringResponseDto dto;

	@PostMapping("/saveGarment")
	public ResponseEntity<GarmentResponseDto> crateNewGarment(@RequestBody GarmentRequestDto dto) {
		Garment g = garmentDTOMapper.setGarmentToGarmnetDto(dto);
		Garment savedGarment = garmentService.registerNewGarment(g);
		GarmentResponseDto resDto = garmentDTOMapper.getGarmentDtoByGarment(savedGarment);
		return new ResponseEntity<GarmentResponseDto>(resDto, HttpStatus.OK);
	}

	@Operation(tags = "getGarmentById", description = "Api is used to find out the garment By Particular Id")
	@GetMapping("/getById/{id}")
	public ResponseEntity<GarmentResponseDto> getById(@PathVariable long id) throws InvalidDetailsException {
		Garment existingGarment = garmentService.getGarmentById(id);
		GarmentResponseDto dto = garmentDTOMapper.getGarmentDtoByGarment(existingGarment);
		return new ResponseEntity<GarmentResponseDto>(dto, HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<GarmentResponseDto>> listAllGarments() throws EmptyListException {
		List<Garment> allGarments = garmentService.getAllGarments();
		List<GarmentResponseDto> temp = new ArrayList<>();
		for (Garment garment : allGarments) {
			temp.add(garmentDTOMapper.getGarmentDtoByGarment(garment));
		}
		return new ResponseEntity<List<GarmentResponseDto>>(temp, HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<GarmentResponseDto> updateGarmentDetails(@RequestParam long id,
			@RequestBody GarmentRequestDto dto) throws InvalidDetailsException {

		Garment dt = garmentService.updateGarment(id, dto);
		GarmentResponseDto gt = garmentDTOMapper.getGarmentDtoByGarment(dt);
		return new ResponseEntity<GarmentResponseDto>(gt, HttpStatus.ACCEPTED);
	}

	@PutMapping("allocate")
	public ResponseEntity<Garment> allocateDepartmentToGarment(@RequestParam long dId, @RequestParam long gId)
			throws InvalidDetailsException {
		Garment g = garmentService.allocateDepartmentToGarment(dId, gId);
		return new ResponseEntity<Garment>(g, HttpStatus.OK);

	}

	@PutMapping("/allocateProductToGarment")
	public ResponseEntity<GarmentProductDto> allocateProductToGarment(@RequestParam long pId, @RequestParam long gId)
			throws InvalidDetailsException {

		Garment g = garmentService.allocateProductToGarment(pId, gId);

		GarmentProductDto dto = grProductDtoMapper.getDetailsFromDto(g);

		return new ResponseEntity<GarmentProductDto>(dto, HttpStatus.OK);

	}

	/**
	 * 
	 * Product Functionality
	 * 
	 */
	@PostMapping("/registerNewProduct")

	public ResponseEntity<ProductsResponseDto> saveProduct(@RequestBody ProductsRequestDto product)
			throws InvalidDetailsException {

		Products newProduct = productMapper.setProductToProductDto(product);

		Products actualProduct = productService.addNewProduct(newProduct);

		ProductsResponseDto dto = productMapper.getProductFromDto(actualProduct);

		return new ResponseEntity<ProductsResponseDto>(dto, HttpStatus.OK);
	}

	@GetMapping("/getProductById")
	public ResponseEntity<ProductsResponseDto> getProductById(@RequestParam long pId) throws InvalidDetailsException {

		Products existingProduct = productService.getProductById(pId);

		ProductsResponseDto dto = productMapper.getProductFromDto(existingProduct);

		return new ResponseEntity<ProductsResponseDto>(dto, HttpStatus.OK);

	}

	@GetMapping("/getAllProducts/{garmentNum}")
	public ResponseEntity<List<ProductsResponseDto>> getAllProducts(@PathVariable long garmentNum)
			throws EmptyListException, InvalidDetailsException {

		List<Products> allProducts = productService.getAllProducts(garmentNum);
		List<ProductsResponseDto> temp = new ArrayList<ProductsResponseDto>();

		for (Products product : allProducts) {
			temp.add(productMapper.getProductFromDto(product));
		}

		return new ResponseEntity<List<ProductsResponseDto>>(temp, HttpStatus.OK);
	}
	
	@PutMapping("/updateProductDetails")
	public ResponseEntity<ProductsResponseDto>updateProduct (@RequestParam long pId, @RequestBody ProductsRequestDto product) throws InvalidDetailsException{
		
		Products pr = productMapper.setProductToProductDto(product);
		
		Products updatedProduct = productService.updateProductInfo(pId, pr) ;
		
		ProductsResponseDto response = productMapper.getProductFromDto(updatedProduct);
		
		return new ResponseEntity<ProductsResponseDto>(response, HttpStatus.OK);
	}
	
	@GetMapping("/getStocksById")
	public ResponseEntity<String> getStocks (@RequestParam long productId ){
		
		int stocksAvaliable = productsRepository.stocks( productId );
		
		return new ResponseEntity<String>("The Stocks Avaliable in the inventory is  "+stocksAvaliable, HttpStatus.OK);
	}
	
	@PutMapping("/addStocks")
	public ResponseEntity<StringResponseDto>addStocks (@RequestParam long pId, @RequestParam int quan) throws InvalidDetailsException{
		
		String str1 = productService.addproducts(pId, quan);
		
		dto.setStr(str1);
		
		return new ResponseEntity<StringResponseDto>(dto, HttpStatus.OK);
	}

}
