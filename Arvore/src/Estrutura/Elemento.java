package Estrutura;

public class Elemento {

	// Atributos
	private String Valor;
	private Elemento ElementoDireito;
	private Elemento ElementoEsquerdo;

	// Contrutor recebe um valor como par�metro
	public Elemento(String valor2){
		this.Valor = valor2;
		this.ElementoDireito = null;
		this.ElementoEsquerdo = null;
	}

	// M�todos SET
	public void setValor(String Valor){
		this.Valor = Valor;
	}

	public void setElementoEsquerdo(Elemento ElementoEsquerdo){
		this.ElementoEsquerdo = ElementoEsquerdo;
	}

	public void setElementoDireito(Elemento ElementoDireito){
		this.ElementoDireito = ElementoDireito;
	}

	// M�todos GET 
	public int getValor(){
		return this.Valor.length();
	}

	public Elemento getElementoEsquerdo(){
		return this.ElementoEsquerdo;
	}

	public Elemento getElementoDireito(){
		return this.ElementoDireito;
	}
	
	public String returnValor(){
		return Valor;
	}
	
	// M�todo para verificar se nodo � interno
	public boolean Interno(){
		if((ElementoEsquerdo != null) || (ElementoDireito != null))
			return true;
		return false;
	}

}