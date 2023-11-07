/* Componentes:
 * Gigliarly
 * Daniel
 * Marcio
 * Pedro Lucas
 * Pedro Henrique
*/
package com.grupo;

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
				JOptionPane.showInputDialog(null, Funcionalidade.mostrarIngredientes());
				String nome;
				Ingrediente[] ingredientes;
			}else if(opcao == 4) {
				JOptionPane.showMessageDialog(null, Funcionalidade.mostrarIngredientes());
			}
			
		}while(opcao!=6);
	}

}
