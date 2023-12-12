package com.cg.Garment.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Garment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long garmentNumber;
	private String garmentOwner;
	private String garmentLocation;
	private String garmentName;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="deptNumber")
	private List<Department> department;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="garmentNum")
	private List<Products>products;
	
	
	
}
