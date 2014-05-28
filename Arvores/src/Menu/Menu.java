package Menu;


import java.util.Scanner;

import Tree.Arvore;
import AVL.TreeAVL;


/**
 * 
 * @author Adriano Duarte
 *
 */

public class Menu {

	private static Scanner sc = new Scanner(System.in);
	private static int insere;
	private static Arvore tree = new Arvore();
	private static TreeAVL a = null;


	public static void main(String[] args) {

		System.err.println("Arvore AVL" + "\n \t \t" + "Adriano Duarte");


		String opc;

		do {

			System.out.println (
					
					"\n\n" +
					"Inserir" + "\n" +
					"Exibir" + "\n" +
					"Sair"
								
					);

			opc = sc.next().toUpperCase();

			try {
				tipoComando(Comando.valueOf(opc));
			} catch (Exception e) {
				System.err.println("COMANDO INVALIDO");
			}


		} while (true);

	}

	public static void tipoComando(Comando c){

		switch (c) {
		
		case INSERIR:
			
			int qtd;
			System.out.print("Digite a quantidade de insercoes desejada: ");
			qtd = sc.nextInt();
			
			do {
				
				System.out.print("Digite o valor a ser inserido: ");
				insere = sc.nextInt();
				a = tree.insert(a, insere);
				qtd--;
				
			} while (qtd!=0);
			
			break;

		case EXIBIR:
			
			System.out.println("\n");
			
			System.out.print("Exibicao Em Ordem: ");
			a.exibiremordem(a);
			System.out.println("\n");
			
			System.out.print("Exibicao Pre Ordem: ");
			a.exibirpreordem(a);
			System.out.println("\n");
		
			System.out.print("Exibicao Pos Ordem: ");
			a.exibirposordem(a);
			System.out.println("\n");

			
			break;

		case SAIR:
			
			System.err.println("PROGRAMA ENCERRADO");
			System.exit(0);
			break;

		default:
			System.err.println("COMANDO INVALIDO");
			break;
		}

	}

}
