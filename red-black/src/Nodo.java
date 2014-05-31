public class Nodo<T extends Comparable<T>> {

	private Nodo<T> pai;
	private Nodo<T> avo;
	private Nodo<T> tio;
	private Nodo<T> irmao;
	private Nodo<T> esq;
	private Nodo<T> dir;
	private boolean cor;
	private T valor;

	public Nodo(T valor) {
		pai = null;
		esq = null;
		dir = null;
		this.valor = valor;
	}

	public void insere(Nodo<T> novo) {

		int cmp = novo.getValor().compareTo(valor);

		if (cmp < 0) { // insere a esquerda ( novo menor que valor )

			if (esq == null) {

				esq = novo;
				novo.setPai(this);



			} 

		
		}
		
		if (cmp > 0) { // insere a direita ( novo maior que valor )

			if (dir == null) {

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

	public T getValor() {
		return valor;
	}

	public void setValor(T valor) {
		this.valor = valor;
	}

	public void imprime() {

		System.out.print("( " + valor +" "+ cor+ "\n");

		if (esq != null) {

			esq.imprime();

		}

		else {
			System.out.print("( )");
		}

		if (dir != null) {

			dir.imprime();

		}

		else {
			System.out.print("( )");
		}

	}

	public boolean isCor() {
		return cor;
	}

	public void setCor(boolean cor) {
		this.cor = cor;
	}

	public Nodo<T> getEsq() {
		return esq;
	}

	public void setEsq(Nodo<T> esq) {
		this.esq = esq;
	}

	public Nodo<T> getDir() {
		return dir;
	}

	public void setDir(Nodo<T> dir) {
		this.dir = dir;
	}

	public Nodo<T> getPai() {
		return pai;
	}

	public Nodo<T> getTio() {
		return tio;
	}

	public Nodo<T> setTio(Nodo<T> nodo) {

		if ( nodo.getAvo() == null ) {
			
			return null;
			
		}
		
		else {
			
			if( nodo.getPai() == nodo.esq ) {
				
				return nodo.dir;
				
			}
			
			else {
				
				return nodo.esq;
								
			}
			
		}
		
	}

	public Nodo<T> getAvo() {
		return avo;
	}

	public Nodo<T> setAvo(Nodo<T> nodo) {
		
		if ( nodo != null){
			
		return	nodo = nodo.getPai().getPai();
		
		}
		
		else {
			return null;
		}
	}

	public Nodo<T> getIrmao() {
		return irmao;
	}

	public Nodo<T> setIrmao(Nodo<T> nodo) {
		
		if ( ( nodo.getPai().dir != null ) && ( nodo.getPai().dir != nodo ) ) {
			
			return nodo.dir;
			
		}
		
		else {

			return nodo.esq;
			
		}
		
	}
}