package binaryTree;

public class Node {
	Node left,right;
	String name;
	int id;

	public Node(String name,int id) {
		this.id=id;
		this.name=name;
		this.left=null;
		this.right=null;
	}
	public Node getLeft() {
		return left;
	}
	public void setLeft(Node left) {
		this.left = left;
	}
	public Node getRight() {
		return right;
	}
	public void setRight(Node right) {
		this.right = right;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return this.name+", "+this.id;
	}

}
