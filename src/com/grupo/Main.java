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
                    criarPizza();
                } else if (opcao == 2) {
                    criarNovoPedido();
                } else if (opcao == 3) {
                    servirPedido();
                } else if (opcao == 4) {
                    adicionarIngredientes();
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
            }

        } while (opcao != 6);
    }

    private static void criarPizza() {
        try {
            String msg = "Digite o numero dos ingredientes, separados por espaço!\n";
            String resposta = JOptionPane.showInputDialog(null, msg + Funcionalidade.mostrarIngredientes());

            if (resposta == null || resposta.length() == 0) {
                JOptionPane.showMessageDialog(null,
                        "Você não colocou nenhum ingrediente na pizza, seu cozinheiro sem futuro!!");
                return;
            }

            Pizza pizzaCriada = criarPizzaVisual(resposta);

            if (pizzaCriada == null) {
                JOptionPane.showMessageDialog(null, "Falha na criação da pizza, digite um ingrediente válido!");
                return;
            }

            Funcionalidade.adicionarPizza(pizzaCriada);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ingrediente inválido. Digite um número.", "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void criarNovoPedido() {
        try {
            JOptionPane.showMessageDialog(null, "2) Criar um novo pedido", "Criação de pedido",
                    JOptionPane.INFORMATION_MESSAGE);

            int mesa = Integer.parseInt(JOptionPane.showInputDialog("Informe sua mesa: "));
            if (mesa <= 0) {
                JOptionPane.showMessageDialog(null, "Digite um número de mesa válido.", "Erro",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            String msg = "Digite o numero dos ingredientes, separados por espaço!\n";
            String resposta = JOptionPane.showInputDialog(null, msg + Funcionalidade.mostrarIngredientes());
            if (resposta == null || resposta.length() == 0) {
                JOptionPane.showMessageDialog(null,
                        "Você não colocou nenhum ingrediente na pizza, seu comedor de massa sem futuro!!");
                return;
            }

            Pizza pizza = criarPizzaVisual(resposta);

            if (pizza == null) {
                JOptionPane.showMessageDialog(null, "Falha na criação da pizza, digite um ingrediente válido!");
                return;
            }

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

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Número inválido. Digite um número.", "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void servirPedido() {
        try {
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

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Erro ao processar pedido. Número inválido.", "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void adicionarIngredientes() {
        try {
            String msg = "Quantos ingredientes deseja adicionar? \nDigite um número: ";
            int quantidade = Integer.parseInt(JOptionPane.showInputDialog(msg));
            if (quantidade <= 0) {
                JOptionPane.showMessageDialog(null, "Digite um número maior que zero.", "Erro",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            for (int i = 1; i <= quantidade; i++) {
                boolean cadastrou = Funcionalidade.adicionarIngredientes(JOptionPane.showInputDialog("Nome: "));
                if (!cadastrou) {
                    JOptionPane.showMessageDialog(null, "Já existe esse ingrediente!!", "Erro",
                            JOptionPane.ERROR_MESSAGE);
                    i--;
                }
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Número inválido. Digite um número.", "Erro",
                    JOptionPane.ERROR_MESSAGE);
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

    private static Pizza criarPizzaVisual(String resposta) {
        try {
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

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Número inválido. Digite um número.", "Erro",
                    JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
}
