package nx.ds.bt;

import nx.element.Action;

public class TestTree {

	public static void main(String[] args) {
		BTNode<Integer> one = new BTNode<Integer>(1);
		BTNode<Integer> two = new BTNode<Integer>(2);
		BTNode<Integer> three = new BTNode<Integer>(3);
		BTNode<Integer> four = new BTNode<Integer>(4);
		BTNode<Integer> five = new BTNode<Integer>(5);
		BTNode<Integer> six = new BTNode<Integer>(6);
		BTNode<Integer> seven = new BTNode<Integer>(7);
		
		BTNode<Integer> root = one;
		root.setLeft(two);
		root.setRight(three);
		two.setLeft(four);
		two.setRight(five);
		three.setLeft(six);
		three.setRight(seven);
		
		BTUtil.inOrderTraverse(root, new Action<Integer>() {

			@Override
			public void invoke(Integer data) {
				System.out.println(data);
			}
		}, new Action<Integer>() {

			@Override
			public void invoke(Integer data) {
				System.out.println("End of level: "+data);
				
			}
		});
		
		System.out.println("Max Width = "+BTUtil.findMaxWidth(root));
	}
}
