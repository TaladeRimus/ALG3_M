package Controller;



public enum Comandos {
	ATACAR("atacar"),
	PONTUACAO("pontucao"),
	TABULEIRO("tabuleiro"),
	SAIR("sair");
	
	String comando;
	
	Comandos(String comando){
		this.comando = comando;
	}

	public String getComando() {
		return comando;
	}

	public void setComando(String comando) {
		this.comando = comando;
	}
	
}
