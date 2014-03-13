package Comandos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import Estrutura.ListaOrdenada;
import Estrutura.Nodo;

	/**
		 * Metodo lista todos os contatos a partir do arquivo
		 * de registros. E mostra em ordem alfabetica a partir
		 * do metodo print da lista ordenada 
		 * 
		 * 
		 */
public class ListarContatos extends ListaOrdenada {
	
	public void metodoListar() throws IOException{
		
		
		
		
		Reader fileReader = new FileReader("registros.txt");
		BufferedReader br = new BufferedReader(fileReader);
		ListaOrdenada<String> lista = new ListaOrdenada();
		String showReg = null;
		
		while ((showReg = br.readLine()) != null) {
			System.out.println(showReg);
			
			
		}
		
		
	}	
}
