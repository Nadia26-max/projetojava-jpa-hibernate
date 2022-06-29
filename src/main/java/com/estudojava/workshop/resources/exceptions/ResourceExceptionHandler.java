package com.estudojava.workshop.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.estudojava.workshop.services.exceptions.DatabaseException;
import com.estudojava.workshop.services.exceptions.ResourceNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {

	//Tratamento manual para os erros
	
	//Primeiro tratamento
	@ExceptionHandler(ResourceNotFoundException.class) //Interceptando a requisição para cair aqui - nome da requisição
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e,HttpServletRequest request){
		String erro = "Recurso não encontrado";
		HttpStatus status = HttpStatus.NOT_FOUND;		//status - value: Passa para inteiro
		StandardError er = new StandardError(Instant.now(), status.value(), erro, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(er);//objeto do erro - er
	}
	//Segundo tratamento
	@ExceptionHandler(DatabaseException.class) //Interceptando a requisição para cair aqui - nome da requisição
	public ResponseEntity<StandardError> database(DatabaseException e,HttpServletRequest request){
		String erro = "Erro de base de dados";
		HttpStatus status = HttpStatus.BAD_REQUEST;		
		StandardError er = new StandardError(Instant.now(), status.value(), erro, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(er);//objeto do erro - er
	}
}
