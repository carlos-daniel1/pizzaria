package com.grupo.entidade;

public class Pizza {
	
	String[] listaIngredientes;

	public Pizza(String[] ingredientes) {
		super();
		this.listaIngredientes = ingredientes;
	}

	public String[] getListaIngredientes() {
		return listaIngredientes;
	}

	public void setListaIngredientes(String[] listaIngredientes) {
		this.listaIngredientes = listaIngredientes;
	}

}
