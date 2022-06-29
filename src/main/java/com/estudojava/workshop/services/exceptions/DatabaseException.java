package com.estudojava.workshop.services.exceptions;

public class DatabaseException extends RuntimeException{

	//Tratando outros erros
	private static final long serialVersionUID = 1L;

	public DatabaseException(String msg) {
		super(msg);
	}
}
