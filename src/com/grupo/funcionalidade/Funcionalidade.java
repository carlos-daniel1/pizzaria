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
import java.util.HashSet;

import com.grupo.entidade.Pedido;
import com.grupo.entidade.Pizza;
import com.grupo.gerador.GeradorIngredientes;

public class Funcionalidade {

	static GeradorIngredientes gerador = new GeradorIngredientes();
	static ArrayList<Pizza> listaPizza = new ArrayList<>();
	static ArrayDeque<Pedido> pedidos = new ArrayDeque<Pedido>();
	
	static Estatistica estatistica = new Estatistica( gerador.getIngredienteSet());
	
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
		String[] listaIngredientesGerados = gerador.gerarIngredientesAleatorios();
		estatistica.estatisticaIngredientes(listaIngredientesGerados);
		p.setListaIngredientes(listaIngredientesGerados);
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

	public static Pizza criarPizza(int[] resposta) {
		Pizza novaPizza = null;
		String[] ingredientes = new String[5];

		if (verificarIngredientes(resposta)) {
			for (int i = 0; i < 5; i++) {
				ingredientes[i] = gerador.getIngredienteSet().get(resposta[i] - 1);
			}
			novaPizza = new Pizza();
			novaPizza.setListaIngredientes(ingredientes);
		}
		return novaPizza;

	}

	public static boolean verificarIngredientes(int[] lista) {
		boolean verificacao = true;

		for (int i : lista) {
			if (i < 0 && i > gerador.getIngredienteSet().size()) {
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
		for (String item : gerador.getIngredienteSet()) {
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
					estatistica.contarPizzaServidas();
					break;
				}

			}
		}

		return pedido;
	}

	public static void resetarValoresMap() {
		estatistica.resetarValores();
	}

	public static String estatisticaPedido() {
		return estatistica.estatisticaPedido() + "\n Pedidos ainda na fila: "+pedidos.size();
	}

}
