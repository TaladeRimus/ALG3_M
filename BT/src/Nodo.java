
public class Nodo<T extends Comparable<T>> {

	private Nodo<T> pai;
	private Nodo<T> esq;
	private Nodo<T> dir;
	private T valor;


	public Nodo(T valor){
		pai = null;
		esq = null;
		dir = null;
		this.valor = valor;
	}

	public void insere(Nodo<T> novo){

		int cmp = novo.getValor().compareTo(valor);

		if ( cmp < 0){ // insere a esquerda ( novo menor que valor )

			if ( esq == null ) {
				esq = novo;
				novo.setPai(this);
			}

			else {
				
				esq.insere(novo);
				
			}
			
		}

		if ( cmp > 0 ){ // insere a direita ( novo maior que valor )

			if ( dir == null ) {
				
				dir = novo;
				
				novo.setPai(novo);
			
			}

			else {
			
				dir.insere(novo);
			
			}
			
		}


		return;		
	}


	private void setPai(Nodo<T> nodo) {
		pai = nodo;		
	}


	public T getValor(){
		return valor;
	}

	public void setValor(T valor){
		this.valor = valor;
	}

	public void imprime(){

		System.out.print("( " + valor );

		if ( esq != null ) {

			esq.imprime();

		}

		else {
			System.out.print("( )");
		}

		if ( dir != null ){

			dir.imprime();

		}

		else {
			System.out.print("( )");
		}

	}
	
	public Nodo<T> getEsq(){
		return esq;
	}
	
	public Nodo<T> getDir(){
		return dir;
	}
	

	
	public boolean isInterno(){
	
		if( pai.getDir() != null){
			return true;
		}
		
		if( pai.getEsq() != null ){
			return true;
		}
		
		return false;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}