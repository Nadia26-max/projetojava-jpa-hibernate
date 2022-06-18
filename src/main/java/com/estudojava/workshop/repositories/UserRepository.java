package com.estudojava.workshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.estudojava.workshop.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{//Tipo da Identidade e tipo do Id
	
	

}
