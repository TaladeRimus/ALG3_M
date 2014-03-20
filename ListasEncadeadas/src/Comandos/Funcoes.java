package Comandos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Scanner;

import Estrutura.ListaOrdenada;
import Estrutura.Nodo;

public class Funcoes {


	Scanner sc = new Scanner(System.in);
	String nome;
	String telefone;

	/**
	 * Metodo adiciona novos contatos no Nodo
	 * e no arquivo de registro
	 * 
	 */

	public void metodoAdicionar() throws IOException{
		ListaOrdenada<String> lista = new ListaOrdenada<String>();

		Writer fileWriter = new FileWriter("registros.txt", true);			

		System.out.println("Digite o nome: ");
		nome = sc.next();
		lista.insert(new Nodo<String>(nome));
		fileWriter.write(nome);
		fileWriter.append(System.getProperty("line.separator"));


		System.out.println("Digite o telefone: ");
		telefone = sc.next();
		lista.insert(new Nodo<String>(telefone));
		fileWriter.write(telefone);
		fileWriter.append(System.getProperty("line.separator"));

		lista.print();
		fileWriter.close();

	}

	/**
	 * Metodo lista todos os contatos a partir do arquivo
	 * de registros. E mostra em ordem alfabetica a partir
	 * do metodo print da lista ordenada 
	 * 
	 * 
	 */

	public void metodoListar() throws IOException{

		Reader fileReader = new FileReader("registros.txt");
		BufferedReader br = new BufferedReader(fileReader);
		ListaOrdenada<String> lista = new ListaOrdenada();
		String showReg = null;

		while ((showReg = br.readLine()) != null) {
			System.out.println(showReg);


		}
	}	


	/**
	 * Metodo cria novo Nodo
	 * a partir do arquivo de registro
	 * 
	 * 
	 * @author adriano
	 *
	 */

	public void registraContato() throws IOException{

		Reader fileReader = new FileReader("registros.txt");
		BufferedReader br = new BufferedReader(fileReader);
		ListaOrdenada<String> lista = new ListaOrdenada();
		String showReg = null;

		while ((showReg = br.readLine()) != null) {

			lista.insert(new Nodo<String> (showReg) );

		}
		System.out.println("Agenda atualizada\n" +
				"Novos contatos: \n");
		lista.print();
	}


	/**
	 * Metodo pesquisar
	 * O metodo percorre todo o arquivo de registro
	 * se o nome digitado é igual a linha
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

			if(showReg.equalsIgnoreCase(digita)){
				System.out.println("Contatos encontrados: " + showReg);
				System.out.println("Voce deseja ver mais contatos?");
				digita = sc.next().toUpperCase();

				if(digita.equals("SIM")){
					Funcoes pc = new Funcoes();
					pc.metodoPesquisar();
				}

			}

		}	

	}


	/**
	 * 
	 * Metodo remover incompleto
	 * 
	 * 
	 */

	public void metodoRemover() throws IOException{
		Reader fileReader = new FileReader("registros.txt");
		BufferedReader br = new BufferedReader(fileReader);
		String lugar = null;
		System.out.println("Digite o contato a ser removido");
		lugar = sc.next().toUpperCase();

		//lo.findBefore(new Nodo<String> (lugar));







	}	


}
