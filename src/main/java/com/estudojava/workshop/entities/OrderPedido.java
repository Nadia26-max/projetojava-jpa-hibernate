package com.estudojava.workshop.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "tb_order")//O bd vai criar a tabela com este nome
public class OrderPedido implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id//Indica a PK
	@GeneratedValue (strategy = GenerationType.IDENTITY)//Autoincremento da PK
	private Long id;
	
	//Formatando o json
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'",timezone = "GMT")
	private Instant momento;
	
	@ManyToOne//Muitos pedidos para um usuario (relacionamento) -- Referencia a FK
	@JoinColumn(name = "cliente_id")//Nome da FK
	private User client;
	
	public OrderPedido() {	
	}

	public OrderPedido(Long id, Instant momento, User client) {
		super();
		this.id = id;
		this.momento = momento;
		this.client = client;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMomento() {
		return momento;
	}

	public void setMomento(Instant momento) {
		this.momento = momento;
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderPedido other = (OrderPedido) obj;
		return Objects.equals(id, other.id);
	}
}
