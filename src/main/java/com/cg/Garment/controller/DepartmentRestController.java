package com.cg.Garment.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.Garment.Exception.EmptyListException;
import com.cg.Garment.Exception.InvalidDetailsException;
import com.cg.Garment.dto.AdminRequestDto;
import com.cg.Garment.dto.AdminResponseDto;
import com.cg.Garment.dto.DepartmentRequestDto;
import com.cg.Garment.dto.DepartmentResponseDto;
import com.cg.Garment.entity.Admin;
import com.cg.Garment.entity.Department;
import com.cg.Garment.service.IAdminService;
import com.cg.Garment.service.IDepartmentService;
import com.cg.Garment.util.AdminDtoMapper;
import com.cg.Garment.util.DepartMentDtoMapper;

@RestController
@RequestMapping("/dept")
public class DepartmentRestController {
	@Autowired
	IDepartmentService departmentService;
	
	@Autowired
	DepartMentDtoMapper dtoMapper;
	
	@Autowired
	IAdminService adminService;
	
	@Autowired
	AdminDtoMapper adminMapper;
	
	
	
	@PostMapping("/addDept")
	public ResponseEntity<DepartmentResponseDto>addDept(@RequestBody DepartmentRequestDto dto){
		Department saved=dtoMapper.setDepartmentToDto(dto);
		Department savedDept=departmentService.addDept(saved);
		DepartmentResponseDto output=dtoMapper.getDeparmentFromDto(savedDept);
		return new ResponseEntity<DepartmentResponseDto>(output, HttpStatus.OK);
	}
	
	@GetMapping("/getAllDept")
	public ResponseEntity<List<DepartmentResponseDto>>getAll(@RequestParam long gId) throws InvalidDetailsException,EmptyListException{
		List<Department>allDept=departmentService.getDepartmentByGarmentId(gId);
		List<DepartmentResponseDto>temp=new ArrayList<>();
		for (Department dept : allDept) {
			temp.add(dtoMapper.getDeparmentFromDto(dept));
		}
		
		return new ResponseEntity<List<DepartmentResponseDto>>(temp,HttpStatus.OK);
		
	}
	
	@PostMapping("/saveadmin")
	public ResponseEntity<AdminResponseDto>saveAdmin(@RequestBody AdminRequestDto a) throws InvalidDetailsException{
		
		Admin newAdmin=adminMapper.setAdminToAdminDto(a);
		
		Admin savedAdmin=adminService.saveAdmin(newAdmin);
		
		AdminResponseDto dto=adminMapper.getAdminFromDto(savedAdmin);
		
		return new ResponseEntity<AdminResponseDto>(dto,HttpStatus.OK);
		
	}
	
	

}
