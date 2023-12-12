package com.cg.Garment.service;

import org.springframework.stereotype.Service;

import com.cg.Garment.Exception.InvalidDetailsException;
import com.cg.Garment.entity.Admin;
@Service
public interface IAdminService {
	
	public Admin saveAdmin (Admin admin) throws InvalidDetailsException;
}
