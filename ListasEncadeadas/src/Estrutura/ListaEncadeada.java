package Estrutura;

import static java.lang.System.out;

import java.io.*;
import java.util.Scanner;

public class ListaEncadeada<T extends Comparable<T>> {

	private Nodo<T> head; // will be a Nodo
	private Nodo<T> tail; // will be a Nodo
	private Nodo<T> position;

	public Nodo<T> getHead()
	{
		return head;
	}

	public void print()
	{
		Nodo<?> nodo = head;
		do {
			out.println(nodo.getData());
			nodo = nodo.getNext();
		} while (nodo != null);
	}

	public void insert(Nodo<T> novo)
	{
		novo.setNext(head);
		head = novo;

		if (tail == null)
			tail = head;
	}

	public void insert(Nodo<T> novo, Nodo<T> anterior)
	{
		if (anterior == tail) {
			tail.setNext((Nodo<T>)novo);
			tail = novo;
		} else {
			novo.setNext(anterior.getNext());
			anterior.setNext(novo);
		}
	}


	public void append(Nodo<T> novo)
	{
		tail.setNext(novo);
		tail = novo;
	}

	public void removerPrimeiro(Nodo<T> out){
		
		if(head==null){
			System.out.println("lista vazia");
		}
		else{
			out = head;
			head = head.getNext();
			out.setNext(null);
		}
	}
	
	public void remover(Nodo<T> out, Nodo<T> out2){
		
		if(head==null){
			System.out.println("Lista vazia");
		}
		if(head == position){
			removerPrimeiro(out);
		}
		
		else{
			
			out = position.getNext(); // 1
			out.getNext(); // 2
			out2.setNext(out.getNext()); //3
			
		}
		
		
		
	}


}


