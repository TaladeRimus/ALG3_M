package AVL;


/**
 * 
 * @author Adriano Duarte
 *
 */
	
	public class TreeAVL {
		 
		private TreeAVL esq, dir;
		private int altd, alte, num;
	 
	    public TreeAVL inserir(TreeAVL n, int num) {
	    	
	        // o objeto novo é um objeto auxiliar
	        TreeAVL novo;
	        
	        if (n == null) {
	            novo = new TreeAVL();
	            novo.num = num;
	            novo.altd = 0;
	            novo.alte = 0;
	            novo.esq = null;
	            novo.dir = null;
	            n = novo;
	        } else if (num < n.num) {
	            n.esq = inserir(n.esq, num);
	            if (n.esq.altd > n.esq.alte) {
	                n.alte = n.esq.altd + 1;
	            } else {
	                n.alte = n.esq.alte + 1;
	            }
	            n = balanceamento(n);
	        } else {
	            n.dir = inserir(n.dir, num);
	            if (n.dir.altd > n.dir.alte) {
	                n.altd = n.dir.altd + 1;
	            } else {
	                n.altd = n.dir.alte + 1;
	            }
	            n = balanceamento(n);
	        }
	        return n;
	    }
	 
	    public TreeAVL balanceamento(TreeAVL aux) {
	        int d, df;
	        d = aux.altd - aux.alte;
	        if (d == 2) {
	            df = aux.dir.altd - aux.dir.alte;
	            if (df >= 0) {
	                aux = rotacao_esquerda(aux);
	            } else {
	                aux.dir = rotacao_direita(aux.dir);
	                aux = rotacao_esquerda(aux);
	            }
	        } else if (d == -2) {
	            df = aux.esq.altd - aux.esq.alte;
	            if (df <= 0) {
	                aux = rotacao_direita(aux);
	            } else {
	                aux.esq = rotacao_esquerda(aux.esq);
	                aux = rotacao_direita(aux);
	            }
	        }
	        return aux;
	    }
	 
	    public TreeAVL rotacao_esquerda(TreeAVL aux) {
	    	TreeAVL aux1, aux2;
	        aux1 = aux.dir;
	        aux2 = aux1.esq;
	        aux.dir = aux2;
	        aux1.esq = aux;
	        if (aux.dir == null) {
	            aux.altd = 0;
	        } else if (aux.dir.alte > aux.dir.altd) {
	            aux.altd = aux.dir.alte + 1;
	        } else {
	            aux.altd = aux.dir.altd + 1;
	        }
	 
	        if (aux1.esq.alte > aux1.esq.altd) {
	            aux1.alte = aux1.esq.alte + 1;
	        } else {
	            aux1.alte = aux1.esq.altd + 1;
	        }
	        return aux1;
	    }
	 
	    public TreeAVL rotacao_direita(TreeAVL aux) {
	    	TreeAVL aux1, aux2;
	        aux1 = aux.esq;
	        aux2 = aux1.dir;
	        aux.esq = aux2;
	        aux1.dir = aux;
	        if (aux.esq == null) {
	            aux.alte = 0;
	        } else if (aux.esq.alte > aux.esq.altd) {
	            aux.alte = aux.esq.alte + 1;
	        } else {
	            aux.alte = aux.esq.altd + 1;
	        }
	 
	        if (aux1.dir.alte > aux1.dir.altd) {
	            aux1.altd = aux1.dir.alte + 1;
	        } else {
	            aux1.altd = aux1.dir.altd + 1;
	        }
	        return aux1;
	    }
	 
	    public void exibiremordem(TreeAVL aux) {
	        if (aux != null) {
	            System.out.print(aux.num + "  ");
	            exibiremordem(aux.esq);
	            exibiremordem(aux.dir);
	        }
	    }
	 
	    public void exibirpreordem(TreeAVL aux) {
	        if (aux != null) {
	            System.out.print(aux.num + ", ");
	            exibirpreordem(aux.esq);
	            exibirpreordem(aux.dir);
	        }
	    }
	 
	    public void exibirposordem(TreeAVL aux) {
	        if (aux != null) {
	            exibirposordem(aux.esq);
	            exibirposordem(aux.dir);
	            System.out.print(aux.num + ", ");
	        }
	    }
	 

	}


