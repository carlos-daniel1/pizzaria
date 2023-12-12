package com.grupo.entidade;

import java.util.Arrays;

public class Pizza {

	String[] listaIngredientes;

	public Pizza() {
		super();
		this.listaIngredientes = new String[5];
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
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Pizza other = (Pizza) obj;
		return verificarIngrediente(listaIngredientes, other.listaIngredientes);
	}

	private boolean verificarIngrediente(String[] lista, String[] listaOther) {
		int quantIguais = 0;

		for (int i = 0; i < lista.length; i++) {
			if (lista[i] == listaOther[i]) {
				quantIguais++;
			}
		}
		
		if (quantIguais>=3) {
			return true;
		}else {
			return false;
		}
		
	}

}
