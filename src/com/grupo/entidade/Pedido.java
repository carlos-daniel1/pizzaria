package com.grupo.entidade;

public class Pedido {

	private int id;
	private String cliente;
	private int mesa;
	private Pizza pizza;
	private static int CONTADOR = 1;

	public Pedido(String cliente, int mesa, Pizza pizza) {
		super();
		this.id = CONTADOR++;
		this.cliente = cliente;
		this.mesa = mesa;
		this.pizza = pizza;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public int getMesa() {
		return mesa;
	}

	public void setMesa(int mesa) {
		this.mesa = mesa;
	}

	public Pizza getPizza() {
		return pizza;
	}

	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}

	public int getId() {
		return id;
	}

}
