package com.estudojava.workshop.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_user")//O bd vai criar a tabela com este nome
/*@Proxy(lazy = true)*/
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id//Indica a PK
	@GeneratedValue (strategy = GenerationType.IDENTITY)//Autoincremento da PK
	private long id;
	private String nome;
	private String email;
	private String fone;
	private String senha;
	
	//Coleções só necessitam do get - Não haverá troca nenhuma de dados
	
	@OneToMany (/*mappedBy = "client",*/fetch = FetchType.EAGER/*cascade = CascadeType.ALL*/)//Está mapeado por client (nome dado à associação)
	@JsonIgnore
	private List<OrderPedido> orderpedido = new ArrayList<>();
	
	public User() {
	}

	public User(long id, String nome, String email,String fone, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.fone = fone;
		this.senha = senha;
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
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public List<OrderPedido> getOrders() {
		return orderpedido;
	}

	//Comparação de dois objetos
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
		User other = (User) obj;
		return id == other.id;
	}
}
