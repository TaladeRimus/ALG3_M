package Controller;

import Model.Ship;

public class Tabuleiro {		


	private String coluna = "A";
	private int linha = 1;
	private int pula = 0;
	private int coluna2;
	int pontos;
	Ship[][] tabuleiro = new Ship[10][10];




	public void attack(){
		for (int x = 0; x < tabuleiro.length; x++) {
			gambiarra();
			for (int y = 0; y < tabuleiro.length; y++) {
				if (tabuleiro[x][y].getDado() == "navio") {
					tabuleiro[x][y].setVisual("0");
					pontos = pontos + 3;
				} else {
					tabuleiro[x][y].setVisual("-");
					pontos = pontos - 1;
				}
			}
			if (pontos == 0) {
				System.out.println("GAME OVER");
				System.exit(0);
			}
		}

	}			


	public void criaNavios(){
		for (int x = 0; x < tabuleiro.length; x++) {
			for (int y = 0; y < tabuleiro.length; y++) {
				tabuleiro[x][y] = new Ship();
				tabuleiro[x][y].setVisual(".");
				if (x % 2 == 0) {
					tabuleiro[x][y].setDado("Navio");
				} else {
					tabuleiro[x][y].setDado("Agua");

				}
			}
		}
	}

	public void mostraTabuleiro() {
		for (int x = 0; x < tabuleiro.length; x++) {
			for (int y = 0; y < tabuleiro.length; y++) {
				System.out.print("\t" + tabuleiro[x][y].getVisual());
			}
			System.out.println("");
		}
	}

	/*public void criaMatriz(){

		// Escrita de Dados			
		for (int x = 0; x < tabuleiro.length; x++){
			for (int y = 0; y < tabuleiro[x].length; y++){
				tabuleiro[x][y] = coluna + linha;
				organiza();
			}
		}	
		// Leitura de Dados			
		for (int x = 0; x < tabuleiro.length; x++) {
			System.out.println();
			for (int y = 0; y < tabuleiro[x].length; y++) {
				System.out.print(tabuleiro[x][y] + "\t");

			}
		}		
	}*/

	/*private void organiza(){

		if(linha <= 10){
			linha++;
		}

		if(linha > 10){
			linha = 1;
			pula++;
		}

		if(pula == 0){
			coluna = "A";
		}
		if(pula == 1){
			coluna = "B";
		}
		if(pula == 2){
			coluna = "C";
		}
		if(pula == 3){
			coluna = "D";
		}
		if(pula == 4){
			coluna = "E";
		}
		if(pula == 5){
			coluna = "F";
		}
		if(pula == 6){
			coluna = "G";
		}
		if(pula == 7){
			coluna = "H";
		}
		if(pula == 8){
			coluna = "I";
		}
		if(pula == 9){
			coluna = "J";
		}


	}
	 */


	public String getColuna() {
		return coluna;
	}


	public void setColuna(String coluna) {
		this.coluna = coluna;
	}

	public int getLinha() {
		return linha;
	}


	public void setLinha(int linha) {
		this.linha = linha;
	}

	private int getCol(){
		return coluna2;
	}

	private void setCol(int coluna2){
		this.coluna2 = coluna2;
	}

	private void gambiarra(){
		if (getColuna().equals("A")) {
			setCol(1);
		}

		if (getColuna().equals("B")) {
			setCol(2);
		}
		if (getColuna().equals("C")) {
			setCol(3);
		}
		if (getColuna().equals("D")) {
			setCol(4);
		}
		if (getColuna().equals("E")) {
			setCol(5);
		}
		if (getColuna().equals("F")) {
			setCol(6);
		}
		if (getColuna().equals("G")) {
			setCol(7);
		}
		if (getColuna().equals("H")) {
			setCol(8);
		}
		if (getColuna().equals("I")) {
			setCol(9);
		}
		if (getColuna().equals("J")) {
			setCol(10);
		}

	}


	public int getPontos() {
		return pontos;
	}


	public void setPontos(int pontos) {
		this.pontos = pontos;
	}
	

}
