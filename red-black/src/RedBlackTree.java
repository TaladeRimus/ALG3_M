public class RedBlackTree<T extends Comparable<T>> {

	private Nodo<T> raiz;


	/**
	 * @author Adriano
	 * 
	 * True = preto
	 * False = vermelho
	 *  
	 */

	public void insere(Nodo<T> novo) {

		if (raiz == null) { 

			raiz = novo;
			raiz.setCor(true); //raiz preta

		}

		else {

			raiz.insere(novo);

			
			casoUm(novo);
		
		}


	}

	public void imprime() {

		raiz.imprime();

	}


	private void casoUm(Nodo<T> novo) {

		if ( novo.getPai() == null ) {

			novo.setCor(true);

		}
		
		else {
			
			casoDois(novo);
			
		}
		
	}
	/*----- caso 2 ------*/
	private void casoDois(Nodo<T> novo) {

		if (novo.getPai().isCor()) {

			return; /*---arvore ainda e valida---*/
			
		}

		else {

			casoTres(novo);

		}

	}

	/*----- caso 3 ------
	 * Se P e R(red) e o U é R(red):

		Troca Cor P,U e G

		N=G

		Volta para o Caso 1

	 */

	private void casoTres(Nodo<T> novo) {

		Nodo<T> tio = novo.setTio(novo);


		if ( ( tio != null) && ( tio.isCor() == false) ) {
			
			System.out.println("entrou");

			novo.getPai().setCor(true); // black
			novo.getTio().setCor(true); // black
			
			
			novo.setAvo(novo);
			
			novo.getAvo().setCor(false); // red
			casoUm(novo.getAvo());
			
		}
		
		else {
			
			casoQuatro(novo);
			
		}

	}

	private void casoQuatro(Nodo<T> novo) {
		
		Nodo<T> avo = novo.setAvo(novo);
		
		if ( ( novo == novo.getPai().getDir() ) && ( novo.getPai() == avo.getEsq() ) ){
			
			rotacionar_esquerda(novo.getPai());
			novo = novo.getEsq();
			
		}
		
		else if ( ( novo == novo.getPai().getEsq() ) && ( novo.getPai() == novo) ) {
			
			rotacionar_direita(novo.getPai());
			novo = novo.getDir();
			
		}
		
		casoCinco(novo);
		
	}


	private void casoCinco(Nodo<T> novo) {
		
		Nodo<T> avo = novo.setAvo(novo);
		
		novo.getPai().setCor(false);
		avo.setCor(true);
		
		if ( ( novo == novo.getPai().getEsq() ) && ( novo.getPai() == avo.getEsq()) ) {
			
			rotacionar_direita(avo);
			
		}
		
		else {
			
			rotacionar_esquerda(avo);
			
		}
		
	}

	private void rotacionar_direita(Nodo<T> rot) {
		
		Nodo<T> rotEsq = rot.getEsq();
		Nodo<T> rotDir = rot.getDir();
		rot.getEsq().getPai();
		rot.getPai();
		
		
		
		troca(rot, rotEsq);
		rotEsq = rotDir;
		
		if ( rotEsq.getEsq() != null ) {
			
		}
		
		rotDir = rot;
		
			
	}

	private void rotacionar_esquerda(Nodo<T> rot) {
		
		Nodo<T> rotEsq = rot.getEsq();
		Nodo<T> rotDir = rot.getDir();
		rot.getDir().getPai();
		rot.getPai();
		
		
		
		troca(rot, rotDir);
		rotDir = rotEsq;
		
		if ( rotDir.getDir() != null ) {
			
		}
		
		rotEsq = rot;
		
		
	}
	
	private void troca(Nodo<T> novo, Nodo<T> velho){
		
		velho.getPai().getEsq();
		velho.getPai().getDir();
		novo.getPai();
		
		if ( velho.getPai() == null) {
			raiz = novo;
		}
		
		else {
			
			if ( velho == velho.getPai().getEsq() ) {
				
			}
			
			else {
				
			}
			
		}
		
		if ( novo != null ) {
			
			velho.getPai();
			
		}
		
		
	}


}
