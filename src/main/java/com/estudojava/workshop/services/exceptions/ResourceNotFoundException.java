package com.estudojava.workshop.services.exceptions;

public class ResourceNotFoundException extends RuntimeException{

	//Tratando erros 

	private static final long serialVersionUID = 1L;
	
	//Construtor - Recurso que nao foi encontrado
	public ResourceNotFoundException(Object id) {
		super("Recurso não encontrado. Id: "+ id); //id que procurei mas nao encontrei
	}
	
	
}
