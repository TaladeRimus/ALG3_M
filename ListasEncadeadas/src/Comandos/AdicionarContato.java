package Comandos;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Scanner;

import Estrutura.ListaOrdenada;
import Estrutura.Nodo;
	


	/**
	 * Metodo adiciona novos contatos no Nodo
	 * e no arquivo de registro
	 * 
	 */


public class AdicionarContato extends ListaOrdenada {
	
	
	Scanner sc = new Scanner(System.in);
	String nome;
	String telefone;
	
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
	
	
	
	
}
