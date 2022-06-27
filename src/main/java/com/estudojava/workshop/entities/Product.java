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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "tb_product")
@Proxy(lazy = false)
public class Product implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id//Indica a PK
	@GeneratedValue (strategy = GenerationType.IDENTITY)//Autoincremento da PK
	private Long id;
	private String nome;
	private String descricao;
	private Double preco;
	private String imgUrl;
	
	//Conjunto - Garante que o mesmo produto nao terá categoria mais de uma vez
	//Coleção nao entra no construtor pois ja está instanciada aqui
	//Mapeamento para transformar essas coleções que têm nas duas classes, na tabela de associação que tem no modelo relacional
	
	@ManyToMany(fetch = FetchType.EAGER)//Quais tabelas e quais chaves estrangeiras vao associar produto e categoria							 
	@JoinTable(name = "tb_product_category", 
			//FK referente à tabela product
	joinColumns = @JoinColumn(name = "product_id"),
			//Define a FK da outra entidade (tabela category)
	inverseJoinColumns = @JoinColumn(name = "category_id"))//FK da outra entidade (categoria)
	private Set<Category> categories = new HashSet<>();//Tem que começar vazia(nao nula), porem instanciada
	
	public Product(){
	}

	public Product(Long id, String nome, String descricao, Double preco, String imgUrl) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.imgUrl = imgUrl;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Set<Category> getCategories() {
		return categories;
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
		Product other = (Product) obj;
		return Objects.equals(id, other.id);
	}
}
