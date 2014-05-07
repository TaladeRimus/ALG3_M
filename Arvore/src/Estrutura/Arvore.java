package Estrutura;
import java.util.ArrayList;

public class Arvore {

	
	private static Elemento raiz;

	
	public Arvore(Elemento raiz) {
		this.raiz = raiz;
	}

	
	public void setRaiz(Elemento raiz) {
		this.raiz = raiz;
	}

	
	public static Elemento getRaiz() {
		return raiz;
	}

	// M�todo para inserir um novo elemento na �rvore
	public void InserirElemento(String i) {

		// O caminhamento na arvore vai come�ar a partir da raiz
		Elemento ElementoAux = raiz;

		// Cria um novo elemento com o valor a ser inserido
		Elemento NovoElemento = new Elemento(i);

		// Inicia o caminhamento na �rvore
		while (ElementoAux != null) {

			// Verifica se o valor a ser inserido � maior que o valor do
			// elemento atual
			if (i.length() > ElementoAux.getValor()) {
				// Verifica se elemento direito � diferente de nulo
				if (ElementoAux.getElementoDireito() != null) // Se sim, pega o
															// elemento
															// direito para
															// continuar a
															// 	busca
					ElementoAux = ElementoAux.getElementoDireito();
				else { // Se n�o, insere o elemento como o elemento direito
					ElementoAux.setElementoDireito(NovoElemento);
					ElementoAux = null;
				}
				// Valor a ser inserido menor que o valor do elemento atual
			} else {
				// Verifica se elemento esquero � diferente de nulo
				if (ElementoAux.getElementoEsquerdo() != null) // Se sim, pega o
															// elemento
															// esquerdo para
															// continuar a
															// busca
					ElementoAux = ElementoAux.getElementoEsquerdo();
				else { // Se n�o, insere o elemento como o elemento esquerdo
					ElementoAux.setElementoEsquerdo(NovoElemento);
					ElementoAux = null;
				}
			}
		}
	}

	// M�todo para fazer o caminhamento "PreOrder"
	public static void PreOrder(Elemento elemento) {
		if (elemento != null) {
			System.out.print("\t" + elemento.returnValor());
			if (elemento.Interno()) {
				PreOrder(elemento.getElementoEsquerdo());
				PreOrder(elemento.getElementoDireito());
			}
		}
	}

	// M�todo para fazer o caminhamento "PostOrder"
	public static void PostOrder(Elemento elemento) {
		if (elemento != null) {
			if (elemento.Interno()) {
				PostOrder(elemento.getElementoEsquerdo());
				PostOrder(elemento.getElementoDireito());
			}
			System.out.print("\t" + elemento.returnValor());
		}
	}

	// M�todo para fazer o caminhamento "InOrder"
	public static void InOrder(Elemento elemento) {
		if (elemento != null) {
			if (elemento.Interno()) {
				InOrder(elemento.getElementoEsquerdo());
			}
			System.out.print("\t" + elemento.returnValor());
			if (elemento.Interno()) {
				InOrder(elemento.getElementoDireito());
			}
		}
	}

	// M�todo chamado para calcular Altura da �rvore
	public static int Altura() {
		return CalculaAltura(raiz, 0);
	}

	// M�todo para calcular a Altura da �rvore
	private static int CalculaAltura(Elemento elemento, int altura) {
		// Verifica se elemento � diferente de nulo
		if (elemento != null) {

			// Verifica se elemento atual � um elemento interno
			if (elemento.Interno()) {
				int AlturaAux1, AlturaAux2;
				// Chama o m�todo para Calcular altura recursivamente, enviando
				// o elemento esquerdo e a altura atual + 1
				AlturaAux1 = CalculaAltura(elemento.getElementoEsquerdo(),
						altura + 1);

				// Chama o m�todo para Calcular altura recursivamente, enviando
				// o elemento direito e a altura atual + 1
				AlturaAux2 = CalculaAltura(elemento.getElementoDireito(),
						altura + 1);

				// Verifica qual dos lados teve a maior altura e retorna
				if (AlturaAux1 > AlturaAux2)
					return AlturaAux1;
				else
					return AlturaAux2;

				// Se elemento atual � um elemento externo, apenas retorna a
				// altura recebida
			} else {
				return altura;
			}
		}
		return 0;
	}

