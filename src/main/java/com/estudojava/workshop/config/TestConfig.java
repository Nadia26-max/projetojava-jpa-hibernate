package com.estudojava.workshop.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.estudojava.workshop.entities.Category;
import com.estudojava.workshop.entities.OrderPedido;
import com.estudojava.workshop.entities.Product;
import com.estudojava.workshop.entities.User;
import com.estudojava.workshop.entities.enums.OrderStatus;
import com.estudojava.workshop.repositories.CategoryRepository;
import com.estudojava.workshop.repositories.OrderRepository;
import com.estudojava.workshop.repositories.ProductRepository;
import com.estudojava.workshop.repositories.UserRepository;

@Configuration // Classe auxiliar, de configuração
@Profile("test") // Perfil de teste -- igualmente escrito ao application.properties
public class TestConfig implements CommandLineRunner {// Executando quando programa for iniciado

	// Acessando o bd
	@Autowired // Instanciando
	private UserRepository userRep;
	
	@Autowired
	private OrderRepository orderRep;
	
	@Autowired
	private  CategoryRepository categoryRep;
	
	@Autowired
	private ProductRepository productRep;

	@Override
	public void run(String... args) throws Exception {
		// Populando o bd
		
		Category cat1 = new Category(1L, "Eletronicos");
		Category cat2 = new Category(2L, "Livros");
		Category cat3 = new Category(3L, "Computadores"); 	
		
		Product p1 = new Product(1L, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(2L, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product(3L, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product(4L, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product(5L, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		
		//Associando produtos à categorias
		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p2.getCategories().add(cat3);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2);
		
		categoryRep.saveAll(Arrays.asList(cat1,cat2,cat3));
		productRep.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		//Salvando os produtos com associações
		productRep.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		User u1 = new User(1L,"Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(2L,"Alex Green", "alex@gmail.com", "977977977", "123456"); 
		
		OrderPedido op1 = new OrderPedido(null, Instant.parse("2022-06-15T19:53:07Z"),OrderStatus.PAGO, u1);//Associação entre pedido e usuário
		OrderPedido op2 = new OrderPedido(null, Instant.parse("2022-06-16T03:42:10Z"),OrderStatus.AGUARDANDO_PAGAMENTO,u2);
		OrderPedido op3 = new OrderPedido(null, Instant.parse("2022-06-17T15:21:22Z"),OrderStatus.AGUARDANDO_PAGAMENTO, u1);
		
		//Salvando os dados -- instanciando o bd
		userRep.saveAll(Arrays.asList(u1,u2));
		orderRep.saveAll(Arrays.asList(op1,op2,op3));
		
	}
}
