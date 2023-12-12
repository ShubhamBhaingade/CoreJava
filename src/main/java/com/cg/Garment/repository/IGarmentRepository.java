package com.cg.Garment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.Garment.entity.Garment;
@Repository
public interface IGarmentRepository extends JpaRepository<Garment, Long> {

}
