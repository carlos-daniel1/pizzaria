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

import com.grupo.entidade.Pedido;
import com.grupo.entidade.Pizza;

public class Funcionalidade {
	
	static ArrayList<String> baseIngredientes = new ArrayList<>();
	static ArrayDeque<Pedido> pedidos = new ArrayDeque<Pedido>();

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
	
	public static void criarPizza(int mesa, int[] resposta) {
		String[] ingredientes = new String[4];
		for(int i=0; i<5; i++) {
			ingredientes[i] = baseIngredientes.get( resposta[i] );
		}
		
		pedidos.add(
				new Pedido(mesa, new Pizza(ingredientes))
				);
	}
	
	public static String mostrarPizza() {
		String msg = "Pizzas:";
		
		/*
		 * ArrayList<Pizza> listaValores = listaPizza.getListaValor(); for (Pizza pizza:
		 * listaValores) { msg += "* "+pizza.toString(); }
		 */
		
		return msg;
	}

	public static void novoPedido(Pedido pedido) {
		pedidos.add(pedido);

	}

	public static Pedido servirPedido() {
		Pedido pedido = pedidos.remove();
		
		return pedido;
	}

	public static void adicionarIngredientes(String nome) {
		baseIngredientes.add(
				nome
				);
	}
	
	public static String mostrarIngredientes() {
		if (baseIngredientes.isEmpty()) {
			adicionarIngredientes("Tomate");
		}
		String msg = "Ingredientes:";
		
		for (String item : baseIngredientes) {
			msg += "\n * " + item;
		}
		
		return msg;
	}

	public void estatisticaPedido() {

	}

	public void sair() {

	}

}
