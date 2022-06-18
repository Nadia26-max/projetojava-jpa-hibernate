package com.estudojava.workshop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.estudojava.workshop.entities.User;
import com.estudojava.workshop.repositories.UserRepository;

@Service//Permite a injeção de dependência (Classe de Serviço, então é indicado usar o service
public class UserService {

	@Autowired
	private UserRepository rep;
	
	//Métdo para retornar todos os dados do BD
	public List<User> findAll(){
		return rep.findAll();
	}
	
	//Buscando usuário por Id
	public User findById(Long id) {
		Optional<User> obj = rep.findById(id);
		return obj.get();//Retorna o objetivo que estiver no Optional
	}
}
