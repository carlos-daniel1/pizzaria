/*	1) Criar uma pizza
	2) Criar um novo pedido
	3) Servir um pedido
	4) Adicionar ingredientes
	5) Estatísticas dos pedidos
	6) Sair do programa
*/
package com.grupo.funcionalidade;

import java.util.ArrayList;

import com.grupo.entidade.Ingrediente;
import com.grupo.entidade.Pizza;
import com.grupo.lista.ListaEncadeada;

public class Funcionalidade {
	
	static ArrayList<Ingrediente> listaIngredientes = new ArrayList<Ingrediente>();
	static ListaEncadeada<Pizza> listaPizza = new ListaEncadeada<Pizza>();

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
	
	public static void criarPizza(Ingrediente[] listaIngrediente) {
		Pizza pizza = new Pizza(listaIngrediente);
		listaPizza.addFirst(pizza);
	}

	public void novoPedido() {

	}

	public void servirPedido() {

	}

	public static void adicionarIngredientes(String nome) {
		listaIngredientes.add(
				new Ingrediente(nome)
				);
	}
	
	public static String mostrarIngredientes() {
		if (listaIngredientes.isEmpty()) {
			adicionarIngredientes("Tomate");
		}
		String msg = "Ingredientes:";
		
		for (Ingrediente item : listaIngredientes) {
			msg += "\n * " + item.getNome();
		}
		
		return msg;
	}

	public void estatisticaPedido() {

	}

	public void sair() {

	}

}
