package com.grupo.gerador;

import java.util.HashSet;
import java.util.Random;

public class GeradorIngredientes {

	public HashSet<String> ingredienteSet;

	public GeradorIngredientes() {
		ingredienteSet = new HashSet<String>();
		ingredienteSet.add("Cebola");
		ingredienteSet.add("Carne moida");
		ingredienteSet.add("Queijo");
		ingredienteSet.add("Catupiry");
		ingredienteSet.add("Frango");
		ingredienteSet.add("Calabresa");
		ingredienteSet.add("Borda Chocolate");
		ingredienteSet.add("Borda normal");
		ingredienteSet.add("Chocolate");
		ingredienteSet.add("Leite em pó");
	}

	public String[] gerarIngredientesAleatorios() {
		Random rand = new Random();
		int tamanho = ingredienteSet.size();
		String[] listaIngrediente = new String[5];

		Object[] lista = ingredienteSet.toArray();

		for (int i = 0; i < 5; i++) {
			listaIngrediente[i] = (String) lista[rand.nextInt(tamanho)];
		}

		return listaIngrediente;
	}

	public String gerarNomeCliente(String[] nomesClientes) {
		Random rand = new Random();
		
		int tamanho = nomesClientes.length;
		String nome;

		nome = (String) nomesClientes[rand.nextInt(tamanho)];

		return nome;
	}
}
