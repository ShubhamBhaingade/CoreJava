package com.cg.Garment.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmptyListException extends Exception {
	
	private String msg;
	private String srcName;
	
}
