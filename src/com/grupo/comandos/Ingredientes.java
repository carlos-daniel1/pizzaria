package com.grupo.comandos;

public class Ingredientes {
	String elementos[] = new String[1];
	int topo;
	int quantidade;

	public Ingredientes() {
		topo = -1;
	}

	public void inserir(String e) {
		if (quantidade == elementos.length) {
			aumentaTamanho();
		}
		topo++;
		elementos[topo] = e;
		quantidade++;
	}

	public String pop() {
		String e;
		e = elementos[topo];
		topo--;
		return e;
	}

	public boolean isEmpty() {
		return (quantidade == 0);
	}


	public String top() {
		// colocar comando pra chegar se ta vazia if(isEmpty())
		// System.out.print("lista vazia");
		return elementos[topo];
	}

	public int itensNaLista() {
		return quantidade;
	}

	public void aumentaTamanho() {
		String[] temp = elementos;
		elementos = new String[quantidade + 1];
		for (int i = 0; i < temp.length; i++) {
			elementos[i] = temp[i];
		}
	}

	public boolean verificarIngrediente(String item) {
		boolean verificacao = false;
		for (String i : elementos) {
			if (i.equalsIgnoreCase(item)) {
				verificacao = true;
			}
		}
		return verificacao;
	}
	
	public String selecionarIngrediente(int i) {
		return elementos[i-1];
	}

	public void printarIngredientes() {
		int posicao = 0;
		for (String i : elementos) {
			posicao++;
			System.out.println(posicao + "º Ingrediente: " + i);
			
		}
	}

}
