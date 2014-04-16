package Menu;

import java.io.IOException;
import java.util.Scanner;
import QuickSort.QuickSort;
import SelectionSort.SelectionSort;

	/**
	 * Classe menu
	 * Chama o metodo main de cada classe
	 * 
	 * @author adriano
	 *
	 */

public class Menu {
	
	private static Scanner sc = new Scanner(System.in);
	private static String opc;
	
	public static void main(String[] args) {
		
		do {
			
			System.out.println("Digite um opcao \n"+
							   "SELECTION \n" +
						       "QUICK \n" +
							   "SAIR \n");
			
			opc = sc.next().toUpperCase();
			
			try {

				tipoSort(TipoSort.valueOf(opc));
				
			} catch (Exception e) {
				System.err.println("Comando invalido");
			}
			
			
		} while (true);
		
		
		
		
	}
	
	
	private static void tipoSort(TipoSort ts) throws IOException{
		
		switch (ts) {
		case QUICK:
			QuickSort.main(null);
			break;
			
		case SELECTION:
			SelectionSort.main(null);
			break;
					
		case SAIR:
			System.exit(0);
			break;
			
			
		default:
			break;
		}
		
		
		
		
	}


}
