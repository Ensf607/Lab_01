package binaryTree;

public class App {
public static void main(String[] args) {
	Tree tree =new Tree();
	
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
	tree.insert(new Node("khaled",9));
	tree.print();
	System.out.println("-------------");
	System.out.println("New Root is:"+tree.root);
	
	System.out.println("-------------");
	tree.delete(8);
	Node result=tree.search(10);
	Node parent=tree.findParent(result);
	
	System.out.println("The parent of "+result+" is: "+ parent);
	System.out.println("-------------");
	tree.print();
	
}
}
