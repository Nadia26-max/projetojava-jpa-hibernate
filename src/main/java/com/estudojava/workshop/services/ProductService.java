package com.estudojava.workshop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.estudojava.workshop.entities.Product;
import com.estudojava.workshop.repositories.ProductRepository;

@Service//Permite a injeção de dependência (Classe de Serviço, então é indicado usar o service
public class ProductService {

	@Autowired(required = true)
	private ProductRepository rep;
	
	//Métdo para retornar todos os dados do BD
	public List<Product> findAll(){
		return rep.findAll();
	}
	
	//Buscando usuário por Id
	public Product findById(Long id) {
		Optional<Product> obj = rep.findById(id);
		return obj.get();//Retorna o objetivo que estiver no Optional
	}
}
