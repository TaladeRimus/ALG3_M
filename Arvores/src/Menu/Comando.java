package Menu;

/**
 *
 * @author Adriano Duarte
 *
 */

public enum Comando {
	
	INSERIR("inserir"),
	EXIBIR("exibir"),
	EMORDEM("emordem"),
	PREORDEM("preordem"),
	POSORDEM("posordem"),
	SAIR("sair");
	
	private String nome;

	private Comando(String nome){ 
		this.nome = nome; 
	
	}

	public String getNome(){ 
		return nome;
	}


}
