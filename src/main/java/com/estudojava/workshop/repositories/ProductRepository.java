package com.estudojava.workshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.estudojava.workshop.entities.Product;

//Já herda do JPARepository, então não precisa da anotação @Repository
public interface ProductRepository extends JpaRepository<Product, Long>{//Tipo da Identidade e tipo do Id
	
	

}
