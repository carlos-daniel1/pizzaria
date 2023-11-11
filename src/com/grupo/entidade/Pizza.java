package com.grupo.entidade;

import java.util.Arrays;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(listaIngredientes);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pizza other = (Pizza) obj;
		return Arrays.equals(listaIngredientes, other.listaIngredientes);
	}

}
