package Controller;

import Model.Ship;

public class Tabuleiro {		


	private String coluna;
	private int linha = 1;
	private int coluna2;
	int pontos = 15;
	Ship[][] tabuleiro = new Ship[10][10];




	public void attack(){
		for (int x = 0; x < tabuleiro.length; x++) {
			for (int y = 0; y < tabuleiro.length; y++) {
				gambiarra();	

				if((x == getCol()) && (y == getLinha())){
					if (tabuleiro[x][y].getDado() == "navio") {
						tabuleiro[x][y].setVisual("0");
						pontos = pontos + 3;
						setPontos(pontos);
					} else {
						tabuleiro[x][y].setVisual("-");
						pontos = pontos - 1;
						setPontos(pontos);
					}
				}
				if (pontos == 0) {
					System.out.println("GAME OVER");
					System.exit(0);
				}
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
			setCol(0);
		}

		if (getColuna().equals("B")) {
			setCol(1);
		}
		if (getColuna().equals("C")) {
			setCol(2);
		}
		if (getColuna().equals("D")) {
			setCol(3);
		}
		if (getColuna().equals("E")) {
			setCol(4);
		}
		if (getColuna().equals("F")) {
			setCol(5);
		}
		if (getColuna().equals("G")) {
			setCol(6);
		}
		if (getColuna().equals("H")) {
			setCol(7);
		}
		if (getColuna().equals("I")) {
			setCol(8);
		}
		if (getColuna().equals("J")) {
			setCol(9);
		}

	}


	public int getPontos() {
		return pontos;
	}


	public void setPontos(int pontos) {
		this.pontos = pontos;
	}


}
