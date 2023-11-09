package com.grupo.entidade;

public class Pedido {
	private int mesa;
	private Pizza pizza;

	public Pedido(int mesa, Pizza pizza) {
		this.mesa = mesa;
		this.pizza = pizza;
	}

	public int getMesa() {
		return mesa;
	}

	public Pizza getPizza() {
		return pizza;
	}
}
