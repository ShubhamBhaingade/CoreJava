package com.cg.Garment.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int adminId;
	
	private String adminName;
	
	@Column(unique = true)
	private String emailId;
	
}
