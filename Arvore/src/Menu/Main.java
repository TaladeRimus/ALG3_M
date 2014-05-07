package Menu;

import java.io.IOException;
import java.util.Scanner;

import Contatos.Arquivo;
import Estrutura.Arvore;

public class Main {

	Scanner input = new Scanner(System.in);

	static Arquivo a = new Arquivo();



	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String opc;
		
		do{
			System.out.println("Arvore\n" +
							   "Comandos:\n" +
							   "Adicionar\n" +
							   "Registrar\n" +
							   "Posfixa\n" +
							   "Prefixa\n" +
							   "Infixa\n" +
							   "Altura\n" +
							   "Sair");

			opc = sc.next().toUpperCase();

			try {
				tipoComando(Comandos.valueOf(opc));
			} catch (Exception e) {
				System.err.println("Comando invalido");
			}

		}while(true);
	}


	public static void tipoComando(Comandos c) throws IOException{

		switch (c) {
		case ADICIONAR:
			a.metodoAdicionar();
			break;

		case REGISTRAR:
			a.insereRegistros();
			break;

		case POSFIXA:
			Arvore.PostOrder(Arvore.getRaiz());
			break;

		case PREFIXA:
			Arvore.PreOrder(Arvore.getRaiz());
			break;

		case INFIXA:
			Arvore.InOrder(Arvore.getRaiz());
			break;

		case ALTURA:
			System.out.println(Arvore.Altura());
			break;

		case SAIR:
			System.exit(0);
			break;

		default:
			System.err.println("Opcao invalida");
			break;
		}

	}



}