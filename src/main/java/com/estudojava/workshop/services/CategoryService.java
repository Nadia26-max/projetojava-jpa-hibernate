package com.estudojava.workshop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.estudojava.workshop.entities.Category;
import com.estudojava.workshop.repositories.CategoryRepository;

@Service//Permite a injeção de dependência (Classe de Serviço, então é indicado usar o service
public class CategoryService {

	@Autowired
	private CategoryRepository rep;
	
	//Métdo para retornar todos os dados do BD
	public List<Category> findAll(){
		return rep.findAll();
	}
	
	//Buscando usuário por Id
	public Category findById(Long id) {
		Optional<Category> obj = rep.findById(id);
		return obj.get();//Retorna o objetivo que estiver no Optional
	}
}
