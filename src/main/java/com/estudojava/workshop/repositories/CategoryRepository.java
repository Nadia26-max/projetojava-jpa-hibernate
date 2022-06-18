package com.estudojava.workshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.estudojava.workshop.entities.Category;

//Já herda do JPARepository, então não precisa da anotação @Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{//Tipo da Identidade e tipo do Id
	
	

}
