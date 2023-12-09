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
import java.util.HashMap;

import com.grupo.entidade.Pedido;
import com.grupo.entidade.Pizza;
import com.grupo.gerador.GeradorIngredientes;

public class Funcionalidade {

	static GeradorIngredientes gerador = new GeradorIngredientes();
	static ArrayList<String> baseIngredientes = new ArrayList<String>();
	static ArrayList<Pizza> listaPizza = new ArrayList<>();
	static ArrayDeque<Pedido> pedidos = new ArrayDeque<Pedido>();
	public static int contadorPedidosServidos = 0;
	public static ArrayList<Integer> contadorQuantidadeMediaIngredientes = new ArrayList<Integer>();
	public static HashMap<String, Integer> controladorPedidosIngredientes = new HashMap<String, Integer>();

	public static String mostrarMenu() {
		return """
				Menu:
				1) Receber um pedido
				2) Olhar pedido atual
				3) Preparar uma pizza
				4) Servir uma pizza
				5) Estatísticas dos produtos
				6) Sair do programa
				""";
	}

	public static void receberPedido() {
		Pizza p = new Pizza();
		p.setListaIngredientes(gerador.gerarIngredientesAleatorios());
		String[] listaNomes = { "Raphael", "Leonardo", "Miquelangelo", "Donatelo" };
		String nome = gerador.gerarNomeCliente(listaNomes);
		Pedido pedido = new Pedido(nome, 0, p);
		pedidos.add(pedido);

	}

	public static Pedido pedidoAtual() {
		if (pedidos.isEmpty()) {
			Pizza p = new Pizza();
			p.setListaIngredientes(gerador.gerarIngredientesAleatorios());
			Pedido pedido = new Pedido("Márcio", 0, p);
			pedidos.add(pedido);

		}
		return pedidos.getFirst();
	}


	public static void addIngredientes() {
		if (baseIngredientes.isEmpty()) {
			baseIngredientes.add("Cebola");
			baseIngredientes.add("Carne moida");
			baseIngredientes.add("Queijo");
			baseIngredientes.add("Catupiry");
			baseIngredientes.add("Frango");
			baseIngredientes.add("Calabresa");
			baseIngredientes.add("Borda Chocolate");
			baseIngredientes.add("Borda normal");
			baseIngredientes.add("Chocolate");
			baseIngredientes.add("Leite em pó");
		}
	}

	public static Pizza criarPizza(int[] resposta) {
		Pizza novaPizza = null;
		String[] ingredientes = new String[5];

		if (verificarIngredientes(resposta)) {
			for (int i = 0; i < 5; i++) {
				ingredientes[i] = baseIngredientes.get(resposta[i] - 1);
			}
			novaPizza = new Pizza();
			novaPizza.setListaIngredientes(ingredientes);
		}
		return novaPizza;

	}

	public static boolean verificarIngredientes(int[] lista) {
		boolean verificacao = true;

		for (int i : lista) {
			if (i < 0 && i > baseIngredientes.size()) {
				verificacao = false;
			}
		}

		return verificacao;
	}

	public static void addPizza(Pizza novaPizza) {
		listaPizza.add(novaPizza);
	}
	
	public static String pizzasCriadas() {
		String msg = "Pizzas criadas:";
		int num = 1;
		
		for(Pizza i : listaPizza) {	
			msg += "\nPizza " + num + ": " + i.getListaIngredientes()[0] +" | " + i.getListaIngredientes()[1] + " | "
					+ i.getListaIngredientes()[2] + " | " + i.getListaIngredientes()[3] + " | "+ 
					i.getListaIngredientes()[4];
			num++;
			
		}
		return msg;
	}
	
	
	public static String mostrarIngredientes() {
		String msg = "Ingredientes:";

		int c = 1;
		for (String item : baseIngredientes) {
			msg += "\n " + c++ + "º) " + item;
		}

		return msg;
	}
	
	
	public static int[] converterInt(String input) {
		String[] lista = input.split(" "); 
		
		int[] listaInt = new int[5];
		
		for(int i = 0; i < 5; i++) {
			listaInt[i] = Integer.parseInt(lista[i]);
		}
		return listaInt;
	}
	

	public static Pedido servirPedido() {
		Pedido pedido = null;
		if (!pedidos.isEmpty()) {

			for (Pizza item : listaPizza) {
				if (item.equals(pedidos.getFirst().getPizza())) {
					pedido = pedidos.remove();
					listaPizza.remove(item);
					contadorPedidosServidos++;
					break;
				}

			}
		}

		return pedido;
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
		if (contadorQuantidadeMediaIngredientes.size() > 0) {
			msg += "\n Quantidade média de ingredientes por pizza: "
					+ (soma / contadorQuantidadeMediaIngredientes.size());

		} else {
			msg += "\n Quantidade média de ingredientes por pizza: 0";
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
