package com.cg.Garment.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.Garment.Exception.EmptyListException;
import com.cg.Garment.Exception.InvalidDetailsException;
import com.cg.Garment.entity.Department;
import com.cg.Garment.entity.Garment;
import com.cg.Garment.repository.IDepartmentRepository;
import com.cg.Garment.repository.IGarmentRepository;
import com.cg.Garment.service.IDepartmentService;

@Service
public class DepartmentServiceImpl implements IDepartmentService {

	@Autowired
	IDepartmentRepository departmentRepository;

	@Autowired
	IGarmentRepository garmentRepository;

	@Override
	public Department addDept(Department d) {
		Department savedDept = departmentRepository.save(d);
		return savedDept;
	}

	@Override
	public List<Department> getDepartmentByGarmentId(long gId) throws InvalidDetailsException, EmptyListException {
		Garment g = garmentRepository.findById(gId)
				.orElseThrow(() -> new InvalidDetailsException("The requested id " + gId + " is not found",
						GarmentServiceImpl.class + ""));
		List<Department> allDept = g.getDepartment();
		if (!allDept.isEmpty()) {
			return allDept;
		} else
			throw new EmptyListException("There are no Department Linked  with Your Garment",
					DepartmentServiceImpl.class + "");

	}

}
