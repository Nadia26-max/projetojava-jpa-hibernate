package com.estudojava.workshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.estudojava.workshop.entities")
public class ProjetojavaJpaHibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetojavaJpaHibernateApplication.class, args);
	}

}
