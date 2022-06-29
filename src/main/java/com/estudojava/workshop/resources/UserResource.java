package com.estudojava.workshop.resources;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.estudojava.workshop.entities.User;
import com.estudojava.workshop.services.UserService;

@RestController
@RequestMapping(value = "/usuario") // Caminho
public class UserResource {

	@Autowired // Injeção de dependência
	private UserService serv;

	// Método para acessar os usuarios (retornar respostas de requisição web - HTTP)
	@GetMapping
	public ResponseEntity<List<User>> findAll() {// Vai retornar a lista de usuarios
		List<User> list = serv.findAll();
		return ResponseEntity.ok().body(list);// Retornar com o sucesso no corpo da resposta HTTP
	}

	// Implementando para buscar o usuário por Id
	@GetMapping(value = "/{id}") // A requisição vai aceitar um id dentro da url
	public ResponseEntity<User> findById(@PathVariable Long id) {// Este findById vai receber o parametro de id passado na url
		User obj = serv.findById(id);//id da url (id que chegou na requisição)
		return ResponseEntity.ok().body(obj);//Obteve sucesso e no corpo retorno o obj de User
	}
	//Para inserir
	@PostMapping
	public ResponseEntity<User> insere(@RequestBody User obj){
		obj = serv.insert(obj);
		//Configurando a resposta 201 no Postman
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	//Para excluir
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> exclui(@PathVariable Long id){//Para ser reconhecida como variavel na url
		serv.delete(id);
		//Retornando a resposta 204
		return ResponseEntity.noContent().build();//retorna algo vazio - noContent
	}
	
	//Para atualizar
	@PutMapping(value = "/{id}")
	@Transactional
	public ResponseEntity<User> atualiza(@PathVariable Long id, @RequestBody User obj){
		obj = serv.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
