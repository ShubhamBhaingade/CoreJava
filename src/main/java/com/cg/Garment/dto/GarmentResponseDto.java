package com.cg.Garment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GarmentResponseDto {
	private long garmentNumber;
	private String garmentOwner;
	private String garmentLocation;
	private String garmentName;
}
