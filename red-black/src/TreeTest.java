
public class TreeTest {


	public static void main(String[] args) {

		RedBlackTree<String> bt = new RedBlackTree<String>();
		

		bt.insere(new Nodo<String>("grandpa"));
		bt.insere(new Nodo<String>("father"));
		bt.insere(new Nodo<String>("uncle"));
		bt.insere(new Nodo<String>("son1"));
		bt.insere(new Nodo<String>("son2"));
		bt.insere(new Nodo<String>("son3"));
		bt.insere(new Nodo<String>("son4"));
		bt.insere(new Nodo<String>("son5"));
		bt.insere(new Nodo<String>("son6"));
		bt.insere(new Nodo<String>("son7"));
		bt.insere(new Nodo<String>("son8"));
		bt.insere(new Nodo<String>("son9"));

		
		bt.imprime();
		

	}

	
}
