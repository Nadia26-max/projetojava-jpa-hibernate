package com.estudojava.workshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.estudojava.workshop.entities")
public class ProjetojavaJpaHibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetojavaJpaHibernateApplication.class, args);
	}

}
