package com.grupo.funcionalidade;

import java.util.ArrayList;
import java.util.HashMap;

public class Estatistica {

	public static ArrayList<String> baseIngredientes = new ArrayList<String>();
	public static int contadorPedidosServidos = 0;
	public static ArrayList<Integer> contadorQuantidadeMediaIngredientes = new ArrayList<Integer>();
	public static HashMap<String, Integer> controladorPedidosIngredientes = new HashMap<String, Integer>();

	public static String estatisticaPedido() {

		String msg = "Estatísticas ⬇️ ";

		msg += "\n Quantidade de pizzas servidas: " + contadorPedidosServidos;
		int soma = 0;

		for (int item : contadorQuantidadeMediaIngredientes) {
			soma += item;

			if (contadorQuantidadeMediaIngredientes.size() > 0) {
				msg += "\n Quantidade média de ingredientes por pizza: "
						+ (soma / contadorQuantidadeMediaIngredientes.size());

			} else {
				msg += "\n Quantidade média de ingredientes por pizza: 0";
			}
		}
		
		int maiorRepetido = 0;
		int menorRepetido = 100;
		String ingredienteMaisPedido = "";
		String ingredienteMenosPedido = "";

		for (String item : baseIngredientes) {
			int valor = controladorPedidosIngredientes.get(item);
			if (valor > maiorRepetido) {
				maiorRepetido = valor;
				ingredienteMaisPedido = item;
			}
		}

		for (String item : baseIngredientes) {
			int valor = controladorPedidosIngredientes.get(item);
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