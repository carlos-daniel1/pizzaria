package com.grupo.comandos;


public class Pizza {
	String elementos[];
	int topo;

	public Pizza() {
		elementos = new String[5];
		topo = -1;
	}

	public void inserir(String e) {
			topo++;
			elementos[topo] = e;

	}

	public String pop() {
		String e;
		e = elementos[topo];
		topo--;
		return e;
	}

	public boolean isEmpty() {
		return (topo == -1);
	}

	public boolean isFull() {
		return (topo == 9);
	}

	public String top() {
		// colocar comando pra chegar se ta vazia if(isEmpty())
		// System.out.print("lista vazia"); 
		return elementos[topo];
	}

}
