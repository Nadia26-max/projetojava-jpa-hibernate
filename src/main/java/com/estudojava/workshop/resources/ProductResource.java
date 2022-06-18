package com.estudojava.workshop.resources;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.estudojava.workshop.entities.Product;
import com.estudojava.workshop.services.ProductService;

@RestController
@RequestMapping(value = "/produtos") // Caminho
public class ProductResource {

	@Autowired // Injeção de dependência
	private ProductService serv;

	// Método para acessar os usuarios (retornar respostas de requisição web - HTTP)
	@GetMapping
	public ResponseEntity<List<Product>> findAll() {// Vai retornar a lista de usuarios
		List<Product> list = serv.findAll();
		return ResponseEntity.ok().body(list);// Retornar com o sucesso no corpo da resposta HTTP
	}

	// Implementando para buscar o usuário por Id
	@GetMapping(value = "/{id}") // A requisição vai aceitar um id dentro da url
	public ResponseEntity<Product> findById(@PathVariable Long id) {// Este findById vai receber o parametro de id passado na url
		Product obj = serv.findById(id);//id da url (id que chegou na requisição)
		return ResponseEntity.ok().body(obj);//Obteve sucesso e no corpo retorno o obj de Product
	}
}
