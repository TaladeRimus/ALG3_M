package Comandos;

	/**
	 * Enum para o menu
	 * 
	 * @author adriano
	 *
	 */

public enum Comandos {
	LISTAR("listar", "1"),
	ADICIONAR("adicionar", "2"),
	REMOVER("remover", "3"),
	PESQUISAR("pesquisar", "4"),
	ATUALIZAR("atualizar", "5"),
	SAIR("sair", "0");

	private String nome;
	private String numero; 

	private Comandos(String nome, String numero){ 
		this.nome = nome; 
		this.numero = numero;
	}

	public String getNome(){ 
		return nome;
	}

	public String getNumero() {
		return numero;
	}

}