	// M�todo Auxiliar do m�todo para imprimir
	// M�todo Cria um Array onde cada posi��o do array representa um n�vel da
	// arvore.
	private ArrayList<Object> BuscaPai() {

		// Cria um array de niveis
		ArrayList<Object> ArrayNiveis = new ArrayList<Object>();

		// Cria um array auxiliar para fazer o la�o
		ArrayList<Object> ArrayAux = new ArrayList<Object>();
		ArrayAux.add(this.raiz); // Inicia o array com o elemento Raiz

		ArrayNiveis.add(ArrayAux); // Adiciona no array de niveis o array
								   // contendo o elemento raiz

		
		while (ArrayAux.size() >= 1) {

			// Cria um array para receber o array do m�todo BuscaFilhos
			ArrayList<Object> arrayFilhos = new ArrayList<Object>();

			
			arrayFilhos = BuscaFilhos(ArrayAux);

			// Adiciona o array recebido no array de n�veis
			ArrayNiveis.add(arrayFilhos);

			// Verifica se o conteudo do array recebido tem algum elemento
			// v�lido, n�o nulo
			boolean Flag = false;
			for (int i = 0; i < arrayFilhos.size(); i++) {
				if (arrayFilhos.get(i) != null) {
					Flag = true; // Existe elemento v�lido
					break;
				}
			}

			// Se existe elemento v�lido, seta o array auxiliar com o array
			// recebido pelo m�todo BuscaFilhos
			if (Flag)
				ArrayAux = arrayFilhos;
			else { // Se n�o existe elemento v�lido, remove esse �ltimo array do
				// array de n�veis
				ArrayNiveis.remove(ArrayNiveis.indexOf(arrayFilhos));
				break;
			}
		}

		
		return ArrayNiveis;
	}

	// M�todo Auxiliar do M�todo BuscaPai
	// M�todo cria um array de filhos de acordo com o array passado
	private ArrayList<Object> BuscaFilhos(ArrayList<Object> array) {

		// Cria um novo array de filhos
		ArrayList<Object> arrayNovo = new ArrayList<Object>();

		// Percorre o array passado, adicionando no novo array o filho da
		// esquerda e da direita
		for (int i = 0; i < array.size(); i++) {
			// Recupera o elemento do array
			Elemento ElementoAux = (Elemento) array.get(i);

			// Verifica se elemento � diferente de nulo
			if (ElementoAux != null) { // Se sim, adiciona o elemento esquerdo e
									   // direito no novo array
				arrayNovo.add(ElementoAux.getElementoEsquerdo());
				arrayNovo.add(ElementoAux.getElementoDireito());
			} else { // Se n�o, adiciona dois valores nulos no novo array,
					 // indicando que n�o tem filhos
				arrayNovo.add(null);
				arrayNovo.add(null);
			}
		}

		
		return arrayNovo;
	}

	// M�todo para imprimir a �rvore
	public void Imprimir() {

		
		ArrayList<Object> array = BuscaPai();

		// Verifica o tamanho do array da ultima posi��o do array de n�veis
		ArrayList<Object> arraySize = (ArrayList<Object>) array.get(array
				.size() - 1);

		
		int tamanho = arraySize.size();


		for (int i = 0; i < array.size(); i++) {

			// Recupera o array da posi��o atual do array de niveis
			ArrayList<Object> array2 = (ArrayList<Object>) array.get(i);

			
			tamanho = tamanho / 2;

			if (i == array.size() - 1)
				System.out.printf(" ");

			for (int j = 0; j < array2.size(); j++) {

				int espacos; // Variavel que conter� quantos "\t" ser�o
				// necess�rios para desenhar o n�vel atual

				if (j == 0) // Se for o primeiro �ndice do FOR, recebe o pr�prio
							// tamanho
					espacos = tamanho;
				else
							// Se n�o, recebe o tamanho * 2
					espacos = tamanho * 2;

				// Percorre o n�mero de espa�os tabulando a impress�o
				for (int k = 1; k <= espacos; k++)
					System.out.printf("\t");

				// Verifica se � o �ltimo n�vel que est� sendo impresso na tela
				if ((i == array.size() - 1) && (j != 0))
					System.out.printf("\t "); // Se sim, insere alguns espa�os
											// depois da tabula��o

				// Recupera o elemento para recuperar o valor
				Elemento NovoElemento = (Elemento) array2.get(j);

				
				if (NovoElemento != null)
					System.out.print(NovoElemento.returnValor()); // Imprime
																	// o
																	// valor
																	// do
																	// elemento
				else
					System.out.printf("-");
			}
			System.out.printf("\n"); 
		}

	}

}