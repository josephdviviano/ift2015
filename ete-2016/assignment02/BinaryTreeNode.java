
public class BinaryTreeNode {
	int value;
	BinaryTreeNode leftChild;
	BinaryTreeNode rightChild;
	
	public BinaryTreeNode(int value, BinaryTreeNode leftChild, BinaryTreeNode rightChild) {
		super();
		this.value = value;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}

	public BinaryTreeNode(int value) {
		super();
		this.value = value;
		this.leftChild = null;
		this.rightChild = null;
	}
	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public BinaryTreeNode getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(BinaryTreeNode leftChild) {
		this.leftChild = leftChild;
	}

	public BinaryTreeNode getRightChild() {
		return rightChild;
	}

	public void setRightChild(BinaryTreeNode rightChild) {
		this.rightChild = rightChild;
	}
	
}
