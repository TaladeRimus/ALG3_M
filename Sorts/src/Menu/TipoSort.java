package Menu;

	/**
	 * Classe enum cria opcoes para o menu
	 *
	 * @author adriano
	 *
	 */

public enum TipoSort {
	
	
	QUICK("quick"),
	SELECTION("selection"),
	VOLTAR("voltar"),
	SAIR("sair");
	
	String escolha;
	
	TipoSort(String escolha){
		this.escolha = escolha;
	}

	public String getEscolha() {
		return escolha;
	}

	public void setEscolha(String escolha) {
		this.escolha = escolha;
	}
	
	
	
}
