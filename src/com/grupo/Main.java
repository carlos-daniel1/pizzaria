/* Equipe:
 * Brenda Rayane
 * Carlos Daniel
 * Jefferson Costa
 * Gigliarly Marcelino
 * Marcio Vitor
 * Pedro Henrique
 * Pedro Lucas
*/
package com.grupo;

import javax.swing.JOptionPane;

import com.grupo.entidade.Pedido;
import com.grupo.entidade.Pizza;
import com.grupo.funcionalidade.Funcionalidade;
import com.grupo.gerador.GeradorIngredientes;

public class Main {

	public static void main(String[] args) {
		JOptionPane.showMessageDialog(null, "Inicio da Pizzaria");

		int opcao = 0;
		do {
			String opcaoStr = JOptionPane.showInputDialog(Funcionalidade.mostrarMenu());
			try {
				opcao = Integer.parseInt(opcaoStr);
			} catch (Exception e) {
				continue;
			}

			if (opcao == 1) {

			} else if (opcao == 2) {
				Pedido pedidoAtual = Funcionalidade.pedidoAtual();
				JOptionPane.showConfirmDialog(null,pedidoAtual.getId() + " : " + pedidoAtual.getCliente() +  " : " + pedidoAtual.getPizza().getListaIngredientes().toString());

			} else if (opcao == 3) {
				Funcionalidade.addIngredientes();
				try {
					String receberIngredientes = JOptionPane.showInputDialog(Funcionalidade.mostrarIngredientes() +
							"\n\nEscolha o código de 5 ingredientes separados por espaço: ");
					
					int[] listaInt = Funcionalidade.converterInt(receberIngredientes);
					Pizza novapizza = Funcionalidade.criarPizza(listaInt);
					Funcionalidade.addPizza(novapizza);
					
					JOptionPane.showMessageDialog(null, Funcionalidade.pizzasCriadas());   
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Erro ao criar pizza");
					
				}
				

			} else if (opcao == 4) {

			} else if (opcao == 5) {

			}
		} while (opcao != 6);

	}

	public static void criarPizzaVisual(String resposta) {

	}

}
