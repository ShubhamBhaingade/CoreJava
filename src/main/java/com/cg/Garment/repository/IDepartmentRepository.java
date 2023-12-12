package com.cg.Garment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.Garment.entity.Department;
@Repository
public interface IDepartmentRepository extends JpaRepository<Department, Long> {

}
