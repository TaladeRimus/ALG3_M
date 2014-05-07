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

	// Método para inserir um novo elemento na árvore
	public void InserirElemento(String i) {

		// O caminhamento na arvore vai começar a partir da raiz
		Elemento ElementoAux = raiz;

		// Cria um novo elemento com o valor a ser inserido
		Elemento NovoElemento = new Elemento(i);

		// Inicia o caminhamento na árvore
		while (ElementoAux != null) {

			// Verifica se o valor a ser inserido é maior que o valor do
			// elemento atual
			if (i.length() > ElementoAux.getValor()) {
				// Verifica se elemento direito é diferente de nulo
				if (ElementoAux.getElementoDireito() != null) // Se sim, pega o
															// elemento
															// direito para
															// continuar a
															// 	busca
					ElementoAux = ElementoAux.getElementoDireito();
				else { // Se não, insere o elemento como o elemento direito
					ElementoAux.setElementoDireito(NovoElemento);
					ElementoAux = null;
				}
				// Valor a ser inserido menor que o valor do elemento atual
			} else {
				// Verifica se elemento esquero é diferente de nulo
				if (ElementoAux.getElementoEsquerdo() != null) // Se sim, pega o
															// elemento
															// esquerdo para
															// continuar a
															// busca
					ElementoAux = ElementoAux.getElementoEsquerdo();
				else { // Se não, insere o elemento como o elemento esquerdo
					ElementoAux.setElementoEsquerdo(NovoElemento);
					ElementoAux = null;
				}
			}
		}
	}

	// Método para fazer o caminhamento "PreOrder"
	public static void PreOrder(Elemento elemento) {
		if (elemento != null) {
			System.out.print("\t" + elemento.returnValor());
			if (elemento.Interno()) {
				PreOrder(elemento.getElementoEsquerdo());
				PreOrder(elemento.getElementoDireito());
			}
		}
	}

	// Método para fazer o caminhamento "PostOrder"
	public static void PostOrder(Elemento elemento) {
		if (elemento != null) {
			if (elemento.Interno()) {
				PostOrder(elemento.getElementoEsquerdo());
				PostOrder(elemento.getElementoDireito());
			}
			System.out.print("\t" + elemento.returnValor());
		}
	}

	// Método para fazer o caminhamento "InOrder"
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

	// Método chamado para calcular Altura da árvore
	public static int Altura() {
		return CalculaAltura(raiz, 0);
	}

	// Método para calcular a Altura da árvore
	private static int CalculaAltura(Elemento elemento, int altura) {
		// Verifica se elemento é diferente de nulo
		if (elemento != null) {

			// Verifica se elemento atual é um elemento interno
			if (elemento.Interno()) {
				int AlturaAux1, AlturaAux2;
				// Chama o método para Calcular altura recursivamente, enviando
				// o elemento esquerdo e a altura atual + 1
				AlturaAux1 = CalculaAltura(elemento.getElementoEsquerdo(),
						altura + 1);

				// Chama o método para Calcular altura recursivamente, enviando
				// o elemento direito e a altura atual + 1
				AlturaAux2 = CalculaAltura(elemento.getElementoDireito(),
						altura + 1);

				// Verifica qual dos lados teve a maior altura e retorna
				if (AlturaAux1 > AlturaAux2)
					return AlturaAux1;
				else
					return AlturaAux2;

				// Se elemento atual é um elemento externo, apenas retorna a
				// altura recebida
			} else {
				return altura;
			}
		}
		return 0;
	}

	// Método Auxiliar do método para imprimir
	// Método Cria um Array onde cada posição do array representa um nível da
	// arvore.
	private ArrayList<Object> BuscaPai() {

		// Cria um array de niveis
		ArrayList<Object> ArrayNiveis = new ArrayList<Object>();

		// Cria um array auxiliar para fazer o laço
		ArrayList<Object> ArrayAux = new ArrayList<Object>();
		ArrayAux.add(this.raiz); // Inicia o array com o elemento Raiz

		ArrayNiveis.add(ArrayAux); // Adiciona no array de niveis o array
								   // contendo o elemento raiz

		
		while (ArrayAux.size() >= 1) {

			// Cria um array para receber o array do método BuscaFilhos
			ArrayList<Object> arrayFilhos = new ArrayList<Object>();

			
			arrayFilhos = BuscaFilhos(ArrayAux);

			// Adiciona o array recebido no array de níveis
			ArrayNiveis.add(arrayFilhos);

			// Verifica se o conteudo do array recebido tem algum elemento
			// válido, não nulo
			boolean Flag = false;
			for (int i = 0; i < arrayFilhos.size(); i++) {
				if (arrayFilhos.get(i) != null) {
					Flag = true; // Existe elemento válido
					break;
				}
			}

			// Se existe elemento válido, seta o array auxiliar com o array
			// recebido pelo método BuscaFilhos
			if (Flag)
				ArrayAux = arrayFilhos;
			else { // Se não existe elemento válido, remove esse último array do
				// array de níveis
				ArrayNiveis.remove(ArrayNiveis.indexOf(arrayFilhos));
				break;
			}
		}

		
		return ArrayNiveis;
	}

	// Método Auxiliar do Método BuscaPai
	// Método cria um array de filhos de acordo com o array passado
	private ArrayList<Object> BuscaFilhos(ArrayList<Object> array) {

		// Cria um novo array de filhos
		ArrayList<Object> arrayNovo = new ArrayList<Object>();

		// Percorre o array passado, adicionando no novo array o filho da
		// esquerda e da direita
		for (int i = 0; i < array.size(); i++) {
			// Recupera o elemento do array
			Elemento ElementoAux = (Elemento) array.get(i);

			// Verifica se elemento é diferente de nulo
			if (ElementoAux != null) { // Se sim, adiciona o elemento esquerdo e
									   // direito no novo array
				arrayNovo.add(ElementoAux.getElementoEsquerdo());
				arrayNovo.add(ElementoAux.getElementoDireito());
			} else { // Se não, adiciona dois valores nulos no novo array,
					 // indicando que não tem filhos
				arrayNovo.add(null);
				arrayNovo.add(null);
			}
		}

		
		return arrayNovo;
	}

	// Método para imprimir a árvore
	public void Imprimir() {

		
		ArrayList<Object> array = BuscaPai();

		// Verifica o tamanho do array da ultima posição do array de níveis
		ArrayList<Object> arraySize = (ArrayList<Object>) array.get(array
				.size() - 1);

		
		int tamanho = arraySize.size();


		for (int i = 0; i < array.size(); i++) {

			// Recupera o array da posição atual do array de niveis
			ArrayList<Object> array2 = (ArrayList<Object>) array.get(i);

			
			tamanho = tamanho / 2;

			if (i == array.size() - 1)
				System.out.printf(" ");

			for (int j = 0; j < array2.size(); j++) {

				int espacos; // Variavel que conterá quantos "\t" serão
				// necessários para desenhar o nível atual

				if (j == 0) // Se for o primeiro índice do FOR, recebe o próprio
							// tamanho
					espacos = tamanho;
				else
							// Se não, recebe o tamanho * 2
					espacos = tamanho * 2;

				// Percorre o número de espaços tabulando a impressão
				for (int k = 1; k <= espacos; k++)
					System.out.printf("\t");

				// Verifica se é o último nível que está sendo impresso na tela
				if ((i == array.size() - 1) && (j != 0))
					System.out.printf("\t "); // Se sim, insere alguns espaços
											// depois da tabulação

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