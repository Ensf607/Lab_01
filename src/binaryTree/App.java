package binaryTree;

public class App {
public static void main(String[] args) {
	Tree tree =new Tree();
	tree.insert(new Node("Ziad",10));
	tree.insert(new Node("Moe",5));
	tree.insert(new Node("Sam",2));
	tree.insert(new Node("khaled",7));
	tree.insert(new Node("khaled",17));
	tree.insert(new Node("khaled",12));
	tree.insert(new Node("khaled",20));
	tree.print();
	Node result=tree.search(10);
	Node parent=tree.findParent(result);
	
//	System.out.println(tree.search(10).name);
	System.out.println(result+" PArnet is "+parent);
	
}
}
