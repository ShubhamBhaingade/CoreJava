package com.cg.Garment.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.Garment.Exception.EmptyListException;
import com.cg.Garment.Exception.InvalidDetailsException;
import com.cg.Garment.dto.GarmentRequestDto;
import com.cg.Garment.entity.Garment;

@Service
public interface IGarmentService {

	public Garment registerNewGarment(Garment garment);

	public Garment getGarmentById(long garId) throws InvalidDetailsException;

	public List<Garment> getAllGarments() throws EmptyListException;

	public Garment updateGarment(long id, GarmentRequestDto temp) throws InvalidDetailsException;

	public Garment allocateDepartmentToGarment(long deptId, long garmentNum) throws InvalidDetailsException;
	
	public Garment allocateProductToGarment (long pId,long gId) throws InvalidDetailsException;

}
