package com.grupo.comandos;

public class Fila {
	private String[] valores;
	private int primeiro;
	private int ultimo;
	private int total;
	
	public Fila() {
		valores = new String[10];
		primeiro = 0;
		ultimo = 0;
		total = 0;
	}
	
	public void inserir(String elemento) {
		valores[ultimo] = elemento;
		ultimo = (ultimo + 1) % valores.length;
		total++;
	}
	
	public String retirar() {
		String elemento = valores[primeiro];
		primeiro = (primeiro + 1) % valores.length;
		total--;
		return elemento;
	}
	
	public boolean isEmpty() {
		return total == 0;
	}
	
	public boolean isFull() {
		return total == valores.length;
	}
}
