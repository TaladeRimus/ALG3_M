package com.senac.estruturas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Scanner;

public class ListaOrdenada<T extends Comparable<T>> extends ListaEncadeada<T> {

	private Nodo<T> findBefore(Nodo<T> novo) {
		Nodo<T> atual = getHead();
		Nodo<T> anterior = null;

		while (atual != null) {
			int comp = atual.compareTo(novo);
			if (comp < 0) {
				anterior = atual;
				atual = atual.getNext();
			}
			if (comp == 0)
				return atual;
			if (comp > 0)
				return anterior;
		}

		return anterior;
	}

	@Override
	public void insert(Nodo<T> novo)
	{
		Nodo<T> anterior = findBefore(novo);
		if (anterior == null) {
			super.insert(novo);
		} else {
			super.insert(novo, anterior);
		}
	}


	@Override
	public void insert(Nodo<T> novo, Nodo<T> anterior)
	{
		insert(novo);
	}

	@Override
	public void append(Nodo<T> novo)
	{
		insert(novo);
	}


	public static void main(String[] args) {
		ListaOrdenada<String> lista = new ListaOrdenada<String>();

		/*	lista.insert(new Nodo<String>("Rafael"));
		lista.insert(new Nodo<String>("Tiago"), lista.getHead());
		lista.append(new Nodo<String>("Mauro"));
		lista.insert(new Nodo<String>("Carlos"));
		lista.insert(new Nodo<String>("Raffael"));
		lista.insert(new Nodo<String>("Rafael"));
		lista.insert(new Nodo<String>("Raphael"));


		lista.print();
		 */





		try {

			do{
				String nome, telefone;
				Scanner sc = new Scanner(System.in);
				int opc = -1;
				Writer fileWriter = new FileWriter("registros.txt", true);			
				Reader fileReader = new FileReader("registros.txt");
				BufferedReader br = new BufferedReader(fileReader);

				System.out.println("1 para cadastrar contatos na agenda\n"+ "2 para atualizar a lista\n" + "3 para ver contatos\n" +
						"0 para sair");
				opc = sc.nextInt();
				switch(opc){

				case 1:

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


					String registro = br.readLine();
					String campos[] = registro.split(";");

					break;

				case 2:
					String line = null;
					while ((line = br.readLine()) != null) {

						lista.insert(new Nodo<String>(line));
					}

					lista.print();

					break;

				case 3:
					String showReg = null;
					while ((showReg = br.readLine()) != null) {
						System.out.println(showReg);
					}
					System.out.println("/------------------METODO PRINT DA LISTA-------------------------/");
					lista.print();
					break;

				case 0:
					System.exit(0);
					sc.close();
					break;

				default:
					System.out.println("Opcao nao existe");
					break;
				}


			}while(true);


		} catch (IOException e) {
			e.printStackTrace();
		}












	}

}
