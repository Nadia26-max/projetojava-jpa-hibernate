package com.estudojava.workshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.estudojava.workshop.entities.User;

//Já herda do JPARepository, então não precisa da anotação @Repository
public interface UserRepository extends JpaRepository<User, Long>{//Tipo da Identidade e tipo do Id
	
	

}
