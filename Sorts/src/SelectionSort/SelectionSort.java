package SelectionSort;

import java.util.Scanner;


	/**
	 * 
	 * O selecton sort percorre todo o vetor
	 * Encontra o menor valor dento do indice
	 * E armazena no inicio do mesmo
	 * Após este processo, ele tenta encontrar o menor valor baseado no valor anterior
	 * E armazena na proxima posição e assim por diante
	 * 
	 * 
	 * @author adriano
	 *
	 */


public class SelectionSort {
	
	private static int[] vetor;
	private static int[] vetorSort;
	private static int tamVetor;
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("Digite o tamanho do vetor");
		tamVetor = sc.nextInt();
		
		vetor = new int[tamVetor];
		
		for (int i = 0; i < vetor.length; i++) {
			System.out.println("Digite o valor para o indice " + i + " :\n");
			vetor[i] = sc.nextInt();
			
		}
		
		System.out.println("Iniciando Selection Sort \n");
		
		vetorSort = selectionSort(vetor);
		
		for (int i : vetorSort ){
			
			System.out.print("[" + i + "]" + " - ");
			
		}
		
		
	}
	
	
	public static int[] selectionSort(int[] vet){
		
		
		for (int i = 0; i < vet.length - 1; i++) {
			int indice = i;
			
			for (int j = i + 1; j < vet.length; j++) {
				
				if(vet[j] < vet[indice]){
					
					indice = j;
					
				}
				
			}
			
			int menorNumero = vet[indice];
			vet[indice] = vet[i];
			vet[i] = menorNumero;
			
			
		}
		
		return vet;
		
		
		
	}
	
	
	
	
	
}
