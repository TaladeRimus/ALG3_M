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
	private static SelectionSort ss = new SelectionSort();
	private static QuickSort qs = new QuickSort();
	
	public static void main(String[] args) {
		
		do {
			
			System.out.println("\nDigite uma opcao \n"+
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
			qs.executaQuick();
			break;
			
		case SELECTION:
			ss.executaSelection();
			break;
					
		case SAIR:
			System.exit(0);
			break;
			
			
		default:
			break;
		}
		
		
		
		
	}


}
