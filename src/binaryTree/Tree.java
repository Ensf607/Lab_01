package binaryTree;

public class Tree {
Node root;
public Tree() {
	root=null;
}
public void insert(Node n) {
	if (n==null)
			return;
	n.setLeft(null);
	n.setRight(null);
	if(root==null) 
		root=n;
	else {
		Node pointer=root;
		while(true) {
			
			Node parent=pointer;
		if(n.getId()>pointer.getId()) {
			pointer=pointer.getRight();
			if(pointer==null) {
				parent.setRight(n);
				return;
			}
			
			
			
		}
		else if(n.getId()<pointer.getId()) {
			pointer=pointer.getLeft();
			if(pointer==null) {
				parent.setLeft(n);
				return;
			}
		}
		else {
			System.out.println("Student already exisit");
			return;
		}
			
		}
		
	}
	
}
public void print() {
	Node pointer=root;
	depthTravers(pointer);
		
	}
private void depthTravers(Node pointer) {
	if(pointer!=null) {
		depthTravers(pointer.getLeft());
		System.out.println(pointer);
		depthTravers(pointer.getRight());
	}
	
}
//---------------ToDO:-------------

/*
 * 3 cases - leaf
 * 		   -deleting parent with one child
 * 		   - deleteing parent with two child --(go right subtree and find smallest child then copy/paste to 
 */
public Node search (int id) {
	Node pointer=root;
//	Node result=null;
//	System.out.println(searchDepthTrverse(pointer,id).toString());
	return searchDepthTrverse(pointer,id);
//	System.err.println(result);
//	System.out.println("-------------------");
//	searchDepthTrverse(pointer, id);
}
		
		/**
		 * Depth First inorder Traverse
		 * @param pointer
		 * @param id
		 * @param result 
		 * @return 
		 */
private Node searchDepthTrverse(Node pointer, int id) {
 while(pointer!=null) {
	 
if (pointer.getId()==id)
	return pointer;
else if(id>pointer.getId())
	pointer=pointer.getRight();
else if(id<pointer.getId())
	pointer=pointer.getLeft();

}
 return null;}
//public void delete( int id) {
//	Node result=search(id);
//	Node parent=findParent(result);
//
//	if(parent !=null) {
//		//case 1 leaf node
//		if(result.getId()>parent.getId() &&(result.right==null && result.left==null)) {
//			parent.right=null;
//		}
//		else if(result.getId()<parent.getId() &&(result.right==null && result.left==null))
//			parent.left=null;
//		//case 2 single child
//		else if(result.getId()>parent.getId()) {
//				if(result.right!=null && result.left==null)
//						parent.right=result.right;
//				else if (result.right==null && result.left!=null)
//					parent.right=result.left;
//				
//	}
//		else if(result.getId()<parent.getId()) {
//			if(result.right!=null && result.left==null)
//					parent.left=result.right;
//			else if (result.right==null && result.left!=null)
//				parent.left=result.left;
//			
//}
//		//case 3 parent  either smalles of right tree or largest of left tree
//		else if(result.getId()>parent.getId()) {
//			Node smallest=findSmallest(result);
//			Node smallestParent=findParent(smallest);
//			
//					
//		}
//			
//			
//		}
//		
//		
//	
//	}
//	
//	
//}
private Node findSmallest(Node result) {
	int temp=result.id;
	Node pointer=result;
	Node smallestNode=null;
	while(pointer!=null)
	{		if(temp>pointer.id)
			{
			temp=pointer.id;
			smallestNode=pointer;
			}
		pointer=pointer.left;
			
		}
		

		return smallestNode;
	
}
public Node findParent(Node child) {
Node pointer=root;
if(pointer==child) {
	System.out.println("This is Root no parent");
	return null;
}
while(pointer!=null)
{
	if(pointer.right==child || pointer.left==child) 
		return pointer;
		else if(child.id>pointer.id)
			pointer=pointer.right;
		else if(child.id<pointer.id)
			pointer=pointer.left;
		
	}
	

	return null;//parent is null in this case child is root?
	
}
public int height() {
	return 0;
	
}
	
}


