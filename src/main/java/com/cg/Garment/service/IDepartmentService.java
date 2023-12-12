package com.cg.Garment.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.Garment.Exception.EmptyListException;
import com.cg.Garment.Exception.InvalidDetailsException;
import com.cg.Garment.entity.Department;

@Service
public interface IDepartmentService {
	
	public Department addDept(Department d);

	public List<Department> getDepartmentByGarmentId(long gId) throws InvalidDetailsException, EmptyListException;

}
