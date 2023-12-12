package com.cg.Garment.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.Garment.Exception.InvalidDetailsException;
import com.cg.Garment.entity.Admin;
import com.cg.Garment.repository.IAdminRepository;
import com.cg.Garment.service.IAdminService;

@Service
public class AdminServiceImpl implements IAdminService {
	
	@Autowired
	IAdminRepository adminRepository;
	
	@Override
	public Admin saveAdmin(Admin admin) throws InvalidDetailsException {
		
		Admin newAdmin = adminRepository.save(admin);
		if(newAdmin.getAdminName() != null && !newAdmin.getAdminName().isBlank()) {
			
			return newAdmin;
			
		}else throw new InvalidDetailsException("Problem Occured while saving the admin",AdminServiceImpl.class+"");	
	}

}
