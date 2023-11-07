package com.grupo.entidade;

public class Pizza {
	
	Ingrediente[] listaIngredientes;

	public Pizza(Ingrediente[] listaIngredientes) {
		super();
		this.listaIngredientes = listaIngredientes;
	}

	public Ingrediente[] getListaIngredientes() {
		return listaIngredientes;
	}

	public void setListaIngredientes(Ingrediente[] listaIngredientes) {
		this.listaIngredientes = listaIngredientes;
	}

}
