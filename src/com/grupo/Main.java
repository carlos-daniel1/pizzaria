/* Equipe:
 * Gigliarly Marcelino
 * Carlos Daniel
 * Marcio Vitor
 * Pedro Lucas
 * Pedro Henrique
 * Vinicius Candido
 * Jefferson Costa
*/
package com.grupo;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import com.grupo.entidade.Ingrediente;
import com.grupo.entidade.Pedido;
import com.grupo.entidade.Pizza;
import com.grupo.funcionalidade.Funcionalidade;

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
				String msg = "Digite o numero dos ingredientes, separados por espaço!\n";
				String resposta = JOptionPane.showInputDialog(null, msg + Funcionalidade.mostrarIngredientes());

				if (resposta.length() == 0) {
					JOptionPane.showMessageDialog(null,
							"Você não colocou nenhum ingrediente na pizza, seu cozinheiro sem futuro!!");
					continue;
				}
				Pizza pizzaCriada = criarPizzaVisual(resposta);

				Funcionalidade.adicionarPizza(pizzaCriada);

			} else if (opcao == 2) {
				JOptionPane.showMessageDialog(null, "2) Criar um novo pedido", "Criação de pedido",
						JOptionPane.INFORMATION_MESSAGE);

//				String codigoPizza = JOptionPane.showInputDialog(null, Funcionalidade.mostrarPizza());
				int mesa = Integer.parseInt(JOptionPane.showInputDialog("Sua mesa: "));
				String msg = "Digite o numero dos ingredientes, separados por espaço!\n";
				String resposta = JOptionPane.showInputDialog(null, msg + Funcionalidade.mostrarIngredientes());
				if (resposta.length() == 0) {
					JOptionPane.showMessageDialog(null,
							"Você não colocou nenhum ingrediente na pizza, seu comedor de massa sem futuro!!");
					continue;
				}
				Pizza pizza = criarPizzaVisual(resposta);

				String[] ingredientesPedidos = pizza.getListaIngredientes();

				int i = 0;
				for (String item : ingredientesPedidos) {
					if (item != null) {
						int quantidadeRepetida = Funcionalidade.controladorPedidosIngredientes.get(item);
						Funcionalidade.controladorPedidosIngredientes.put(item, quantidadeRepetida + 1);
						i++;
					}
				}
				
				Funcionalidade.contadorQuantidadeMediaIngredientes.add(i);

				Funcionalidade.novoPedido(mesa, pizza);

			} else if (opcao == 3) {
				JOptionPane.showMessageDialog(null, "3) Servir um pedido", "Serviço", JOptionPane.INFORMATION_MESSAGE);

				Pedido pedido = Funcionalidade.servirPedido();

				String msg = "Nenhum pedido feito, ou a pizza não está pronta";

				if (pedido != null) {
					msg = "Servir pedido na mesa " + pedido.getMesa() + ". \nPizza: ";
					for (String item : pedido.getPizza().getListaIngredientes()) {
						if (item != null)
							msg += "\n * " + item;
					}
				}

				JOptionPane.showMessageDialog(null, msg);

			} else if (opcao == 4) {
				String msg = "Quantos ingredientes deseja adicionar? \nDigite um número: ";
				int quantidade = 0;

				try {
					quantidade = Integer.parseInt(JOptionPane.showInputDialog(msg));
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Valor invalido!!");
					continue;
				}

				if (quantidade > 5)
					quantidade = 5;

				for (int i = 1; i <= quantidade; i++) {
					boolean cadastrou = Funcionalidade.adicionarIngredientes(JOptionPane.showInputDialog("Nome: "));
					if (!cadastrou) {
						JOptionPane.showMessageDialog(null, "Já existe esse ingrediente!!");
						i--;
					}
				}

			} else if (opcao == 5) {
				JOptionPane.showMessageDialog(null, "5) Estatísticas dos pedidos", "Pedidos",
						JOptionPane.INFORMATION_MESSAGE);
				
				JOptionPane.showMessageDialog(null, Funcionalidade.estatisticaPedido());

			} else if (opcao == 6) {
				JOptionPane.showMessageDialog(null, "Agradecemos a preferência, volte sempre!", "Obrigado",
						JOptionPane.INFORMATION_MESSAGE);
			}

			else {
				JOptionPane.showMessageDialog(null, "Opção inválida. Insira um número.", "Erro",
						JOptionPane.ERROR_MESSAGE);
			}

		} while (opcao != 6);

	}

	public static Pizza criarPizzaVisual(String resposta) {

		String[] respostaStr = resposta.split(" ");

		int[] respostaInt = new int[5];

		if (respostaStr.length > 1) {
			for (int i = 0; i < respostaStr.length; i++) {
				respostaInt[i] = Integer.parseInt(respostaStr[i]);
			}
		} else {
			respostaInt[0] = Integer.parseInt(respostaStr[0]);
		}

		return Funcionalidade.criarPizza(respostaInt);
	}

}
