package com.cg.Garment.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionHandler {
	@ExceptionHandler
	public ResponseEntity<ExceptionResponse> giveInvalidDetailsException(InvalidDetailsException e) {
		ExceptionResponse response = new ExceptionResponse(e.getMsg(),e.getSrcName());
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	public ResponseEntity<ExceptionResponse>giveListException(EmptyListException e){
		ExceptionResponse response=new ExceptionResponse(e.getMsg(),e.getSrcName());
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<String> handleValidationException(MethodArgumentNotValidException ex) {
	    String errorMessage = ex.getBindingResult().getFieldError().getDefaultMessage();
	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
	}

}
