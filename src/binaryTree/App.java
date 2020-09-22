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
//	tree.insert(new Node("khaled",40));
//	tree.insert(new Node("khaled",62));
//	tree.insert(new Node("khaled",-11));
//	tree.insert(new Node("khaled",-9));
//	tree.insert(new Node("khaled",3));
//	tree.insert(new Node("khaled",11));
//	tree.insert(new Node("khaled",15));
	tree.print();
	System.err.println(tree.root);
//	Node result=tree.search(2);
//	Node parent=tree.findParent(result);
//	Node smallest=tree.findSmallest(result);
//	Node largest=tree.findLargest(result);
//	tree.delete(12);
//	System.out.println("-------------");
//	tree.print();
//	System.out.println("-------------");
	Node result=tree.search(8);
//	Node pivot=tree.findPivot(result);
////	String type=tree.rotationType(result, result.left.right);
//	tree.rotateRight(pivot);
//	
	System.out.println("-------------");
//	tree.print();
//	System.out.println(type);
//	if(pivot!=null)
//		System.out.println(pivot);
//	int t=tree.height(result);
//	tree.print();
	Node parent=tree.findParent(result);
	
//	System.out.println(tree.search(10).name);
	System.out.println(parent);
	
}
}
