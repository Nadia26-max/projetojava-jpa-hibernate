package com.estudojava.workshop.entities.pk;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.estudojava.workshop.entities.OrderPedido;
import com.estudojava.workshop.entities.Product;

@Embeddable //Referencia a PK composta
public class OrderItemPK implements Serializable{
	
	private static final long serialVersionUID = 1L;

	//Esta classe terá uma referência para o produto e uma referência para o pedido
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "order_id")
	private OrderPedido order;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "product_id")
	private Product product;
	
	//Não terá os construtores
	
	public OrderPedido getOrder() {
		return order;
	}
	public void setOrder(OrderPedido order) {
		this.order = order;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	@Override
	public int hashCode() {
		return Objects.hash(order, product);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItemPK other = (OrderItemPK) obj;
		return Objects.equals(order, other.order) && Objects.equals(product, other.product);
	}
}
