package Menu;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;
import Comandos.AdicionarContato;
import Comandos.Comandos;
import Comandos.ListarContatos;
import Comandos.PesquisarContatos;
import Comandos.RegistraContatos;
import Comandos.RemoverContatos;
import Estrutura.ListaOrdenada;
import Estrutura.Nodo;

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
	private static AdicionarContato ac = new AdicionarContato();
	private static ListarContatos lc = new ListarContatos();
	private static RemoverContatos rc = new RemoverContatos();
	private static PesquisarContatos pc = new PesquisarContatos();
	private static RegistraContatos regc = new RegistraContatos();
	private static ListaOrdenada<String> lo = new ListaOrdenada();
	
	
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
			lc.metodoListar();
			break;

		case ADICIONAR:
			ac.metodoAdicionar();
			break;

		case REMOVER:
			rc.metodoRemover();
			break;
		case PESQUISAR:
			pc.metodoPesquisar();
			break;

		case SAIR:
			sc.close();
			System.exit(0);
			break;
			
		case ATUALIZAR:
			regc.registraContato();
			break;
		
			
		default:
			System.out.println("Digite somente opcoes validas");
			break;
		}		
	}





}
