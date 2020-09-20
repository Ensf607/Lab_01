package binaryTree;

public class App {
public static void main(String[] args) {
	Tree tree =new Tree();
	
	tree.insert(new Node("Ziad",10));
	tree.insert(new Node("Moe",5));
	tree.insert(new Node("Sam",2));
//	tree.insert(new Node("khaled",7));
	tree.insert(new Node("khaled",17));
//	tree.insert(new Node("khaled",12));
//	tree.insert(new Node("khaled",20));
//	tree.insert(new Node("Ziad",15));
//	tree.insert(new Node("Moe",22));
	tree.insert(new Node("Sam",-12));
//	tree.insert(new Node("khaled",-10));
//	tree.insert(new Node("khaled",-30));
//	tree.insert(new Node("khaled",40));
//	tree.insert(new Node("khaled",62));
//	tree.insert(new Node("khaled",-11));
//	tree.insert(new Node("khaled",-9));
//	tree.insert(new Node("khaled",3));
//	tree.insert(new Node("khaled",11));
//	tree.insert(new Node("khaled",15));
	tree.print();
//	Node result=tree.search(2);
//	Node parent=tree.findParent(result);
//	Node smallest=tree.findSmallest(result);
//	Node largest=tree.findLargest(result);
//	tree.delete(12);
	System.out.println("-------------");
//	tree.print();
//	System.out.println("-------------");
	Node result=tree.search(5);
	int t=tree.height(result);

	Node parent=tree.findParent(result);
	
//	System.out.println(tree.search(10).name);
	System.out.println(result+" Parnet is "+parent+" Its height is: "+t );
	
}
}
