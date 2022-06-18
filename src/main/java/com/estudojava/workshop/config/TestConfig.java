package com.estudojava.workshop.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.estudojava.workshop.entities.User;
import com.estudojava.workshop.repositories.UserRepository;

@Configuration // Classe auxiliar, de configuração
@Profile("test") // Perfil de teste -- igualmente escrito ao application.properties
public class TestConfig implements CommandLineRunner {// Executando quando programa for iniciado

	// Acessando o bd
	@Autowired // Instanciando
	private UserRepository userRep;

	@Override
	public void run(String... args) throws Exception {
		// Populando o bd
		
		User u1 = new User(1L,"Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(2L,"Alex Green", "alex@gmail.com", "977977977", "123456"); 
		
		//Salvando os dados -- instanciando o bd
		userRep.saveAll(Arrays.asList(u1,u2));
	}
}
