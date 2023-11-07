package com.grupo.lista;

public class ListaEncadeada<E> {
	
	private Node<E> cabeca;
	private Node<E> cauda;
	private int quantidade = 0;
	
	public void addFirst(E valor) {
		Node novoNode = new Node(valor);
		novoNode.proximo = cabeca;
		cabeca = novoNode;
		if (size() == 0) {
			cauda = novoNode;
		}
		quantidade++;
	}
	
	public void addLast(E valor) {
		Node novoNode = new Node(valor);
		if (isEmpty()) {
			addFirst(valor);
			return;
		}
		cauda.proximo = novoNode;
		cauda = novoNode;
		quantidade++;
	}
	
	public E removeFirst() {
		Node<E> temp = cabeca;
		cabeca = temp.proximo;
		quantidade--;
		return temp.valor;
	}
	
	public int size() {
		return quantidade;
	}
	
	public boolean isEmpty() {
		return quantidade == 0;
	}
	
	public E first() {
		return cabeca.valor;
	}
	
}

class Node<E> {
	public E valor;
	public Node<E> proximo = null;
	
	public Node(E valor) {
		this.valor = valor;
	}
}