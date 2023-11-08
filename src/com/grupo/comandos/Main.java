package com.grupo.comandos;

public class Main {
	public static void main(String[] args) {
		System.out.println("1) Criar uma pizza");
		/* Ao escolher essa opção, os ingredientes devem ser mostrados em tela, e o usuário pode
		escolher que ingredientes colocar na pizza. A pizza deve receber, no mínimo, 1 ingrediente e
		no máximo 5 ingredientes. Deve ser possível desfazer a ação e remover o último ingrediente
		colocado. A ordem que os ingredientes são colocados não importa para o cliente.*/
		
		System.out.println("2) Criar um novo pedido");
		/*O sistema deve permitir que pedidos sejam enfileirados. Um pedido consiste em uma pizza
		e mesa do cliente.*/
		
		System.out.println("3) Servir um pedido");
		/* O pedido deve ser atendido e removido da estrutura de dados se, e apenas se, a pizza
		apropriada tenha sido criada antes.*/
		
		System.out.println("4) Adicionar ingredientes");
		/* Essa opção permite que a pizzaria adicione novos ingredientes ao seu cardápio de
		ingredientes. Não devem existir ingredientes repetidos.*/	
		
		System.out.println("5) Estatísticas dos pedidos");
		/* O sistema deve imprimir quantos pizzas foram servidas, a quantidade média de ingredientes
		por pizza, qual o ingrediente mais pedido (e quantas vezes foi pedido), quais ingredientes
		não foram escolhidos nenhuma vez.*/
		
		System.out.println("6) Sair do programa");
		
		
		
		

	}
}
