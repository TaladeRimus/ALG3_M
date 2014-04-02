package View;

import java.io.IOException;
import java.util.Scanner;

import Controller.Comandos;
import Controller.Tabuleiro;

public class Menu {
	static Tabuleiro tab = new Tabuleiro();
	static String c = "";
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {

		tab.criaNavios();

		do{
			System.out.println("Batalha Naval 1.0"+"\n"+
					"Acoes: \n"+
					"Atacar \n"+
					"Tabuleiro \n"+
					"Pontucao \n");

			c = sc.next().toUpperCase();

			try {
				tipoComando(Comandos.valueOf(c));
			} catch (IOException e) {
				System.err.println("COMANDO INVALIDO");
			}
		}while(true);

	}

	private static void tipoComando(Comandos c) throws IOException{
		String coluna; 
		int linha;
		switch (c) {
		case ATACAR:
			
			System.out.println("Escolha a coluna para a coordenada\n");
			System.err.println("Apenas letras de A a J\n");
			coluna = sc.next().toUpperCase();
			tab.setColuna(coluna);
			
			System.out.println("Agora escolha o numero para a coordenada\n");
			System.err.println("Apenas numeros de 1 a 10\n");
			linha = sc.nextInt();
			tab.setLinha(linha);
			
			tab.attack();
			break;
			
		case TABULEIRO:
			tab.mostraTabuleiro();
			break;
			
		case PONTUACAO:
			System.out.println(tab.getPontos());
			break;
			
		case SAIR:
			System.exit(0);
			break;
			
		default:
			System.out.println("COMANDO INVALIDO");
			break;
		}



	}

}
