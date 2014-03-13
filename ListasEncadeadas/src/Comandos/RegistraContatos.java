package Comandos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import Estrutura.ListaOrdenada;
import Estrutura.Nodo;
/**
 * Metodo cria novo Nodo
 * a partir do arquivo de registro
 * 
 * 
 * @author adriano
 *
 */
public class RegistraContatos {

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
}
