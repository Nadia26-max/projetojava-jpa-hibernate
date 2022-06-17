package com.estudojava.workshop.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.estudojava.workshop.entities.User;

@RestController
@RequestMapping(value = "/users")//Caminho
public class UserResource {

	//Método para acessar os usuarios (retornar respostas de requisição web - HTTP)
	@GetMapping
	public ResponseEntity<User> findAll(){//Vai retornar os usuarios
		User u = new User(1L, "Mary", "90909090","12345");
		return ResponseEntity.ok().body(u);//Retornar com o sucesso no corpo da resposta o usuario u que foi instanciado
	}
}
