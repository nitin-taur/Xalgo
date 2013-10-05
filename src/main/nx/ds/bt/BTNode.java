package nx.ds.bt;

public class BTNode<T>{
	
	private T data;
	private BTNode<T> left;
	private BTNode<T> right;
	
	public BTNode(T data, BTNode<T> left, BTNode<T> right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
	public BTNode(T data) {
		this.data = data;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public BTNode<T> getLeft() {
		return left;
	}
	public void setLeft(BTNode<T> left) {
		this.left = left;
	}
	public BTNode<T> getRight() {
		return right;
	}
	public void setRight(BTNode<T> right) {
		this.right = right;
	}

}
