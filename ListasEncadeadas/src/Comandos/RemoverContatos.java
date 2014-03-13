package Comandos;

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
	
	
	
	public void metodoRemover(){
		String lugar = null;
		System.out.println("Digite o contato a ser removido");
		lugar = sc.next();
		lo.findBefore(new Nodo<String> (lugar));
		
		
		
	}	
	
}
