/*	1) Criar uma pizza
	2) Criar um novo pedido
	3) Servir um pedido
	4) Adicionar ingredientes
	5) Estatísticas dos pedidos
	6) Sair do programa
*/
package com.grupo.funcionalidade;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

import com.grupo.entidade.Ingrediente;
import com.grupo.entidade.Pedido;
import com.grupo.entidade.Pizza;

public class Funcionalidade {

	static ArrayList<String> baseIngredientes = new ArrayList<String>();
	static ArrayList<Pizza> listaPizza = new ArrayList<>();
	static ArrayDeque<Pedido> pedidos = new ArrayDeque<Pedido>();
	public static int contadorPedidosServidos = 0;
	public static ArrayList<Integer> contadorQuantidadeMediaIngredientes = new ArrayList<Integer>();
	public static HashMap<String, Integer> controladorPedidosIngredientes = new HashMap<String, Integer>();

	public static String mostrarMenu() {
		return """
				Menu:
				1) Criar uma pizza
				2) Criar um novo pedido
				3) Servir um pedido
				4) Adicionar ingredientes
				5) Estatísticas dos pedidos
				6) Sair do programa
				""";
	}

	public static Pizza criarPizza(int[] resposta) {
		String[] ingredientes = new String[5];

		for (int i = 0; i < 5; i++) {
			if (resposta[i] > 0) {
				ingredientes[i] = baseIngredientes.get(resposta[i] - 1);
			}
		}

		Pizza pizza = new Pizza(ingredientes);

		return pizza;
	}

	public static void adicionarPizza(Pizza pizza) {
		listaPizza.add(pizza);
	}

	public static String mostrarPizza() {
		String msg = "Pizzas:";

		for (Pizza item : listaPizza) {
			String[] listaIngredientes = item.getListaIngredientes();

			msg += "\n ------------";
			for (String ingrediente : listaIngredientes) {
				if (ingrediente != null)
					msg += "\n " + ingrediente;
			}

		}

		return msg;
	}

	public static void novoPedido(int mesa, Pizza pizza) {
		pedidos.add(new Pedido(mesa, pizza));
	}

	public static Pedido servirPedido() {
		Pedido pedido = null;
		if (!pedidos.isEmpty()) {

			for (Pizza item : listaPizza) {
				if (item.equals(pedidos.getFirst().getPizza())) {
					pedido = pedidos.remove();
					contadorPedidosServidos++;
				}

			}
		}

		return pedido;
	}

	public static boolean adicionarIngredientes(String nome) {

		if (!baseIngredientes.contains(nome.toLowerCase())) {
			baseIngredientes.add(nome);
			resetarValoresMap(nome);
			return true;
		} else {
			return false;
		}

	}

	public static String mostrarIngredientes() {
		if (baseIngredientes.isEmpty()) {
			adicionarIngredientes("Tomate");
			adicionarIngredientes("Queijo");
			adicionarIngredientes("Catupiry");
		}
		String msg = "Ingredientes:";

		int c = 1;
		for (String item : baseIngredientes) {
			msg += "\n " + c++ + "º) " + item;
		}

		return msg;
	}

	public static void resetarValoresMap(String item) {
		controladorPedidosIngredientes.put(item, 0);
	}

	public static String estatisticaPedido() {
		String msg = "Estatísticas ⬇️ ";

		msg += "\n Quantidade de pizzas servidas: " + contadorPedidosServidos;

		int soma = 0;
		for (int item : contadorQuantidadeMediaIngredientes)
			soma += item;
		msg += "\n Quantidade média de ingredientes por pizza: " + (soma / contadorQuantidadeMediaIngredientes.size());

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
		msg += "\n O ingrediente menos pedido é " + ingredienteMenosPedido + "(" + menorRepetido + " vezes)";

		return msg;
	}

	public void sair() {

	}

}
