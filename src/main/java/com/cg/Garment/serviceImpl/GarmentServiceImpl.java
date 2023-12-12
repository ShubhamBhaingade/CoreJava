package com.cg.Garment.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.Garment.Exception.EmptyListException;
import com.cg.Garment.Exception.InvalidDetailsException;
import com.cg.Garment.dto.GarmentRequestDto;
import com.cg.Garment.entity.Department;
import com.cg.Garment.entity.Garment;
import com.cg.Garment.entity.Products;
import com.cg.Garment.repository.IDepartmentRepository;
import com.cg.Garment.repository.IGarmentRepository;
import com.cg.Garment.repository.IProductsRepository;
import com.cg.Garment.service.IGarmentService;

import jakarta.transaction.Transactional;

@Service
public class GarmentServiceImpl implements IGarmentService {

	@Autowired
	IGarmentRepository garmentRepository;

	@Autowired
	IDepartmentRepository departmentRepository;

	@Autowired
	IProductsRepository productRepository;

	@Override
	public Garment registerNewGarment(Garment garment) {
		Garment savedGarment = garmentRepository.save(garment);
		return savedGarment;
	}

	@Override
	public Garment getGarmentById(long garId) throws InvalidDetailsException {
		Garment name = garmentRepository.findById(garId)
				.orElseThrow(() -> new InvalidDetailsException("The requested id " + garId + " is not found",
						GarmentServiceImpl.class + ""));
		return name;
	}

	@Override
	public List<Garment> getAllGarments() throws EmptyListException {
		List<Garment> allGarments = garmentRepository.findAll();
		if (!allGarments.isEmpty()) {
			return allGarments;
		} else
			throw new EmptyListException("No Garments are registered in your Ownership", GarmentServiceImpl.class + "");
	}

	@Override
	@Transactional
	public Garment updateGarment(long id, GarmentRequestDto garment) throws InvalidDetailsException {
		Garment exGarment = garmentRepository.findById(id)
				.orElseThrow(() -> new InvalidDetailsException("The requested id " + id + " is not found",
						GarmentServiceImpl.class + ""));
		exGarment.setGarmentLocation(garment.getGarmentLocation());
		exGarment.setGarmentOwner(garment.getGarmentOwner());

		return exGarment;
	}

	@Override
	@Transactional
	public Garment allocateDepartmentToGarment(long deptId, long garmentNum) throws InvalidDetailsException {
		Department d = departmentRepository.findById(deptId)
				.orElseThrow(() -> new InvalidDetailsException("The requested id " + deptId + " is not found",
						GarmentServiceImpl.class + ""));
		Garment exGarment = garmentRepository.findById(garmentNum)
				.orElseThrow(() -> new InvalidDetailsException("The requested id " + garmentNum + " is not found",
						GarmentServiceImpl.class + ""));
		if (exGarment != null && d != null) {
			List<Department> allDept = exGarment.getDepartment();
			allDept.add(d);
			exGarment.setDepartment(allDept);
			return exGarment;
		}
		return null;
	}

	@Override
	@Transactional
	public Garment allocateProductToGarment(long pId, long gId) throws InvalidDetailsException {

		Products existingProduct = productRepository.findById(pId)
				.orElseThrow(() -> new InvalidDetailsException("The Product is not avaliable for the id " + pId,
						ProductServiceImpl.class + ""));
		
		Garment exGarment = garmentRepository.findById(gId)
				.orElseThrow(() -> new InvalidDetailsException("The requested id " + gId + " is not found",
						GarmentServiceImpl.class + ""));
		
		if(existingProduct != null && exGarment != null) {
			
			List<Products> allProducts=exGarment.getProducts();
			
			allProducts.add(existingProduct);
			
			exGarment.setProducts(allProducts);
			
			return exGarment;
		}
		
		
		return null;
	}

}
