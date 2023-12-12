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

public class Main {

	public static void main(String[] args) {
		JOptionPane.showMessageDialog(null, "Inicio da Pizzaria");

		int opcao = 0;
		do {
			try {
				String opcaoStr = JOptionPane.showInputDialog(Funcionalidade.mostrarMenu());
				opcao = Integer.parseInt(opcaoStr);

				if (opcao == 1) {
					criarPedido();
				} else if (opcao == 2) {
					pedidoAtual();
				} else if (opcao == 3) {
					prepararPizza();
				} else if (opcao == 4) {
					servirPizza();
				} else if (opcao == 5) {
					exibirEstatisticas();
				} else if (opcao == 6) {
					agradecer();
				} else {
					JOptionPane.showMessageDialog(null, "Opção inválida. Insira um número entre 1 e 6.", "Erro",
							JOptionPane.ERROR_MESSAGE);
				}

			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Opção inválida. Insira um número.", "Erro",
						JOptionPane.ERROR_MESSAGE);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Erro no sistema 😠 \n" + e.getMessage());
			}

		} while (opcao != 6);
	}

	private static void criarPedido() {
		Funcionalidade.receberPedido();
	}

	private static void pedidoAtual() {
		Pedido pedidoAtual = Funcionalidade.pedidoAtual();
		String msg = pedidoAtual.getId() + " : " + pedidoAtual.getCliente() + " : ";

		for (String item : pedidoAtual.getPizza().getListaIngredientes()) {
			msg += item + " ";
		}

		JOptionPane.showConfirmDialog(null, msg);
	}

	private static void prepararPizza() {
		try {
			String receberIngredientes = JOptionPane.showInputDialog(Funcionalidade.mostrarIngredientes()
					+ "\n\nEscolha o código de 5 ingredientes separados por espaço: ");

			int[] listaInt = Funcionalidade.converterInt(receberIngredientes);
			Pizza novapizza = Funcionalidade.criarPizza(listaInt);
			Funcionalidade.addPizza(novapizza);

			JOptionPane.showMessageDialog(null, Funcionalidade.pizzasCriadas());

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao criar pizza");

		}
	}

	private static void servirPizza() {
		Pedido pedido = Funcionalidade.servirPedido();
		if (pedido == null) {
			JOptionPane.showMessageDialog(null, "Nenhuma pizza pode ser servida");
		} else {
			JOptionPane.showMessageDialog(null, pedido.getId() + " ⏩ mesa " + pedido.getMesa());
		}

	}

	private static void exibirEstatisticas() {
		try {
			JOptionPane.showMessageDialog(null, "5) Estatísticas dos pedidos", "Pedidos",
					JOptionPane.INFORMATION_MESSAGE);

			JOptionPane.showMessageDialog(null, Funcionalidade.estatisticaPedido());

		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Erro ao exibir estatísticas. Número inválido.", "Erro",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private static void agradecer() {
		JOptionPane.showMessageDialog(null, "Agradecemos a preferência, volte sempre!", "Obrigado",
				JOptionPane.INFORMATION_MESSAGE);
	}

}
