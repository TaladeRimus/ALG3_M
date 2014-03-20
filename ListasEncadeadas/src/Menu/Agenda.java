package Menu;


import java.io.IOException;
import java.util.Scanner;
import Comandos.Comandos;
import Comandos.Funcoes;

/**
 * Classe principal do projeto
 * realiza todos os comandos atraves da classe enum 
 * 
 * 
 * @author adriano
 *
 */
public class Agenda {

	private static Scanner sc = new Scanner(System.in);
	private static Funcoes f = new Funcoes();


	public static void main(String[] args) {
		String opc;

		do{
			System.out.println("Agenda Telefonica\n" +
					"Comandos:\n" +
					"Listar\n" +
					"Adicionar\n" +
					"Remover\n" +
					"Pesquisar\n" +
					"Atualizar\n" +
					"Sair");

			opc = sc.next().toUpperCase();

			try {
				tipoComando(Comandos.valueOf(opc));
			} catch (Exception e) {
				System.err.println("Comando invalido");
			}

		}while(true);
	}



	private static void tipoComando(Comandos c) throws IOException {
		switch (c) { 
		case LISTAR:
			f.metodoListar();
			break;

		case ADICIONAR:
			f.metodoAdicionar();
			break;

		case REMOVER:
			//f.metodoRemover();
			System.err.println("Nao funciona");
			break;
		case PESQUISAR:
			f.metodoPesquisar();
			break;

		case SAIR:
			sc.close();
			System.exit(0);
			break;

		case ATUALIZAR:
			f.registraContato();
			break;


		default:
			System.out.println("Digite somente opcoes validas");
			break;
		}		
	}





}
