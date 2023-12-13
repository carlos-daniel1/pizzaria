package com.grupo.funcionalidade;

import java.util.ArrayList;
import java.util.HashMap;

public class Estatistica {

	private int totalPizzasServidas;
	private String ingredienteMaisPedido;
	private String[] ingredientesNaoUtilizados;
	private int pedidosNaFila;
	private double mediaIngredientesCorretos;
	private int totalPedidos;
	private HashMap<String, Integer> totalIngredientes;
	private ArrayList<String> baseIngredientes;

	public Estatistica(ArrayList<String> list) {
		totalPizzasServidas = 0;
		ingredienteMaisPedido = "";
		ingredientesNaoUtilizados = new String[0];
		pedidosNaFila = 0;
		mediaIngredientesCorretos = 0.0;
		totalPedidos = 0;
		totalIngredientes = new HashMap<>();
		baseIngredientes = list;
		
		criarMap(list);
	}
	
	private void criarMap(ArrayList<String> list) {
		for(String item : list) {
			totalIngredientes.put(item, 0);
		}
	}

	public void estatisticaIngredientes(String[] listaIngredientesGerados) {
		for(String item : listaIngredientesGerados) {
			if(totalIngredientes.keySet().contains(item)) {
				int valor = totalIngredientes.get(item);
				totalIngredientes.put(item, valor+1);
			}
		}
		
	}

	public void contarPizzaServidas() {
		totalPizzasServidas++;
	}

	public String estatisticaPedido() {
		String msg = "Estatísticas ⬇️ ";

		msg += "\n Quantidade de pizzas servidas: " + totalPizzasServidas;

		int maiorRepetido = 0;
		int menorRepetido = 0;
		String ingredienteMaisPedido = "";
		String ingredienteMenosPedido = "";

		for (String item : baseIngredientes) {
			int valor = totalIngredientes.get(item);
			if (valor > maiorRepetido) {
				maiorRepetido = valor;
				menorRepetido = valor;
				
				ingredienteMaisPedido = item;
			}
		}

		for (String item : baseIngredientes) {
			int valor = totalIngredientes.get(item);
			if (valor < menorRepetido) {
				menorRepetido = valor;
				ingredienteMenosPedido = item;
			}
		}
		msg += "\n O ingrediente mais pedido é " + ingredienteMaisPedido + "(" + maiorRepetido + " vezes)";

		if (menorRepetido != 100) {
			msg += "\n O ingrediente menos pedido é " + ingredienteMenosPedido + "(" + menorRepetido + " vezes)";
		}

		return msg;
	}
}
