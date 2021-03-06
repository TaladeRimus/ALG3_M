package Estrutura;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Scanner;

public class ListaOrdenada<T extends Comparable<T>> extends ListaEncadeada<T> {

	public Nodo<T> findBefore(Nodo<T> novo) {
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

		lista.insert(new Nodo<String>("Rafael"));
		lista.insert(new Nodo<String>("Tiago"), lista.getHead());
		lista.append(new Nodo<String>("Mauro"));
		lista.insert(new Nodo<String>("Carlos"));
		lista.insert(new Nodo<String>("Raffael"));
		lista.insert(new Nodo<String>("Rafael"));
		lista.insert(new Nodo<String>("Raphael"));
		

		lista.print();
		 





	
	}

}
