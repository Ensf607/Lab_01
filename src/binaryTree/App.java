package binaryTree;

public class App {
public static void main(String[] args) {
	Tree tree =new Tree();//this tree object uses regular insert method
	Tree treeAVL=new Tree();//this tree object uses modified insert method
	
	//inserting nodes for BTS
	tree.insert(new Node("Ziad",10));
	tree.insert(new Node("Moe",5));
	tree.insert(new Node("Sam",2));
	tree.insert(new Node("khaled",7));
	tree.insert(new Node("khaled",1));
	tree.insert(new Node("khaled",12));
	tree.insert(new Node("khaled",0));
	tree.insert(new Node("Ziad",11));
	tree.insert(new Node("Moe",-1));
	tree.insert(new Node("Sam",-2));
	tree.insert(new Node("khaled",8));
	tree.insert(new Node("khaled",9));
	//inserting same nodes for AVL tree
	treeAVL.insertAVL(new Node("Ziad",10));
	treeAVL.insertAVL(new Node("Moe",5));
	treeAVL.insertAVL(new Node("Sam",2));
	treeAVL.insertAVL(new Node("khaled",7));
	treeAVL.insertAVL(new Node("khaled",1));
	treeAVL.insertAVL(new Node("khaled",12));
	treeAVL.insertAVL(new Node("khaled",0));
	treeAVL.insertAVL(new Node("Ziad",11));
	treeAVL.insertAVL(new Node("Moe",-1));
	treeAVL.insertAVL(new Node("Sam",-2));
	treeAVL.insertAVL(new Node("khaled",8));
	treeAVL.insertAVL(new Node("khaled",9));
	/**************Testing****************/
	System.out.println("------------Regular Binary Tree------------");
	tree.print();
	System.out.println("------------Testing Search------------");
	System.out.println("Search for ID= 11 "+tree.search(11));
	tree.delete(11);
	System.out.println("------------Deleting then printing new tree------------");
	tree.print();
	System.out.println("------------Finding pivot------------");
	System.out.println("The nearest pivot to last node inserted ID=9 is:"+tree.findPivot(tree.search(9)));
	System.out.println("Type of rotation needed at pivot is "+tree.rotationType(tree.findPivot(tree.search(9)), tree.search(9)));//RR then left rotation
	tree.rotateLeft(tree.findPivot(tree.search(9)));
	tree.updateBalance(tree.root);
	System.out.println("------------printing updated subtree------------");
	tree.print();
	System.out.println("\nRoot is: "+tree.root+"\n");
	System.out.println("------------AVL Tree------------");
	treeAVL.print();
	System.out.println("\nNew Root is: "+treeAVL.root);
	System.out.println("-------------");

	
}
}
