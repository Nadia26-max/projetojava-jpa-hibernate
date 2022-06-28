package com.estudojava.workshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.estudojava.workshop.entities.OrderItem;

//Já herda do JPARepository, então não precisa da anotação @Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{//Tipo da Identidade e tipo do Id
	
	

}
