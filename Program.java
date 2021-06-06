package BinarySearchTree;
public class Program {

	public static void main(String[] args) {
		SearchTree<Integer> arv = new SearchTree<Integer>(6);
		/* se os valores abaixos fossem inseridos fora de ordem, o resultado seria o mesmo ??? */
		arv.push(2);
		arv.push(8);
		arv.push(1);
		arv.push(4);
		arv.push(3);
		arv.push(5);
		arv.push(0);
		arv.push(10);

		System.out.println("Imprimindo a árvore:");
		arv.show();

		System.out.println("Imprimindo o galho esquerdo:");
		arv.getLeft().show();
		
		System.out.println("Imprimindo o galho direito:");
		arv.getRight().show();
		
		
		System.out.println("REMOVENDO 8");
		arv.erase(8);
		
		System.out.println("Imprimindo a árvore:");
		arv.show();

		System.out.println("Imprimindo o galho esquerdo:");
		arv.getLeft().show();
		
		System.out.println("Imprimindo o galho direito:");
		arv.getRight().show();
				
	}

}
/* Saídas esperadas no console:
Imprimindo a árvore:
1
2
3
4
6
8
Imprimindo a galho esquerdo:
1
2
3
4
Imprimindo com raiz 2:
1
2
3
4
Imprimindo a árvore sem o 2:
1
3
4
6
8
Nós à esquerda: 3
Nós à direira: 1
Nós à esquerda: 2
Nós à direira: 2
Imprimindo a árvore:
1
3
4
6
8 
*/