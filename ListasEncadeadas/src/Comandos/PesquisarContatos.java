package Comandos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;

import Estrutura.ListaOrdenada;

public class PesquisarContatos extends ListaOrdenada {
	
	
	/**
	 * Metodo pesquisar incompleto
	 * O metodo percorre todo o arquivo de registro
	 * se o nome digitado � igual a linha
	 * o metodo mostra na tela
	 * se o nome nao existir
	 * pergunta ao usuario se quer criar um novo contato
	 * 
	 * @throws IOException
	 */

	public void metodoPesquisar() throws IOException{
		Scanner sc = new Scanner(System.in);
		Reader fileReader = new FileReader("registros.txt");
		BufferedReader br = new BufferedReader(fileReader);
		String showReg = null;

		System.out.println("Digite um nome");
		String digita = sc.next();
		
		while ((showReg = br.readLine()) != null) {
			
			if(showReg == digita){
				System.out.println("Contatos encontrados: " + showReg);
				System.out.println("Voce deseja ver mais contatos?");
				digita = sc.next().toUpperCase();
				
			if(digita != showReg){
				System.out.println("SUCESSO");
			}
				
			}
			
			/*else {
				System.out.println("Contato nao existe, deseja criar um novo?");
				digita = sc.next().toUpperCase();
				
				if(digita.equals("SIM")){
					AdicionarContato ac = new AdicionarContato();
					ac.metodoAdicionar();
					break;
				}
				else{break;}
			}*/
			
		}
		
		
		

	}
}
