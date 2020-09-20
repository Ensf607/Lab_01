package binaryTree;

public class Tree {
	Node root;

	public Tree() {
		root = null;
	}

	public void insert(Node n) {
		if (n == null)
			return;
		n.setLeft(null);
		n.setRight(null);
		if (root == null)
			root = n;
		else {
			Node pointer = root;
			while (true) {

				Node parent = pointer;
				if (n.getId() > pointer.getId()) {
					pointer = pointer.getRight();
					if (pointer == null) {
						parent.setRight(n);
						return;
					}

				} else if (n.getId() < pointer.getId()) {
					pointer = pointer.getLeft();
					if (pointer == null) {
						parent.setLeft(n);
						return;
					}
				} else {
					System.err.println(n+"Student already exisit");
					return;
				}

			}

		}
		
			
		}

	

	public void print() {
		Node pointer = root;
		depthTravers(pointer);

	}

	private void depthTravers(Node pointer) {
		if (pointer != null) {
			depthTravers(pointer.getLeft());
			System.out.println(pointer);
			depthTravers(pointer.getRight());
		}

	}
//---------------ToDO:-------------

	/*
	 * 3 cases - leaf -deleting parent with one child - deleteing parent with two
	 * child --(go right subtree and find smallest child then copy/paste to
	 */
	public Node search(int id) {
		Node pointer = root;
//	Node result=null;
//	System.out.println(searchDepthTrverse(pointer,id).toString());
		return searchDepthTrverse(pointer, id);
//	System.err.println(result);
//	System.out.println("-------------------");
//	searchDepthTrverse(pointer, id);
	}

	/**
	 * Depth First inorder Traverse
	 * 
	 * @param pointer
	 * @param id
	 * @param result
	 * @return
	 */
	private Node searchDepthTrverse(Node pointer, int id) {
		while (pointer != null) {

			if (pointer.getId() == id)
				return pointer;
			else if (id > pointer.getId())
				pointer = pointer.getRight();
			else if (id < pointer.getId())
				pointer = pointer.getLeft();

		}
		return null;
	}

	public void delete(int id) {
		Node result = search(id);
		//checks if the node exists
		if (result == null) {
			System.out.println("Node doesnt exist");
			return;
		}
		Node parent = findParent(result);
		//if parent is not null i.e node is not root
		if (parent != null) {
			//if the result node is on the right side of the parent i.e right child
			if (result.getId() > parent.getId()) {
				//case 1 result is leaf node
				if (result.right == null && result.left == null) {
					parent.right = null;
					return;
				}

				// case 2  result is single child

				else if (result.right != null && result.left == null) {
					parent.right = result.right;
					return;
				} else if (result.right == null && result.left != null) {
					parent.right = result.left;
					return;
				}

				// case 3 result has two nodes
				else if (result.right != null && result.left != null) {
					//find smallest node in right tree
					Node smallest = findSmallest(result.right);
					Node smallestParent = findParent(smallest);
					//if smallest parent is the node to be deleted then special condition
					if(smallestParent==result) {
						if (smallest.right == null && smallest.left == null) {
							result.setId(smallest.id);
							result.setName(smallest.name);
							result.right=null;
							return;
						}
						else if (smallest.right != null && smallest.left == null) {
							result.setId(smallest.id);
							result.setName(smallest.name);
							result.right=smallest.right;
							return;
							
						}}
					
						
					
					//if smallest is a leaf node
				else if (smallest.right == null && smallest.left == null) {

						smallest.left = null;
						result.setId(smallest.id);
						result.setName(smallest.name);
						return;
					}
					// if smallest node has one child ( It must be a right child only)
					else if (smallest.right != null && smallest.left == null) {
						smallestParent.left = smallest.right;
						result.setId(smallest.id);
						result.setName(smallest.name);
						return;
				
					}

				}
			}
			// if the result node is on the left side of the tree
			else if (result.getId() < parent.getId()) {
				//case 1 result is leaf
				if (result.right == null && result.left == null)
					{
					parent.left = null;
					return;
					}
				// case 2 result has one child
				else if (result.right != null && result.left == null)
					{
					parent.left = result.right;
					return;
					}
				else if (result.right == null && result.left != null)
					{
					parent.left = result.left;
					return;
					}

				// case 3 result has two children
				else if (result.right != null && result.left != null) {
					//just another approach find largest in left subtree
					Node largest = findLargest(result.left);
					Node largestParent = findParent(largest);
					System.err.println(largestParent+"  "+largest);
					//checks if parent is actualy the delete node itself then special condition need to have seperate if for it
					if(largestParent==result) {
						//if the largest is leaf
						if (largest.right == null && largest.left == null) {
							
							result.setId(largest.id);
							result.setName(largest.name);
							result.left=null;
							return;
							
							
							
						}
						//if largest has one child (it must be a left child)
						else if (largest.right == null && largest.left != null) {
					
							result.setId(largest.id);
							result.setName(largest.name);
							
							result.left=largest.left;
							return;
				
					}
					//case 1 if largest is a leaf
					if (largest.right == null && largest.left == null) {
						largestParent.right = null;
						result.setId(largest.id);
						result.setName(largest.name);
						return;
					
					// case 2 if largest has one child (must be left child

				
					} else if (largest.right == null && largest.left != null) {
						largestParent.right = largest.left;
						result.setId(largest.id);
						result.setName(largest.name);
						return;
					}

				}

			}

			}} else
			root = null;

	}

	public Node findLargest(Node node) {

		Node pointer = node;
		int temp = node.getId();
		Node largest = node;
		while (pointer != null) {
			if (pointer.getId() > temp) {
				temp = pointer.getId();
				largest = pointer;
			}
			pointer = pointer.right;
		}
		return largest;
	}

	public Node findSmallest(Node result) {
		int temp = result.id;
		Node pointer = result;
		Node smallestNode = result;
		while (pointer != null) {
			if (temp > pointer.id) {
				temp = pointer.id;
				smallestNode = pointer;
			}
			pointer = pointer.left;

		}

		return smallestNode;

	}

	public Node findParent(Node child) {
		Node pointer = root;
		if (pointer == child) {
			System.err.println("This is Root no parent");
			return null;
		}
		if (child==null) {
			System.err.println("NULL node");
			return null;
		}
		while (pointer != null) {
			if (pointer.right == child || pointer.left == child)
				return pointer;
			else if (child.id > pointer.id)
				pointer = pointer.right;
			else if (child.id < pointer.id)
				pointer = pointer.left;

		}

		return null;// parent is null in this case child is root?

	}

	public int height() {
		return 0;

	}

}
