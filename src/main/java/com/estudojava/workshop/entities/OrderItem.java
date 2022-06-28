package com.estudojava.workshop.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import com.estudojava.workshop.entities.pk.OrderItemPK;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable{

	private static final long serialVersionUID = 1L;

	@EmbeddedId //Referencia a PK composta
	private OrderItemPK id = new OrderItemPK();
	private Integer quantidade;
	private Double preco;
	
	public OrderItem(){
	}

	public OrderItem(OrderPedido order, Product product, Integer quantidade, Double preco) {
		super();
		id.setOrder(order);
		id.setProduct(product);
		this.quantidade = quantidade;
		this.preco = preco;
	}
	//OrderPedido 
	@JsonIgnore //Ignora o loop
	public OrderPedido getOrder() {
		return id.getOrder();
	}
	
	public void setOrderPedido(OrderPedido order) {
		id.setOrder(order);
	}
	
	//Product
	public Product getProduct() {
		return id.getProduct();
	}
	
	public void setProduct(Product product) {
		id.setProduct(product);
	}
	
	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	//Implementando subtotal
	public Double getSubtotal() {
		return preco * quantidade;
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
		OrderItem other = (OrderItem) obj;
		return Objects.equals(id, other.id);
	}
}
