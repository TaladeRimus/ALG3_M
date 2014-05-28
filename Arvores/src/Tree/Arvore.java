package Tree;

import AVL.TreeAVL;

/**
 * 
 * @author Adriano Duarte
 *
 */

public class Arvore {
 

        
        TreeAVL node = new TreeAVL();

    	public TreeAVL insert(TreeAVL n, int num) {
    		return node.inserir(n, num);
    	}
        
    }