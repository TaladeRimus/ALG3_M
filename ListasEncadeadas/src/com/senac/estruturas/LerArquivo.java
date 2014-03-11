package com.senac.estruturas;

import java.io.*;

import java.util.Random;
import java.util.Scanner;

public class LerArquivo {
	public static void main(String[] args) {	

		try {
			String nome, telefone;
			Scanner sc = new Scanner(System.in);
			System.out.println("Digite o nome: ");
			nome = sc.next();
			System.out.println("Digite o telefone: ");
			telefone = sc.next();

			Writer fileWriter = new FileWriter("registros.txt", true);
			fileWriter.write("\n"+nome+ "\n" + telefone);
			fileWriter.close();

			Reader fileReader = new FileReader("registros.txt");
			BufferedReader br = new BufferedReader(fileReader);

			String registro = br.readLine();
			String campos[] = registro.split(";");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
}