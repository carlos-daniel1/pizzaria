package pizzaria;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);

		Ingredientes ingredientes = new Ingredientes();

		int opcao = 1;

		while (opcao != 6) {
			System.out.println("\n1) Criar uma pizza");
			System.out.println("2) Criar um novo pedido");
			System.out.println("3) Servir um pedido");
			System.out.println("4) Adicionar ingredientes");
			System.out.println("5) Estatísticas dos pedidos");
			System.out.println("6) Sair do programa");

			System.out.print("\nDigite uma opção: ");
			opcao = entrada.nextInt();
			entrada.nextLine();

			if (opcao == 1) {
				if (ingredientes.isEmpty()) {
					System.out.println("Não é possível criar uma pizza, adicione ingredientes!");

				} else {
					System.out.println("---Ingredientes disponíveis---");					
					
					ingredientes.printarIngredientes();	
					
					System.out.print("\nQual ingrediente deseja adicionar na pizza? \nDigite o número: ");
					
					int escolherIngrediente = entrada.nextInt();
					
					System.out.println("Você escolheu: "+ ingredientes.selecionarIngrediente(escolherIngrediente));
						
								
				}

			} else if (opcao == 2) {
				System.out.println("2) Criar um novo pedido");

			} else if (opcao == 3) {
				System.out.println("3) Servir um pedido");

			} else if (opcao == 4) {
				System.out.print("Quantos ingredientes deseja adicionar? \nDigite um número: ");
				
				int quantidade = entrada.nextInt();
				entrada.nextLine();

				for (int i = 0; i < quantidade; i++) {

					System.out.print("Digite o ingrediente: ");
					String item = entrada.nextLine();

					if (!ingredientes.isEmpty()) {

						if (!ingredientes.verificarIngrediente(item)) {
							ingredientes.inserir(item);
							
						} else {
							System.out.println("Ingrediente já cadastrado!");
							break;
						}
					} else {
						ingredientes.inserir(item);
						
					}
				}
				
				System.out.println("\nIngrediente(s) cadastrado(s) com sucesso!");
			} else if (opcao == 5) {
				System.out.println("5) Estatísticas dos pedidos");

			} else if (opcao == 6) {
				System.out.println("Agredecemos a preferência, volte sempre!");
			}

		}
		entrada.close();
	}

}
