package com.estudojava.workshop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudojava.workshop.entities.OrderPedido;
import com.estudojava.workshop.repositories.OrderRepository;

@Service//Permite a injeção de dependência (Classe de Serviço, então é indicado usar o service
public class OrderService {

	@Autowired
	private OrderRepository rep;
	
	//Métdo para retornar todos os dados do BD
	public List<OrderPedido> findAll(){
		return rep.findAll();
	}
	
	//Buscando usuário por Id
	public OrderPedido findById(Long id) {
		Optional<OrderPedido> obj = rep.findById(id);
		return obj.get();//Retorna o objetivo que estiver no Optional
	}
}
