package Comandos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;

import Estrutura.ListaOrdenada;
import Estrutura.Nodo;
	

	/**
	 * 
	 * Metodo remover incompleto
	 * 
	 * 
	 */

public class RemoverContatos extends ListaOrdenada {
	Scanner sc = new Scanner(System.in);
	ListaOrdenada<String> lo = new ListaOrdenada();
	String showReg = null;
	
	
	public void metodoRemover() throws IOException{
		Reader fileReader = new FileReader("registros.txt");
		BufferedReader br = new BufferedReader(fileReader);
		String lugar = null;
		System.out.println("Digite o contato a ser removido");
		lugar = sc.next().toUpperCase();
		
		//lo.findBefore(new Nodo<String> (lugar));
		

			
		
		
		
		
	}	
	
}
