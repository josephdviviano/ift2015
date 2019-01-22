
public class BinaryTree {
	private BinaryTreeNode root;
	private int n; //number of nodes
	private int[] pre;
	private int[] post;
	private int k;
	
	public BinaryTree() {
		super();
	}
	

	public void insert(int value){
		n++;
		if (root == null){
			root = new BinaryTreeNode(value);
		}else{
			BinaryTreeNode currentNode = root;
			BinaryTreeNode newNode = new BinaryTreeNode(value);
			while (true){
				if (value>currentNode.getValue()){//descend to the right
					if (currentNode.getRightChild() == null){//insert here
						currentNode.setRightChild(newNode);
						break;
					}else{
						currentNode = currentNode.getRightChild();
					}
				}else if (value<currentNode.getValue()){//descend to the left
					if (currentNode.getLeftChild() == null){//insert here
						currentNode.setLeftChild(newNode);
						break;
					}else{
						currentNode = currentNode.getLeftChild();
					}
				}else{// node already present, do nothing
					n--;
				}
			}
		}
	}
	
	public int[] preorderTraversal(){
		pre = new int[n];
		k = 0;
		preorder(root);		
		return pre;
	}
	
	public int[] postorderTraversal(){
		post = new int[n];
		k = 0;
		postorder(root);		
		return post;
	}
	
	public void preorder(BinaryTreeNode currentNode){
		if (currentNode != null){
			pre[k] = currentNode.getValue();
			k++;
			preorder(currentNode.getLeftChild());
			preorder(currentNode.getRightChild());
		}
	}
	
	public void postorder(BinaryTreeNode currentNode){
		if (currentNode != null){
			postorder(currentNode.getLeftChild());
			postorder(currentNode.getRightChild());
			post[k] = currentNode.getValue();
			k++;
		}
	}


	public BinaryTreeNode getRoot() {
		return root;
	}


	public void setRoot(BinaryTreeNode root) {
		this.root = root;
	}


	public int getN() {
		return n;
	}


	public void setN(int n) {
		this.n = n;
	}


	public int[] getPre() {
		return pre;
	}


	public void setPre(int[] pre) {
		this.pre = pre;
	}


	public int[] getPost() {
		return post;
	}


	public void setPost(int[] post) {
		this.post = post;
	}
	
}
