package com.cg.Garment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.Garment.entity.Admin;
@Repository
public interface IAdminRepository extends JpaRepository<Admin, Integer> {

}
