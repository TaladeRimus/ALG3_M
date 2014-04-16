package QuickSort;

import java.util.Scanner;
	/**
	 * 
	 * O quick sort faz a divisão de um vetor
	 * armazenando o valor do indice do meio do vetor em uma variavel
	 * e verifica se o tudo o que esta a direita do vetor é maior
	 * e se tudo o que esta a esquerda do vetor é menor
	 * a partir das verificacoes, comeca a troca, verificando e organizando o vetor 
	 * 
	 * 
	 * @author adriano
	 *
	 */
public class QuickSort {

	//Declaracao das variaveis
	private static int[] vetor;
	private static int tamVetor;
	private static Scanner sc = new Scanner(System.in);


	public static void main(String[] args) {

		//Define o tamanho do vetor
		System.out.println("Digite o tamanho do vetor: ");
		tamVetor = sc.nextInt();
		vetor = new int[tamVetor];

		//Preenchimento do vetor
		for (int i = 0; i < vetor.length; i++) {

			System.out.println("Digite um valor no indice " + i + ": \n");
			vetor[i] = sc.nextInt();

		}


		//Chama o metodo para realizar o Quick Sort
		System.out.println("Comecando o Quick Sort");
		quick_sort(vetor, 0 ,vetor.length - 1);

		
		System.out.println("\n\n\n");
		System.out.println("Vetor depois do Quick Sort");

		//Mostra o vetor apos o sort
		for (int i = 0; i < vetor.length; i++) {
			System.out.println(vetor[i]);
		}

	}


	private static void quick_sort(int[] vetor, int l, int h) {

		int low = l;
		int high = h;
		
		
		//Se o valor de l for maior que o valor de h, encerra o bloco if
		if(low >= high){
			return;
		}
		
		//variavel auxiliar que recebe como indice a soma de l e h dividido por 2
		int aux = vetor[(low + high) / 2];
		
		
		//enquando o l for menor que h;
		while( low < high ){
			
			//enquanto l for menor que h e o vetor na posicao l for menor que aux, valor de low é acrescentado
			while( (low < high) && (vetor[low] < aux) ){
				low++;
			}
			//enquanto l for menor que h e o vetor na posicao h for maior que aux, valor de high é decrementado
			while( (low < high) && (vetor[high] > aux)){
				high--;
			}
			
			
			//se o valor de l for menor que o valor de h, low recebe valor de o valor de high e high recebe o valor de low
			if( low < high ){
				int aux2 = vetor[low];
				vetor[low] = vetor[high];
				vetor[high] = aux2;
			}


			
		}
			//se o valor de high for menor que o valor de low, high recebe o valor de low e low recebe valor de high
			if( high < low ){
				int aux2 = high;
				high = low;
				low = aux2;
			}
			
			//chamada do metodo colocando o vetor e os valores iniciais e finais de low
			quick_sort(vetor, l, low);
			
			//chamada do metodo colocando o vetor e verificando se low (final) é igual a l(inicial), 
													//se for verdadeiro, low ( final ) é acrescentado, 
													//se não, mantem o valor de low
			//e finalmente é inserido o valor de h
			quick_sort(vetor, low == l ? low + 1 : low, h);

	}

}
