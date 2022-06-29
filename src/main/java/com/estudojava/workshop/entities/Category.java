package com.estudojava.workshop.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_category")
/*@Proxy(lazy = true)*/
public class Category implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id//Indica a PK
	@GeneratedValue (strategy = GenerationType.IDENTITY)//Autoincremento da PK
	private long id;
	private String nome;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "categories",fetch = FetchType.EAGER)
	@BatchSize(size = 1000)
	private Set<Product> products = new HashSet<>();
	
	public Category() {
	}
	
	public Category(long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Set<Product> getProducts() {
		return products;
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
		Category other = (Category) obj;
		return id == other.id;
	}
}
