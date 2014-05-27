
public class NodoAVL<T extends Comparable<T>> extends Nodo<T> {



	private Nodo raiz;
	private int hEsq;
	private int hDir;
	private int h;

	public NodoAVL(T valor) {

		super(valor);

	}

	@Override
	public void insere(Nodo<T> novo ){

		super.insere(novo);
		validarAVL();
	}

	private void validarAVL(){

		hEsq = calculaAltura(getEsq());
		hDir = calculaAltura(getDir());
		altura();
		fatorBalanceamento();

	}

	public int altura() {
		return calculaAltura(this.raiz);
	}

	private int calculaAltura(Nodo elemento) {

		if (elemento != null) {

			if (isInterno()) {

				int auxa = calculaAltura(getEsq()) + (h + 1);
				int auxb = calculaAltura(getDir()) + (h + 1);

				if (auxa > auxb) {
					
					return auxa;
					
				}

				else {
					
					return auxb;
				}
				
			} 
			
			else {
				
				return h;
				
			}
		}
		
		return 0;
	}
	
	private int fatorBalanceamento(){
		
		hEsq = calculaAltura(getEsq());
		hDir = calculaAltura(getDir());
		
		return (hEsq) - (hDir);
	}

}
