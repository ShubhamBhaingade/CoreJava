package com.cg.Garment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.Garment.entity.Customer;
@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {

}
