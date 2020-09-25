package binaryTree;

public class Tree {
	Node root;

	public Tree() {
		root = null;
	}
	/**
	 * Regular insert method
	 * @param n
	 */
public void insert (Node n) {
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
					updateBalance(root);
					return;
				}
			}

			else if (n.getId() < pointer.getId()) {
				pointer = pointer.getLeft();
				if (pointer == null) {
					parent.setLeft(n);
					updateBalance(root);
					return;
				}
			} else {
				System.err.println(n + " Student already exisit");
				return;
			}

		}

	}

	
}
	/**
	 * This is insert method applies the AVL tree concept
	 * 
	 * @param n
	 */
	public void insertAVL(Node n) {
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
						updateBalance(root);
						// if pivot exist then unbalanced tree
						Node pivot = findPivot(n);
						if (pivot != null) {
							String type = rotationType(pivot, n);
							// checks type of rotation needed
							if (type == "LL") {
								rotateRight(pivot);
							} else if (type == "LR") {
								rotateLeft(pivot.left);
								rotateRight(pivot);
							} else if (type == "RR")
								rotateLeft(pivot);
							else if (type == "RL") {
								rotateRight(pivot.right);
								rotateLeft(pivot);
							} else {
								System.err.println("Rotation ERROR");
							}
							updateBalance(root);

						}

						return;
					}
				}

				else if (n.getId() < pointer.getId()) {
					pointer = pointer.getLeft();
					if (pointer == null) {
						parent.setLeft(n);
						updateBalance(root);
						// if pivot exist then unbalanced tree
						Node pivot = findPivot(n);
						if (pivot != null) {
							String type = rotationType(pivot, n);
							if (type == "LL") {
								rotateRight(pivot);
							} else if (type == "LR") {
								rotateLeft(pivot.left);
								rotateRight(pivot);
							} else if (type == "RR")
								rotateLeft(pivot);
							else if (type == "RL") {
								rotateRight(pivot.right);
								rotateLeft(pivot);
							} else {
								System.err.println("Rotation ERROR");
							}
							updateBalance(root);

						}
						return;
					}
				} else {
					System.err.println(n + " Student already exisit");
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

	public Node search(int id) {
		Node pointer = root;
		return searchDepthTrverse(pointer, id);
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

	/*
	 * 3 cases - leaf -deleting parent with one child - deleteing parent with two
	 * 
	 */
	public void delete(int id) {
		Node result = search(id);
		// checks if the node exists
		if (result == null) {
			System.out.println("Node doesnt exist");
			return;
		}
		Node parent = findParent(result);
		// if parent is not null i.e node is not root
		if (parent != null) {
			// if the result node is on the right side of the parent i.e right child
			if (result.getId() > parent.getId()) {
				// case 1 result is leaf node
				if (result.right == null && result.left == null) {
					parent.right = null;
					return;
				}

				// case 2 result is single child

				else if (result.right != null && result.left == null) {
					parent.right = result.right;
					return;
				} else if (result.right == null && result.left != null) {
					parent.right = result.left;
					return;
				}

				// case 3 result has two nodes
				else if (result.right != null && result.left != null) {
					// find smallest node in right tree
					Node smallest = findSmallest(result.right);
					Node smallestParent = findParent(smallest);
					// if smallest parent is the node to be deleted then special condition
					if (smallestParent == result) {
						if (smallest.right == null && smallest.left == null) {
							result.setId(smallest.id);
							result.setName(smallest.name);
							result.right = null;
							return;
						} else if (smallest.right != null && smallest.left == null) {
							result.setId(smallest.id);
							result.setName(smallest.name);
							result.right = smallest.right;
							return;

						}
					}

					// if smallest is a leaf node
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
				// case 1 result is leaf
				if (result.right == null && result.left == null) {
					parent.left = null;
					return;
				}
				// case 2 result has one child
				else if (result.right != null && result.left == null) {
					parent.left = result.right;
					return;
				} else if (result.right == null && result.left != null) {
					parent.left = result.left;
					return;
				}

				// case 3 result has two children
				else if (result.right != null && result.left != null) {
					// just another approach find largest in left subtree
					Node largest = findLargest(result.left);
					Node largestParent = findParent(largest);
					// checks if parent is actualy the delete node itself then special condition
					// need to have seperate if for it
					if (largestParent == result) {
						// if the largest is leaf
						if (largest.right == null && largest.left == null) {

							result.setId(largest.id);
							result.setName(largest.name);
							result.left = null;
							return;

						}
						// if largest has one child (it must be a left child)
						else if (largest.right == null && largest.left != null) {

							result.setId(largest.id);
							result.setName(largest.name);

							result.left = largest.left;
							return;

						}
						// case 1 if largest is a leaf
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

			}
			updateBalance(root);
		} else
			root = null;

	}

	/**
	 * Finds largest node after the passed node
	 * 
	 * @param node
	 * @return largest node
	 */
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

	/**
	 * Finds the smallest node after the passed node
	 * 
	 * @param result
	 * @return smallest node
	 */
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

	/**
	 * Finds the parent of the node
	 * 
	 * @param child
	 * @return
	 */
	public Node findParent(Node child) {
		Node pointer = root;
		if (pointer == child) {
			return null;
		}
		if (child == null) {
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

		return null;

	}

	/**
	 * Finds the height at each node
	 * 
	 * @param node
	 * @return
	 */
	public int height(Node node) {
		int heightLeft = 0;
		int heightRight = 0;
		if (node.left == null && node.right == null) {
			return 0;
		} else if (node.left != null || node.right != null) {
			if (node.left != null) {
				heightLeft += (height(node.left) + 1);
			}
			if (node.right != null) {
				heightRight += (height(node.right) + 1);
			}

		}
		return Math.max(heightLeft, heightRight);

	}

	/**
	 * Updates the balance at each node starting from root
	 * 
	 * @param node root
	 */
	public void updateBalance(Node node) {
		int heightL = 0, heightR = 0;
		if (node == null)
			return;
		if (node.left != null) {
			heightL = height(node.left) + 1;
		}
		if (node.right != null) {
			heightR = height(node.right) + 1;

		}
		node.setBalance(heightR - heightL);

		updateBalance(node.left);
		updateBalance(node.right);

	}

	/**
	 * Finds nearest pivot node after the newly inserted node
	 * 
	 * @param node
	 * @return the pivot if there is one
	 */
	public Node findPivot(Node node) {
		Node parent = findParent(node);

		while (parent != null) {
			if (parent.balance > 1 || parent.balance < -1) {
				return parent;
			}

			parent = findParent(parent);
		}
		return null;
	}

	/**
	 * Rotates left method for the AVL Tree
	 * 
	 * @param pivot
	 */
	public void rotateLeft(Node pivot) {
		Node son = pivot.right;
		Node sonTree = son.left;
		Node pivotParent = findParent(pivot);
		if (pivotParent != null) {
			if (pivotParent.right == pivot) {
				pivotParent.right = son;
				son.left = pivot;
				pivot.right = sonTree;
			} else if (pivotParent.left == pivot) {
				pivotParent.left = son;
				son.left = pivot;
				pivot.right = sonTree;
			}
		} else {
			root = son;
			son.left = pivot;
			pivot.right = sonTree;
		}

	}

	/**
	 * Rotates right method for the AVL Tree
	 * 
	 * @param pivot
	 */
	public void rotateRight(Node pivot) {
		Node son = pivot.left;
		Node sonTree = son.right;
		Node pivotParent = findParent(pivot);
		if (pivotParent != null) {
			if (pivotParent.left == pivot) {
				pivotParent.left = son;
				son.right = pivot;
				pivot.left = sonTree;
			} else if (pivotParent.right == pivot) {
				pivotParent.right = son;
				son.right = pivot;
				pivot.left = sonTree;
			}

		} else {
			root = son;
			son.right = pivot;
			pivot.left = sonTree;
		}

	}

	/**
	 * This method returns the rotation type that must be done
	 * 
	 * @param pivot
	 * @param inserted
	 * @return
	 */
	public String rotationType(Node pivot, Node inserted) {

		// right heavy
		if (pivot.balance > 0)

		{
			Node parent = findParent(inserted);
			if (parent.right == inserted)
				return "RR";
			else if (parent.left == inserted) {
				return "RL";

			}
		}
		// Left Heavy
		else if (pivot.balance < 0) {
			Node parent = findParent(inserted);
			if (parent.right == inserted)
				return "LR";
			else if (parent.left == inserted)
				return "LL";

		}
		return null;
	}

}
