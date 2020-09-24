package binaryTree;

public class Node {
	Node left, right;
	String name;
	int id;
	int balance;

	public Node(String name, int id) {
		this.id = id;
		this.name = name;
		this.left = null;
		this.right = null;
		this.balance = 0;
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
		return "ID: "+this.id +"| Name: "+this.name+"| Balance: " + balance;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
}
