package PesquisaInteiro;
import java.util.*;



public class PesquisaBinariaInteiro {
	
	static int tentativa;
	public static void main(String[] args) {
		int[] vetor = new int[5];
		int searchValue = 0, indice;
		Scanner sc = new Scanner(System.in);

		System.out.println("Digite 5 numeros");

		for (int i = 0; i < vetor.length; i++) {
			vetor[i] =  sc.nextInt();
		}

		System.out.println("Digite um numero para procurar");

		searchValue = sc.nextInt();

		indice = pesquisaBinaria(vetor, searchValue);

		if(indice != -1 ){
			System.out.println("Encontrado no indice: " + indice);
			System.out.println("Quantidade de tentativas: " + tentativa);
		}
		else{
			System.out.println("Nao encontrado");
		}


		sc.close();
	}

		public static int pesquisaBinaria(int[] procuraVetor, int encontra) {

		int comeca, termina, midPt;
		comeca = 0;		
		termina = procuraVetor.length;

		while(comeca <= termina){
			midPt = ( comeca + termina) / 2;

			if(procuraVetor[midPt] == encontra){
				return midPt;
			}

			else if(procuraVetor[midPt] < encontra){
				comeca = midPt + 1;
			}

			else{
				termina = midPt -1;
			}
			
			tentativa++;
		}

		
		return -1;
		
	}




}
