package com.estudojava.workshop.entities.enums;

public enum OrderStatus {

	AGUARDANDO_PAGAMENTO(1),
	PAGO(2),
	ENVIADO(3),
	ENTREGUE(4),
	CANCELADO(5);
	
	private int codigo;
	
	private OrderStatus (int codigo) {
		this.codigo = codigo;
	}
	
	//Para o código ficar acessível
	public int getCodigo() {
		return codigo;
	}
	
	//Converter um valor numerico para o tipo enumerado
	//static -> Quando nao precisa instanciar
	public static OrderStatus valueOf(int codigo) {//O código retornardo será correspondente ao OrderStatus
		for(OrderStatus valor: OrderStatus.values()) {//Percorre o cada código e se for o código correspondente, retorna
			if(valor.getCodigo() == codigo) {
				return valor;
			}
		}
		//Se o código nao existir, lanço uma exceção
		throw new IllegalArgumentException("O código da ordem do pedido é inválido");
	}
}
