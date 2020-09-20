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
public void delete( int id) {
	Node result=search(id);
	if(result==null) {
		System.out.println("Node doesnt exist");
		return;
	}
	Node parent=findParent(result);
	

	if(parent !=null) {
		//case 1 leaf node
		if(result.getId()>parent.getId()) {
			if(result.right==null && result.left==null) {
			System.out.println("CASE 1");
			parent.right=null;
			return;
		}
		
		//case 2 single child
			
			else if(result.right!=null && result.left==null)
						{parent.right=result.right;
						return;
						}
			else if (result.right==null && result.left!=null)
					{parent.right=result.left;
					return;
					}
				 
	
		

		//case 3 parent  either smalles of right tree or largest of left tree
		/// A-- Right subtree
			else if(result.right!=null && result.left!=null) {
//				System.out.println("HERE");
			Node smallest=findSmallest(result);
			Node smallestParent=findParent(smallest);
			result.setId(smallest.id);
			result.setName(smallest.name);
//			System.err.println(result);
			System.err.println("smallest"+smallest+"   Parent: "+smallestParent);
			if(smallest.getId()>smallestParent.getId()) {
				if(smallest.right==null && smallest.left==null)
					{
					
					smallestParent.right=null;
					}
				else if(smallest.right!=null && smallest.left==null) {
					
					smallestParent.right=smallest.right;
				}
					
			else if (smallest.right==null && smallest.left!=null)
				smallestParent.right=smallest.left;}
		
		else if(smallest.getId()<smallestParent.getId()) {
				if(smallest.right==null && smallest.left==null)
					{
					
					smallest.left=null;
					}
		//case 2 single child
				else if(smallest.right!=null && smallest.left==null)
					smallestParent.left=smallest.right;
			else if (smallest.right==null && smallest.left!=null)
				smallest.left=smallest.left;
			
}
			
			
					
		}}
		
		else if(result.getId()<parent.getId()) {
			if(result.right==null && result.left==null)
				parent.left=null;
			else if(result.right!=null && result.left==null)
					parent.left=result.right;
			else if (result.right==null && result.left!=null)
				parent.left=result.left;
			
		/// B-- Left subtree
		else if(result.right!=null && result.left!=null) {
			
			Node largest=findLargest(result);
			Node largestParent=findParent(largest);
			result.setId(largest.id);
			result.setName(largest.name);
			if(largest.getId()>largestParent.getId()) {
					if(largest.right==null && largest.left==null)
						largestParent.right=null;
					else if(largest.right!=null && largest.left==null)
						largestParent.right=largest.right;
				else if (largest.right==null && largest.left!=null)
					largestParent.right=largest.left;}
			
			else if(largest.getId()<largestParent.getId()) {
					if(largest.right==null && largest.left==null)
						largest.left=null;
			//case 2 single child
					else if(largest.right!=null && largest.left==null)
						largestParent.left=largest.right;
				else if (largest.right==null && largest.left!=null)
					largestParent.left=largest.left;
				
	}
			
			
					
		}
			
		}} else
		root=null;
	
		
		
	
	}
	
	
public Node findLargest(Node node) {
	
	Node pointer=node;
	int temp=node.getId();
	Node largest=node;
	while(pointer!=null) {
		if(pointer.getId()>temp) {
			temp=pointer.getId();
			largest=pointer;
		}
		pointer=pointer.right;
	}
	return largest;
}
public Node findSmallest(Node result) {
	int temp=result.id;
	Node pointer=result;
	Node smallestNode=result;
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


