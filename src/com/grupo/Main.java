/* Componentes:
 * Gigliarly
 * Daniel
 * Marcio
 * Pedro Lucas
 * Pedro Henrique
 * Vinicius Candido
 * Jefferson Costa
*/
package com.grupo;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import com.grupo.entidade.Ingrediente;
import com.grupo.funcionalidade.Funcionalidade;

public class Main {

	public static void main(String[] args) {
		JOptionPane.showMessageDialog(null, "Inicio da Pizzaria");
		
		int opcao=0;
		do {
			String opcaoStr = JOptionPane.showInputDialog(Funcionalidade.mostrarMenu());
			opcao = Integer.parseInt(opcaoStr);
			
			if(opcao == 1) {
				String msg = "Digite o numero dos ingredientes, separados por espaço!\n";
				String respostaStr = JOptionPane.showInputDialog(null, msg+Funcionalidade.mostrarIngredientes());
				int mesa = Integer.parseInt(
						JOptionPane.showInputDialog("Sua mesa: ")
						);
				
				String[] resposta = respostaStr.split(" ");
				int[] respostaInt = new int[4];
				
				for (int i=0; i<5; i++) {
					respostaInt[i] = Integer.parseInt( resposta[i] );
				}

			} else if (opcao == 2) {
                		JOptionPane.showMessageDialog(null, "2) Criar um novo pedido", "Criação de pedido", JOptionPane.INFORMATION_MESSAGE);

            		} else if (opcao == 3) {
                		JOptionPane.showMessageDialog(null, "3) Servir um pedido", "Serviço", JOptionPane.INFORMATION_MESSAGE);
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
			
			} else if (opcao == 5) {
                		JOptionPane.showMessageDialog(null, "5) Estatísticas dos pedidos", "Pedidos", JOptionPane.INFORMATION_MESSAGE);

            		} else if (opcao == 6) {
                		JOptionPane.showMessageDialog(null, "Agradecemos a preferência, volte sempre!", "Obrigado", JOptionPane.INFORMATION_MESSAGE);
            		}			

            		else {
                		JOptionPane.showMessageDialog(null, "Opção inválida. Insira um número.", "Erro", JOptionPane.ERROR_MESSAGE);
            		}

        }
        entrada.close();
    }

}
