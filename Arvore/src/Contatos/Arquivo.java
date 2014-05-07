package Contatos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Scanner;

import Estrutura.Arvore;
import Estrutura.Elemento;



public class Arquivo {


	Scanner sc = new Scanner(System.in);
	static Arvore tree = new Arvore(null);
	String nome = null;
	Elemento e;
	
	
	
	public void metodoAdicionar() throws IOException{

		Pessoa p = new Pessoa();
		Writer fileWriter = new FileWriter("contatos.txt", true);	

		if(tree.getRaiz() == null){
			System.out.println("Digite o nome raiz: ");
			nome = sc.next();
			p.setNome(nome);
			fileWriter.write(p.getNome());
			fileWriter.append(System.getProperty("line.separator"));
			e = new Elemento(p.getNome());
			tree.setRaiz(e);
			System.out.println("Altura" + tree.Altura());
		}

		else{
			
			System.out.println("Digite o nome: ");
			nome = sc.next();
			p.setNome(nome);
			tree.InserirElemento(p.getNome());
			fileWriter.write(p.getNome());
			System.out.println("Altura" + tree.Altura());


			fileWriter.append(System.getProperty("line.separator"));

			tree.Imprimir();
			fileWriter.close();
		}
		
	}
	
	public void insereRegistros() throws IOException{
		
		
		Reader fileReader = new FileReader("contatos.txt");
		BufferedReader br = new BufferedReader(fileReader);
		String showReg = null;

		while ((showReg = br.readLine()) != null) {
			
			if(tree.getRaiz() == null){
				e = new Elemento(showReg);
				tree.setRaiz(e);				
			}
			
			else{
				tree.InserirElemento(showReg);
			}


		}
		tree.Imprimir();
	}
	
	public static void main(String[] args) throws IOException {
		Arquivo a = new Arquivo();
		a.insereRegistros();
	}
	

	
	
}
